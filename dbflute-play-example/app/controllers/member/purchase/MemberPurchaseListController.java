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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.PagingResultBean;

import play.api.mvc.Call;
import play.mvc.Controller;
import play.mvc.Result;

import com.example.dbflute.sastruts.common.PagingNavi;
import com.example.dbflute.sastruts.dbflute.cbean.MemberCB;
import com.example.dbflute.sastruts.dbflute.cbean.PurchaseCB;
import com.example.dbflute.sastruts.dbflute.exbhv.MemberBhv;
import com.example.dbflute.sastruts.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.dbflute.exentity.Purchase;
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
    //    @Resource
    protected MemberPurchaseListForm listForm;

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    //    @Execute(validator = false, urlPattern = "{memberId}/{pageNumber}")
    public Result index(final Integer memberId, final Integer pageNumber) {
        if (memberId == null) {
            return null; // TODO "/member/list/?redirect=true";
        }
        if (pageNumber == null) {
            return null; // TODO "/member/list/?redirect=true";
        }

        final Member member = selectMember(memberId);

        final DecimalFormat decimalFormat = new DecimalFormat("#,###");
        final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        final PagingResultBean<Purchase> purchasePage = selectPurchasePage(memberId, pageNumber);
        final List<MemberPurchaseWebBean> beanList = new ArrayList<MemberPurchaseWebBean>();
        for (Purchase purchase : purchasePage) {
            final MemberPurchaseWebBean bean = new MemberPurchaseWebBean();
            bean.purchaseId = purchase.getPurchaseId();
            bean.purchaseDatetime = dateTimeFormat.format(purchase.getPurchaseDatetime());
            bean.productName = purchase.getProduct().getProductName();
            bean.purchasePrice = decimalFormat.format(purchase.getPurchasePrice());
            bean.purchaseCount = decimalFormat.format(purchase.getPurchaseCount());
            bean.paymentComplete = purchase.isPaymentCompleteFlgTrue();
            beanList.add(bean);
        }
        final PagingNavi pagingNavi = newPagingNavi(memberId);
        pagingNavi.prepare(purchasePage, memberId);

        return ok(views.html.member.purchase.memberPurchaseList.render(member, beanList, pagingNavi));
    }

    private PagingNavi newPagingNavi(final Integer memberId) {
        return new PagingNavi() {
            @Override
            protected String createTargetPageNumberLink(int pageNumber, Object[] linkPaths) {
                final Call paging = controllers.member.purchase.routes.MemberPurchaseListController.index(memberId,
                        pageNumber);
                return paging.url();
            }
        };
    }

    //    @Execute(validator = false)
    public Result doDelete(final Integer memberId, final Long purchaseId) {
        final Purchase purchase = new Purchase();
        purchase.setPurchaseId(purchaseId);
        purchaseBhv.deleteNonstrict(purchase); // ここは排他制御なしの例 by jflute
        flash("success", String.format("会員(ID:%s)の購入履歴(ID:%s)を削除しました", memberId, purchaseId));
        return redirect(controllers.member.purchase.routes.MemberPurchaseListController.index(memberId, 1));
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
