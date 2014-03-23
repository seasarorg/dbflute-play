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

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.example.dbflute.sastruts.common.PagingNavi;
import com.example.dbflute.sastruts.dbflute.allcommon.CDef;
import com.example.dbflute.sastruts.dbflute.cbean.MemberCB;
import com.example.dbflute.sastruts.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.sastruts.dbflute.cbean.PurchaseCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.MemberStatus;

/**
 * 会員一覧アクション。
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class ListAction {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected ListForm listForm;

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberStatusBhv memberStatusBhv;

    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public List<MemberWebBean> beanList;
    public PagingNavi pagingNavi = new PagingNavi();
    public Map<String, String> memberStatusMap;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false, urlPattern = "{pageNumber}")
    public String index() {
        prepareListBox(); // ここだけだと doSearch() のバリデーションエラーでリストボックス消えます by jflute
        if (listForm.pageNumber != null && listForm.pageNumber > 0) { // 検索対象ページ番号が指定されていれば
            // /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = [TIPS by jflute]
            // Beansなんとかなど、リフレクションによる詰め替えは「絶対に利用しない」こと
            // http://dbflute.seasar.org/ja/tutorial/architect.html#entityset
            // = = = = = = = = = =/
            PagingResultBean<Member> memberPage = selectMemberPage(); // ここで検索しまっさ
            beanList = new ArrayList<MemberWebBean>();
            for (Member member : memberPage) { // 詰め詰め替え替え
                MemberWebBean bean = new MemberWebBean(); // ここでは画面項目DTOをWebBeanと名付けています by jflute
                bean.memberId = member.getMemberId();
                bean.memberName = member.getMemberName();
                bean.memberStatusName = member.getMemberStatus().getMemberStatusName();
                bean.formalizedDatetime = member.getFormalizedDatetime();
                bean.updateDatetime = member.getUpdateDatetime();
                bean.withdrawalMember = member.isMemberStatusCode退会会員();
                bean.purchaseCount = member.getPurchaseCount();
                beanList.add(bean);
            }

            // /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = [TIPS by jflute]
            // ページングナビゲーションの表示処理はinclude機能で再利用します。
            // それにより、以下のメリットがあります。
            //   o ページングナビゲーション部分のレイアウトを再利用できる (他の検索一覧画面が再利用)
            //   o ページングナビゲーション部分の表示処理を再利用できる (同上)
            //   o ページングナビゲーション処理を局所化してバグの発生を抑える (自動テストも一箇所で済む)
            //   o PagingResultBeanの利用を開発者に隠蔽する (誰か一人が最初に作れば良い)
            // = = = = = = = = = =/
            pagingNavi.prepare(memberPage);
        }
        return "index.jsp";
    }

    @Execute(validator = true, input = "index.jsp")
    public String doSearch() {
        listForm.pageNumber = 1;
        return index();
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
    protected void prepareListBox() { // ここはアプリによって色々かと by jflute
        Map<String, String> statusMap = new LinkedHashMap<String, String>();
        statusMap.put("", "選択してください");
        MemberStatusCB cb = new MemberStatusCB();
        cb.query().addOrderBy_DisplayOrder_Asc();
        ListResultBean<MemberStatus> memberStatusList = memberStatusBhv.selectList(cb);
        for (MemberStatus status : memberStatusList) {
            statusMap.put(status.getMemberStatusCode(), status.getMemberStatusName());
        }
        memberStatusMap = statusMap;
    }

    protected PagingResultBean<Member> selectMemberPage() { // ここはまさしくDBFlute by jflute
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().derivedPurchaseList().count(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseId();
            }
        }, Member.ALIAS_purchaseCount);

        cb.query().setMemberName_LikeSearch(listForm.memberName, new LikeSearchOption().likeContain());
        final String purchaseProductName = listForm.purchaseProductName;
        final boolean unpaid = listForm.unpaid;
        if ((purchaseProductName != null && purchaseProductName.trim().length() > 0) || unpaid) {
            cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                public void query(PurchaseCB subCB) {
                    subCB.query().queryProduct()
                            .setProductName_LikeSearch(purchaseProductName, new LikeSearchOption().likeContain());
                    if (unpaid) {
                        subCB.query().setPaymentCompleteFlg_Equal_False();
                    }
                }
            });
        }
        cb.query().setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.codeOf(listForm.memberStatus));
        Date formalizedDateFrom = DfTypeUtil.toDate(listForm.formalizedDateFrom);
        Date formalizedDateTo = DfTypeUtil.toDate(listForm.formalizedDateTo);
        cb.query().setFormalizedDatetime_DateFromTo(formalizedDateFrom, formalizedDateTo);

        cb.query().addOrderBy_UpdateDatetime_Desc();
        cb.query().addOrderBy_MemberId_Asc();

        int pageSize = 4; // 本当はコンフィグなどから取得するのが好ましい by jflute
        cb.paging(pageSize, listForm.pageNumber);

        return memberBhv.selectPage(cb);
    }
}
