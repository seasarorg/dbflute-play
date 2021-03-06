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
package controllers.member;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.util.DfTypeUtil;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.example.dbflute.sastruts.dbflute.allcommon.CDef;
import com.example.dbflute.sastruts.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.MemberStatus;
import com.example.dbflute.sastruts.web.DoCreate;
import com.example.dbflute.sastruts.web.member.MemberForm;

/**
 * 会員追加アクション。
 * @author jflute (modifies contributed source)
 */
public class MemberAddController extends Controller {

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
    //    @Execute(validator = false)
    public Result index() {
        final Map<String, String> memberStatusMap = prepareListBox();
        final Form<MemberForm> form = Form.form(MemberForm.class);
        return ok(views.html.member.memberAdd.render(form, memberStatusMap));
    }

    //    @Execute(validator = true, input = "index.jsp")
    public Result doAdd() {
        final Form<MemberForm> form = Form.form(MemberForm.class, DoCreate.class).bindFromRequest();
        if (form.hasErrors()) {
            final Map<String, String> memberStatusMap = prepareListBox();
            return badRequest(views.html.member.memberAdd.render(form, memberStatusMap));
        }
        final MemberForm memberForm = form.get();
        final Member member = new Member();
        member.setMemberName(memberForm.memberName);
        member.setBirthdate(DfTypeUtil.toDate(memberForm.birthdate));
        member.setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.codeOf(memberForm.memberStatusCode));
        member.setMemberAccount(memberForm.memberAccount);
        if (member.isMemberStatusCode正式会員()) { // 区分値の判定は Entity の isなんとか() メソッドで by jflute
            Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // 実際のアプリでは現在日時取得は統一的に by jflute
            member.setFormalizedDatetime(currentTime);
        }
        memberBhv.insert(member);
        flash("success", String.format("会員[%s (ID:%s)]を作成しました", member.getMemberName(), member.getMemberId()));
        return redirect(controllers.member.routes.MemberAddController.index());
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
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
