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
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.example.dbflute.sastruts.dbflute.allcommon.CDef;
import com.example.dbflute.sastruts.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.MemberStatus;

/**
 * 会員追加アクション。
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class AddAction {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected MemberForm memberForm;

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
    @Execute(validator = false)
    public String index() {
        prepareListBox(); // ここだけだと doSearch() のバリデーションエラーでリストボックス消えます by jflute
        return "index.jsp";
    }

    @Execute(validator = true, input = "index.jsp")
    public String doAdd() {
        Member member = new Member();
        member.setMemberId(Integer.valueOf(memberForm.memberId));
        member.setMemberName(memberForm.memberName);
        member.setBirthdate(DfTypeUtil.toDate(memberForm.birthdate));
        member.setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.codeOf(memberForm.memberStatusCode));
        member.setMemberAccount(memberForm.memberAccount);
        if (member.isMemberStatusCode正式会員()) { // 区分値の判定は Entity の isなんとか() メソッドで by jflute
            Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // 実際のアプリでは現在日時取得は統一的に by jflute
            member.setFormalizedDatetime(currentTime);
        }
        member.setVersionNo(Long.valueOf(memberForm.versionNo));
        memberBhv.insert(member);
        return "/member/add/&redirect=true";
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
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
