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
package controllers.member.purchase;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.PagingResultBean;

import play.mvc.Controller;
import play.mvc.Result;

import com.example.dbflute.sastruts.common.PagingNavi;
import com.example.dbflute.sastruts.dbflute.cbean.MemberCB;
import com.example.dbflute.sastruts.dbflute.cbean.PurchaseCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.Purchase;
import com.example.dbflute.sastruts.web.member.MemberWebBean;
import com.example.dbflute.sastruts.web.member.purchase.MemberPurchaseListForm;
import com.example.dbflute.sastruts.web.member.purchase.MemberPurchaseWebBean;

/**
 * @author mokkouyou (initial making)
 * @author jflute (extends it)
 */
public class MemberPurchaseListController extends Controller {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    //    @ActionForm
    @Resource
    protected MemberPurchaseListForm listForm;

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public MemberWebBean headerBean;
    public List<MemberPurchaseWebBean> beanList;
    public PagingNavi pagingNavi = new PagingNavi();

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    //    @Execute(validator = false, urlPattern = "{memberId}/{pageNumber}")
    public Result index(Integer memberId, Integer pageNumber) {
        if (memberId == null) {
            return null; // TODO "/member/list/?redirect=true";
        }
        if (pageNumber == null) {
            return null; // TODO "/member/list/?redirect=true";
        }

        Member member = selectMember(memberId);
        headerBean = new MemberWebBean();
        headerBean.memberId = member.getMemberId();
        headerBean.memberName = member.getMemberName();

        PagingResultBean<Purchase> purchasePage = selectPurchasePage(memberId, pageNumber);
        beanList = new ArrayList<MemberPurchaseWebBean>();
        for (Purchase purchase : purchasePage) {
            MemberPurchaseWebBean bean = new MemberPurchaseWebBean();
            bean.purchaseId = purchase.getPurchaseId();
            bean.purchaseDatetime = purchase.getPurchaseDatetime();
            bean.productName = purchase.getProduct().getProductName();
            bean.purchasePrice = purchase.getPurchasePrice();
            bean.purchaseCount = purchase.getPurchaseCount();
            bean.paymentComplete = purchase.isPaymentCompleteFlgTrue();
            beanList.add(bean);
        }
        pagingNavi.prepare(purchasePage, memberId);

        return null; // TODO "index.jsp";
    }

    //    @Execute(validator = false)
    public String doDelete() {
        Integer memberId = listForm.memberId;
        if (memberId == null) {
            return "/member/list/?redirect=true";
        }
        Long purchaseId = listForm.purchaseId;
        if (purchaseId == null) {
            return "/member/list/?redirect=true";
        }

        Purchase purchase = new Purchase();
        purchase.setPurchaseId(listForm.purchaseId);
        purchaseBhv.deleteNonstrict(purchase); // ここは排他制御なしの例 by jflute
        return null; // index();
    }

    // ===================================================================================
    //                                                                               Logic
    //                                                                               =====
    protected Member selectMember(Integer memberId) {
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(memberId);
        return memberBhv.selectEntityWithDeletedCheck(cb);
    }

    protected PagingResultBean<Purchase> selectPurchasePage(Integer memberId, Integer pageNumber) {
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Product();
        cb.query().setMemberId_Equal(memberId);
        cb.query().addOrderBy_PurchaseDatetime_Desc();
        int pageSize = 4; // 本当はコンフィグなどから取得するのが好ましい by jflute
        cb.paging(pageSize, pageNumber);
        return purchaseBhv.selectPage(cb);
    }
}
