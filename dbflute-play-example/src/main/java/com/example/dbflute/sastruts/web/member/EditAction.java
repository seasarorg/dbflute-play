/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.sastruts.web.member;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.example.dbflute.sastruts.dbflute.allcommon.CDef;
import com.example.dbflute.sastruts.dbflute.cbean.MemberCB;
import com.example.dbflute.sastruts.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.sastruts.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.MemberStatus;

/**
 * 会員編集アクション。
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class EditAction {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    public MemberForm memberForm;

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberStatusBhv memberStatusBhv;

    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public Map<String, String> memberStatusMap;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false, urlPattern = "{memberId}")
    public String index() {
        String memberId = memberForm.memberId;
        if (memberId == null) {
            return "/member/list/?redirect=true";
        }
        prepareListBox(); // ここだけだと doSearch() のバリデーションエラーでリストボックス消えます by jflute

        // /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = [TIPS by jflute]
        // Beansなんとかなど、リフレクションによる詰め替えは「絶対に利用しない」こと
        // http://dbflute.seasar.org/ja/tutorial/architect.html#entityset
        // = = = = = = = = = =/
        Member member = selectMember(Integer.valueOf(memberId));
        memberForm.memberId = member.getMemberId().toString();
        memberForm.memberName = member.getMemberName();
        memberForm.memberAccount = member.getMemberAccount();
        memberForm.memberStatusCode = member.getMemberStatusCode();
        // 日付フォーマットのやり方はアプリによって色々かと by jflute
        String ymd = "yyyy/MM/dd";
        memberForm.birthdate = DfTypeUtil.toString(member.getBirthdate(), ymd);
        memberForm.formalizedDate = DfTypeUtil.toString(member.getFormalizedDatetime(), ymd);
        String ymdhms = "yyyy/MM/dd HH:mm:ss";
        memberForm.latestLoginDatetime = DfTypeUtil.toString(member.getLatestLoginDatetime(), ymdhms);
        memberForm.updateDatetime = DfTypeUtil.toString(member.getUpdateDatetime(), ymdhms);
        memberForm.previousStatusCode = member.getMemberStatusCode(); // to determine new formalized member
        memberForm.versionNo = member.getVersionNo().toString();

        return "index.jsp";
    }

    @Execute(validator = true, input = "index.jsp")
    public String doUpdate() {
        Member member = new Member();
        member.setMemberId(Integer.valueOf(memberForm.memberId));
        member.setMemberName(memberForm.memberName);
        member.setBirthdate(DfTypeUtil.toDate(memberForm.birthdate));
        member.setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.codeOf(memberForm.memberStatusCode));
        member.setMemberAccount(memberForm.memberAccount);
        CDef.MemberStatus previousStatus = CDef.MemberStatus.codeOf(memberForm.previousStatusCode);
        if (member.isMemberStatusCode正式会員()) {
            if (previousStatus != null && previousStatus.isShortOfFormalized()) {
                Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // 実際のアプリでは現在日時取得は統一的に by jflute
                member.setFormalizedDatetime(currentTime);
            }
        } else if (member.isMemberStatusCode_ShortOfFormalized()) {
            member.setFormalizedDatetime(null);
        }
        member.setVersionNo(Long.valueOf(memberForm.versionNo));
        memberBhv.update(member);
        return memberForm.memberId;
    }

    @Execute(validator = true, input = "index.jsp")
    public String doDelete() {
        Member member = new Member();
        member.setMemberId(Integer.valueOf(memberForm.memberId));
        member.setMemberStatusCode_退会会員();
        member.setVersionNo(Long.valueOf(memberForm.versionNo));
        memberBhv.update(member);
        return "/member/list/?redirect=true";
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
    /**
     * @param memberId The ID of member. (NotNull)
     * @return The entity of selected member. (NotNull)
     * @throws EntityAlreadyDeletedException When the entity has already been deleted.
     */
    protected Member selectMember(Integer memberId) {
        final MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
            }
        }, Member.ALIAS_latestLoginDatetime);
        cb.query().setMemberId_Equal(memberId);
        cb.query().setMemberStatusCode_NotEqual_退会会員();
        return memberBhv.selectEntityWithDeletedCheck(cb);
    }

    protected void prepareListBox() { // ここはアプリによって色々かと by jflute
        Map<String, String> statusMap = new LinkedHashMap<String, String>();
        MemberStatusCB cb = new MemberStatusCB();
        cb.query().addOrderBy_DisplayOrder_Asc();
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb);
        for (MemberStatus status : statusList) {
            statusMap.put(status.getMemberStatusCode(), status.getMemberStatusName());
        }
        memberStatusMap = statusMap;
    }
}
