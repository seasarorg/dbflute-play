/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
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
package controllers.member;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.dbflute.util.DfTypeUtil;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.example.dbflute.sastruts.dbflute.allcommon.CDef;
import com.example.dbflute.sastruts.dbflute.cbean.MemberCB;
import com.example.dbflute.sastruts.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.sastruts.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.MemberStatus;
import com.example.dbflute.sastruts.web.DoDelete;
import com.example.dbflute.sastruts.web.DoUpdate;
import com.example.dbflute.sastruts.web.member.MemberForm;

/**
 * 会員編集アクション。
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class MemberEditController extends Controller {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberStatusBhv memberStatusBhv;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    //    @Execute(validator = false, urlPattern = "{memberId}")
    public Result index(Integer memberId) {
        if (memberId == null) {
            return null; // TODO "/member/list/?redirect=true";
        }

        final Map<String, String> memberStatusMap = prepareListBox(); // ここだけだと doSearch() のバリデーションエラーでリストボックス消えます by jflute

        // /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = [TIPS by jflute]
        // Beansなんとかなど、リフレクションによる詰め替えは「絶対に利用しない」こと
        // http://dbflute.seasar.org/ja/tutorial/architect.html#entityset
        // = = = = = = = = = =/
        final Member member = selectMember(Integer.valueOf(memberId));
        final MemberForm memberForm = new MemberForm();
        memberForm.memberId = member.getMemberId().toString();
        memberForm.memberName = member.getMemberName();
        memberForm.memberAccount = member.getMemberAccount();
        memberForm.memberStatusCode = member.getMemberStatusCode();
        // 日付フォーマットのやり方はアプリによって色々かと by jflute
        final String ymd = "yyyy/MM/dd";
        memberForm.birthdate = DfTypeUtil.toString(member.getBirthdate(), ymd);
        memberForm.formalizedDate = DfTypeUtil.toString(member.getFormalizedDatetime(), ymd);
        final String ymdhms = "yyyy/MM/dd HH:mm:ss";
        memberForm.latestLoginDatetime = DfTypeUtil.toString(member.getLatestLoginDatetime(), ymdhms);
        memberForm.updateDatetime = DfTypeUtil.toString(member.getUpdateDatetime(), ymdhms);
        memberForm.previousStatusCode = member.getMemberStatusCode(); // to determine new formalized member
        memberForm.versionNo = member.getVersionNo().toString();

        final Form<MemberForm> form = Form.form(MemberForm.class).fill(memberForm);

        return ok(views.html.member.memberEdit.render(form, memberStatusMap, member));
    }

    //    @Execute(validator = true, input = "index.jsp")
    public Result doUpdate(final Integer memberId) {
        final Form<MemberForm> form = Form.form(MemberForm.class, DoUpdate.class).bindFromRequest();
        // 押下されたsubmitボタンを判断する
        if (form.data().containsKey("doDelete")) {
            return doDelete(memberId);
        }
        final Member member = new Member();
        member.setMemberId(memberId);
        if (form.hasErrors()) {
            final Map<String, String> memberStatusMap = prepareListBox();
            return badRequest(views.html.member.memberEdit.render(form, memberStatusMap, member));
        }

        final MemberForm memberForm = form.get();
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
        if (member.isMemberStatusCode退会会員()) {
            // 退会の場合は「強制退会」ボタンと遷移を同じにする
            return withdrawalCompleted(member);
        } else {
            flash("success", String.format("会員[%s (ID:%s)]を更新しました", member.getMemberName(), member.getMemberId()));
            return redirect(controllers.member.routes.MemberEditController.index(memberId));
        }
    }

    private Result doDelete(final Integer memberId) {
        final Form<MemberForm> form = Form.form(MemberForm.class, DoDelete.class).bindFromRequest();
        final MemberForm memberForm = form.get();
        final Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberStatusCode_退会会員();
        member.setVersionNo(Long.valueOf(memberForm.versionNo));
        memberBhv.update(member);
        return withdrawalCompleted(member);
    }

    private Result withdrawalCompleted(final Member member) {
        flash("success", String.format("会員[%s (ID:%s)]を退会しました", member.getMemberName(), member.getMemberId()));
        return redirect(controllers.member.routes.MemberListController.index());
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

    protected Map<String, String> prepareListBox() { // ここはアプリによって色々かと by jflute
        Map<String, String> statusMap = new LinkedHashMap<String, String>();
        MemberStatusCB cb = new MemberStatusCB();
        cb.query().addOrderBy_DisplayOrder_Asc();
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb);
        for (MemberStatus status : statusList) {
            statusMap.put(status.getMemberStatusCode(), status.getMemberStatusName());
        }
        return statusMap;
    }

}
