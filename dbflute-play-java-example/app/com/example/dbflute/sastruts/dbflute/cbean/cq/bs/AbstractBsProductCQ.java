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
package com.example.dbflute.sastruts.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.sastruts.dbflute.allcommon.*;
import com.example.dbflute.sastruts.dbflute.cbean.*;
import com.example.dbflute.sastruts.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of PRODUCT.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsProductCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsProductCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "PRODUCT";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productId The value of productId as equal. (NullAllowed: if null, no condition)
     */
    public void setProductId_Equal(Integer productId) {
        doSetProductId_Equal(productId);
    }

    protected void doSetProductId_Equal(Integer productId) {
        regProductId(CK_EQ, productId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productId The value of productId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setProductId_NotEqual(Integer productId) {
        doSetProductId_NotEqual(productId);
    }

    protected void doSetProductId_NotEqual(Integer productId) {
        regProductId(CK_NES, productId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productId The value of productId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setProductId_GreaterThan(Integer productId) {
        regProductId(CK_GT, productId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productId The value of productId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setProductId_LessThan(Integer productId) {
        regProductId(CK_LT, productId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productId The value of productId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setProductId_GreaterEqual(Integer productId) {
        regProductId(CK_GE, productId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productId The value of productId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setProductId_LessEqual(Integer productId) {
        regProductId(CK_LE, productId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param minNumber The min number of productId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of productId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setProductId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueProductId(), "PRODUCT_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productIdList The collection of productId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductId_InScope(Collection<Integer> productIdList) {
        doSetProductId_InScope(productIdList);
    }

    protected void doSetProductId_InScope(Collection<Integer> productIdList) {
        regINS(CK_INS, cTL(productIdList), getCValueProductId(), "PRODUCT_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     * @param productIdList The collection of productId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductId_NotInScope(Collection<Integer> productIdList) {
        doSetProductId_NotInScope(productIdList);
    }

    protected void doSetProductId_NotInScope(Collection<Integer> productIdList) {
        regINS(CK_NINS, cTL(productIdList), getCValueProductId(), "PRODUCT_ID");
    }

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select PRODUCT_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by PRODUCT_ID, named 'purchaseAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsPurchaseList</span>(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of PurchaseList for 'exists'. (NotNull)
     */
    public void existsPurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepProductId_ExistsReferrer_PurchaseList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "PRODUCT_ID", "PRODUCT_ID", pp, "purchaseList");
    }
    public abstract String keepProductId_ExistsReferrer_PurchaseList(PurchaseCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select PRODUCT_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by PRODUCT_ID, named 'purchaseAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsPurchaseList</span>(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of ProductId_NotExistsReferrer_PurchaseList for 'not exists'. (NotNull)
     */
    public void notExistsPurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepProductId_NotExistsReferrer_PurchaseList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "PRODUCT_ID", "PRODUCT_ID", pp, "purchaseList");
    }
    public abstract String keepProductId_NotExistsReferrer_PurchaseList(PurchaseCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select PRODUCT_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by PRODUCT_ID, named 'purchaseAsOne'.
     * @param subQuery The sub-query of PurchaseList for 'in-scope'. (NotNull)
     */
    public void inScopePurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductId_InScopeRelation_PurchaseList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "PRODUCT_ID", "PRODUCT_ID", pp, "purchaseList");
    }
    public abstract String keepProductId_InScopeRelation_PurchaseList(PurchaseCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select PRODUCT_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by PRODUCT_ID, named 'purchaseAsOne'.
     * @param subQuery The sub-query of PurchaseList for 'not in-scope'. (NotNull)
     */
    public void notInScopePurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductId_NotInScopeRelation_PurchaseList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "PRODUCT_ID", "PRODUCT_ID", pp, "purchaseList");
    }
    public abstract String keepProductId_NotInScopeRelation_PurchaseList(PurchaseCQ sq);

    public void xsderivePurchaseList(String fn, SubQuery<PurchaseCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pp = keepProductId_SpecifyDerivedReferrer_PurchaseList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(fn, cb.query(), "PRODUCT_ID", "PRODUCT_ID", pp, "purchaseList", al, op);
    }
    public abstract String keepProductId_SpecifyDerivedReferrer_PurchaseList(PurchaseCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from PURCHASE where ...)} <br />
     * (購入)PURCHASE by PRODUCT_ID, named 'purchaseAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedPurchaseList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<PurchaseCB> derivedPurchaseList() {
        return xcreateQDRFunctionPurchaseList();
    }
    protected HpQDRFunction<PurchaseCB> xcreateQDRFunctionPurchaseList() {
        return new HpQDRFunction<PurchaseCB>(new HpQDRSetupper<PurchaseCB>() {
            public void setup(String fn, SubQuery<PurchaseCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderivePurchaseList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderivePurchaseList(String fn, SubQuery<PurchaseCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String sqpp = keepProductId_QueryDerivedReferrer_PurchaseList(cb.query()); // for saving query-value.
        String prpp = keepProductId_QueryDerivedReferrer_PurchaseListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "PRODUCT_ID", "PRODUCT_ID", sqpp, "purchaseList", rd, vl, prpp, op);
    }
    public abstract String keepProductId_QueryDerivedReferrer_PurchaseList(PurchaseCQ sq);
    public abstract String keepProductId_QueryDerivedReferrer_PurchaseListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     */
    public void setProductId_IsNull() { regProductId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * PRODUCT_ID: {PK, ID, NotNull, INTEGER(10)}
     */
    public void setProductId_IsNotNull() { regProductId(CK_ISNN, DOBJ); }

    protected void regProductId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductId(), "PRODUCT_ID"); }
    protected abstract ConditionValue getCValueProductId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品名称)PRODUCT_NAME: {IX, NotNull, VARCHAR(50)}
     * @param productName The value of productName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductName_Equal(String productName) {
        doSetProductName_Equal(fRES(productName));
    }

    protected void doSetProductName_Equal(String productName) {
        regProductName(CK_EQ, productName);
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品名称)PRODUCT_NAME: {IX, NotNull, VARCHAR(50)}
     * @param productName The value of productName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductName_PrefixSearch(String productName) {
        setProductName_LikeSearch(productName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品名称)PRODUCT_NAME: {IX, NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setProductName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param productName The value of productName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setProductName_LikeSearch(String productName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(productName), getCValueProductName(), "PRODUCT_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品名称)PRODUCT_NAME: {IX, NotNull, VARCHAR(50)}
     * @param productName The value of productName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setProductName_NotLikeSearch(String productName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(productName), getCValueProductName(), "PRODUCT_NAME", likeSearchOption);
    }

    protected void regProductName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductName(), "PRODUCT_NAME"); }
    protected abstract ConditionValue getCValueProductName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)}
     * @param productHandleCode The value of productHandleCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductHandleCode_Equal(String productHandleCode) {
        doSetProductHandleCode_Equal(fRES(productHandleCode));
    }

    protected void doSetProductHandleCode_Equal(String productHandleCode) {
        regProductHandleCode(CK_EQ, productHandleCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)}
     * @param productHandleCode The value of productHandleCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductHandleCode_NotEqual(String productHandleCode) {
        doSetProductHandleCode_NotEqual(fRES(productHandleCode));
    }

    protected void doSetProductHandleCode_NotEqual(String productHandleCode) {
        regProductHandleCode(CK_NES, productHandleCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)}
     * @param productHandleCodeList The collection of productHandleCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductHandleCode_InScope(Collection<String> productHandleCodeList) {
        doSetProductHandleCode_InScope(productHandleCodeList);
    }

    public void doSetProductHandleCode_InScope(Collection<String> productHandleCodeList) {
        regINS(CK_INS, cTL(productHandleCodeList), getCValueProductHandleCode(), "PRODUCT_HANDLE_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)}
     * @param productHandleCodeList The collection of productHandleCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductHandleCode_NotInScope(Collection<String> productHandleCodeList) {
        doSetProductHandleCode_NotInScope(productHandleCodeList);
    }

    public void doSetProductHandleCode_NotInScope(Collection<String> productHandleCodeList) {
        regINS(CK_NINS, cTL(productHandleCodeList), getCValueProductHandleCode(), "PRODUCT_HANDLE_CODE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)}
     * @param productHandleCode The value of productHandleCode as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductHandleCode_PrefixSearch(String productHandleCode) {
        setProductHandleCode_LikeSearch(productHandleCode, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)} <br />
     * <pre>e.g. setProductHandleCode_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param productHandleCode The value of productHandleCode as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setProductHandleCode_LikeSearch(String productHandleCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(productHandleCode), getCValueProductHandleCode(), "PRODUCT_HANDLE_CODE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (商品ハンドルコード)PRODUCT_HANDLE_CODE: {UQ, NotNull, VARCHAR(100)}
     * @param productHandleCode The value of productHandleCode as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setProductHandleCode_NotLikeSearch(String productHandleCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(productHandleCode), getCValueProductHandleCode(), "PRODUCT_HANDLE_CODE", likeSearchOption);
    }

    protected void regProductHandleCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductHandleCode(), "PRODUCT_HANDLE_CODE"); }
    protected abstract ConditionValue getCValueProductHandleCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY}
     * @param productCategoryCode The value of productCategoryCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductCategoryCode_Equal(String productCategoryCode) {
        doSetProductCategoryCode_Equal(fRES(productCategoryCode));
    }

    protected void doSetProductCategoryCode_Equal(String productCategoryCode) {
        regProductCategoryCode(CK_EQ, productCategoryCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY}
     * @param productCategoryCode The value of productCategoryCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductCategoryCode_NotEqual(String productCategoryCode) {
        doSetProductCategoryCode_NotEqual(fRES(productCategoryCode));
    }

    protected void doSetProductCategoryCode_NotEqual(String productCategoryCode) {
        regProductCategoryCode(CK_NES, productCategoryCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY}
     * @param productCategoryCodeList The collection of productCategoryCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductCategoryCode_InScope(Collection<String> productCategoryCodeList) {
        doSetProductCategoryCode_InScope(productCategoryCodeList);
    }

    public void doSetProductCategoryCode_InScope(Collection<String> productCategoryCodeList) {
        regINS(CK_INS, cTL(productCategoryCodeList), getCValueProductCategoryCode(), "PRODUCT_CATEGORY_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY}
     * @param productCategoryCodeList The collection of productCategoryCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductCategoryCode_NotInScope(Collection<String> productCategoryCodeList) {
        doSetProductCategoryCode_NotInScope(productCategoryCodeList);
    }

    public void doSetProductCategoryCode_NotInScope(Collection<String> productCategoryCodeList) {
        regINS(CK_NINS, cTL(productCategoryCodeList), getCValueProductCategoryCode(), "PRODUCT_CATEGORY_CODE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY}
     * @param productCategoryCode The value of productCategoryCode as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductCategoryCode_PrefixSearch(String productCategoryCode) {
        setProductCategoryCode_LikeSearch(productCategoryCode, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY} <br />
     * <pre>e.g. setProductCategoryCode_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param productCategoryCode The value of productCategoryCode as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setProductCategoryCode_LikeSearch(String productCategoryCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(productCategoryCode), getCValueProductCategoryCode(), "PRODUCT_CATEGORY_CODE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PRODUCT_CATEGORY_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_CATEGORY}
     * @param productCategoryCode The value of productCategoryCode as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setProductCategoryCode_NotLikeSearch(String productCategoryCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(productCategoryCode), getCValueProductCategoryCode(), "PRODUCT_CATEGORY_CODE", likeSearchOption);
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select PRODUCT_CATEGORY_CODE from PRODUCT_CATEGORY where ...)} <br />
     * (商品カテゴリ)PRODUCT_CATEGORY by my PRODUCT_CATEGORY_CODE, named 'productCategory'.
     * @param subQuery The sub-query of ProductCategory for 'in-scope'. (NotNull)
     */
    public void inScopeProductCategory(SubQuery<ProductCategoryCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCategoryCB cb = new ProductCategoryCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductCategoryCode_InScopeRelation_ProductCategory(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "PRODUCT_CATEGORY_CODE", "PRODUCT_CATEGORY_CODE", pp, "productCategory");
    }
    public abstract String keepProductCategoryCode_InScopeRelation_ProductCategory(ProductCategoryCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select PRODUCT_CATEGORY_CODE from PRODUCT_CATEGORY where ...)} <br />
     * (商品カテゴリ)PRODUCT_CATEGORY by my PRODUCT_CATEGORY_CODE, named 'productCategory'.
     * @param subQuery The sub-query of ProductCategory for 'not in-scope'. (NotNull)
     */
    public void notInScopeProductCategory(SubQuery<ProductCategoryCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCategoryCB cb = new ProductCategoryCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductCategoryCode_NotInScopeRelation_ProductCategory(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "PRODUCT_CATEGORY_CODE", "PRODUCT_CATEGORY_CODE", pp, "productCategory");
    }
    public abstract String keepProductCategoryCode_NotInScopeRelation_ProductCategory(ProductCategoryCQ sq);

    protected void regProductCategoryCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductCategoryCode(), "PRODUCT_CATEGORY_CODE"); }
    protected abstract ConditionValue getCValueProductCategoryCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus}
     * @param productStatusCode The value of productStatusCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    protected void setProductStatusCode_Equal(String productStatusCode) {
        doSetProductStatusCode_Equal(fRES(productStatusCode));
    }

    /**
     * Equal(=). As ProductStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus} <br />
     * 商品ステータス。あんまり面白みのないステータス
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus cdef) {
        doSetProductStatusCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 生産販売可能 (ONS). And OnlyOnceRegistered. <br />
     * 生産販売可能
     */
    public void setProductStatusCode_Equal_生産販売可能() {
        setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus.生産販売可能);
    }

    /**
     * Equal(=). As 生産中止 (PST). And OnlyOnceRegistered. <br />
     * 生産中止
     */
    public void setProductStatusCode_Equal_生産中止() {
        setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus.生産中止);
    }

    /**
     * Equal(=). As 販売中止 (SST). And OnlyOnceRegistered. <br />
     * 販売中止
     */
    public void setProductStatusCode_Equal_販売中止() {
        setProductStatusCode_Equal_AsProductStatus(CDef.ProductStatus.販売中止);
    }

    protected void doSetProductStatusCode_Equal(String productStatusCode) {
        regProductStatusCode(CK_EQ, productStatusCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus}
     * @param productStatusCode The value of productStatusCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    protected void setProductStatusCode_NotEqual(String productStatusCode) {
        doSetProductStatusCode_NotEqual(fRES(productStatusCode));
    }

    /**
     * NotEqual(&lt;&gt;). As ProductStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus} <br />
     * 商品ステータス。あんまり面白みのないステータス
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus cdef) {
        doSetProductStatusCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 生産販売可能 (ONS). And OnlyOnceRegistered. <br />
     * 生産販売可能
     */
    public void setProductStatusCode_NotEqual_生産販売可能() {
        setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus.生産販売可能);
    }

    /**
     * NotEqual(&lt;&gt;). As 生産中止 (PST). And OnlyOnceRegistered. <br />
     * 生産中止
     */
    public void setProductStatusCode_NotEqual_生産中止() {
        setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus.生産中止);
    }

    /**
     * NotEqual(&lt;&gt;). As 販売中止 (SST). And OnlyOnceRegistered. <br />
     * 販売中止
     */
    public void setProductStatusCode_NotEqual_販売中止() {
        setProductStatusCode_NotEqual_AsProductStatus(CDef.ProductStatus.販売中止);
    }

    protected void doSetProductStatusCode_NotEqual(String productStatusCode) {
        regProductStatusCode(CK_NES, productStatusCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus}
     * @param productStatusCodeList The collection of productStatusCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_InScope(Collection<String> productStatusCodeList) {
        doSetProductStatusCode_InScope(productStatusCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As ProductStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus} <br />
     * 商品ステータス。あんまり面白みのないステータス
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_InScope_AsProductStatus(Collection<CDef.ProductStatus> cdefList) {
        doSetProductStatusCode_InScope(cTStrL(cdefList));
    }

    public void doSetProductStatusCode_InScope(Collection<String> productStatusCodeList) {
        regINS(CK_INS, cTL(productStatusCodeList), getCValueProductStatusCode(), "PRODUCT_STATUS_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus}
     * @param productStatusCodeList The collection of productStatusCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_NotInScope(Collection<String> productStatusCodeList) {
        doSetProductStatusCode_NotInScope(productStatusCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As ProductStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PRODUCT_STATUS_CODE: {IX, NotNull, CHAR(3), FK to PRODUCT_STATUS, classification=ProductStatus} <br />
     * 商品ステータス。あんまり面白みのないステータス
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setProductStatusCode_NotInScope_AsProductStatus(Collection<CDef.ProductStatus> cdefList) {
        doSetProductStatusCode_NotInScope(cTStrL(cdefList));
    }

    public void doSetProductStatusCode_NotInScope(Collection<String> productStatusCodeList) {
        regINS(CK_NINS, cTL(productStatusCodeList), getCValueProductStatusCode(), "PRODUCT_STATUS_CODE");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select PRODUCT_STATUS_CODE from PRODUCT_STATUS where ...)} <br />
     * (商品ステータス)PRODUCT_STATUS by my PRODUCT_STATUS_CODE, named 'productStatus'.
     * @param subQuery The sub-query of ProductStatus for 'in-scope'. (NotNull)
     */
    public void inScopeProductStatus(SubQuery<ProductStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductStatusCB cb = new ProductStatusCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductStatusCode_InScopeRelation_ProductStatus(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productStatus");
    }
    public abstract String keepProductStatusCode_InScopeRelation_ProductStatus(ProductStatusCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select PRODUCT_STATUS_CODE from PRODUCT_STATUS where ...)} <br />
     * (商品ステータス)PRODUCT_STATUS by my PRODUCT_STATUS_CODE, named 'productStatus'.
     * @param subQuery The sub-query of ProductStatus for 'not in-scope'. (NotNull)
     */
    public void notInScopeProductStatus(SubQuery<ProductStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductStatusCB cb = new ProductStatusCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepProductStatusCode_NotInScopeRelation_ProductStatus(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "PRODUCT_STATUS_CODE", "PRODUCT_STATUS_CODE", pp, "productStatus");
    }
    public abstract String keepProductStatusCode_NotInScopeRelation_ProductStatus(ProductStatusCQ sq);

    protected void regProductStatusCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProductStatusCode(), "PRODUCT_STATUS_CODE"); }
    protected abstract ConditionValue getCValueProductStatusCode();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPrice The value of regularPrice as equal. (NullAllowed: if null, no condition)
     */
    public void setRegularPrice_Equal(Integer regularPrice) {
        doSetRegularPrice_Equal(regularPrice);
    }

    protected void doSetRegularPrice_Equal(Integer regularPrice) {
        regRegularPrice(CK_EQ, regularPrice);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPrice The value of regularPrice as notEqual. (NullAllowed: if null, no condition)
     */
    public void setRegularPrice_NotEqual(Integer regularPrice) {
        doSetRegularPrice_NotEqual(regularPrice);
    }

    protected void doSetRegularPrice_NotEqual(Integer regularPrice) {
        regRegularPrice(CK_NES, regularPrice);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPrice The value of regularPrice as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setRegularPrice_GreaterThan(Integer regularPrice) {
        regRegularPrice(CK_GT, regularPrice);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPrice The value of regularPrice as lessThan. (NullAllowed: if null, no condition)
     */
    public void setRegularPrice_LessThan(Integer regularPrice) {
        regRegularPrice(CK_LT, regularPrice);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPrice The value of regularPrice as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setRegularPrice_GreaterEqual(Integer regularPrice) {
        regRegularPrice(CK_GE, regularPrice);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPrice The value of regularPrice as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setRegularPrice_LessEqual(Integer regularPrice) {
        regRegularPrice(CK_LE, regularPrice);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param minNumber The min number of regularPrice. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of regularPrice. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setRegularPrice_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueRegularPrice(), "REGULAR_PRICE", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPriceList The collection of regularPrice as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegularPrice_InScope(Collection<Integer> regularPriceList) {
        doSetRegularPrice_InScope(regularPriceList);
    }

    protected void doSetRegularPrice_InScope(Collection<Integer> regularPriceList) {
        regINS(CK_INS, cTL(regularPriceList), getCValueRegularPrice(), "REGULAR_PRICE");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * REGULAR_PRICE: {NotNull, INTEGER(10)}
     * @param regularPriceList The collection of regularPrice as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegularPrice_NotInScope(Collection<Integer> regularPriceList) {
        doSetRegularPrice_NotInScope(regularPriceList);
    }

    protected void doSetRegularPrice_NotInScope(Collection<Integer> regularPriceList) {
        regINS(CK_NINS, cTL(regularPriceList), getCValueRegularPrice(), "REGULAR_PRICE");
    }

    protected void regRegularPrice(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueRegularPrice(), "REGULAR_PRICE"); }
    protected abstract ConditionValue getCValueRegularPrice();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @param registerDatetime The value of registerDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_Equal(java.sql.Timestamp registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * <pre>e.g. setRegisterDatetime_FromTo(fromDate, toDate, new <span style="color: #FD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of registerDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setRegisterDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueRegisterDatetime(), "REGISTER_DATETIME", fromToOption);
    }

    protected void regRegisterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueRegisterDatetime(), "REGISTER_DATETIME"); }
    protected abstract ConditionValue getCValueRegisterDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @param registerUser The value of registerUser as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setRegisterUser_Equal(String registerUser) {
        doSetRegisterUser_Equal(fRES(registerUser));
    }

    protected void doSetRegisterUser_Equal(String registerUser) {
        regRegisterUser(CK_EQ, registerUser);
    }

    protected void regRegisterUser(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueRegisterUser(), "REGISTER_USER"); }
    protected abstract ConditionValue getCValueRegisterUser();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @param updateDatetime The value of updateDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_Equal(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #FD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueUpdateDatetime(), "UPDATE_DATETIME", fromToOption);
    }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue getCValueUpdateDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @param updateUser The value of updateUser as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdateUser_Equal(String updateUser) {
        doSetUpdateUser_Equal(fRES(updateUser));
    }

    protected void doSetUpdateUser_Equal(String updateUser) {
        regUpdateUser(CK_EQ, updateUser);
    }

    protected void regUpdateUser(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdateUser(), "UPDATE_USER"); }
    protected abstract ConditionValue getCValueUpdateUser();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as equal. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_Equal(Long versionNo) {
        doSetVersionNo_Equal(versionNo);
    }

    protected void doSetVersionNo_Equal(Long versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param minNumber The min number of versionNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of versionNo. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setVersionNo_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueVersionNo(), "VERSION_NO", rangeOfOption);
    }

    protected void regVersionNo(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueVersionNo(), "VERSION_NO"); }
    protected abstract ConditionValue getCValueVersionNo();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ProductCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), ProductCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ProductCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), ProductCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ProductCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), ProductCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ProductCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), ProductCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ProductCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), ProductCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;ProductCB&gt;() {
     *     public void query(ProductCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ProductCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), ProductCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        ProductCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(ProductCQ sq);

    protected ProductCB xcreateScalarConditionCB() {
        ProductCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected ProductCB xcreateScalarConditionPartitionByCB() {
        ProductCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<ProductCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ProductCB cb = new ProductCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pk = "PRODUCT_ID";
        String pp = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(ProductCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<ProductCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(ProductCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ProductCB cb = new ProductCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "PRODUCT_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(ProductCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<ProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCB cb = new ProductCB(); cb.xsetupForMyselfExists(this); subQuery.query(cb);
        String pp = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(ProductCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<ProductCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ProductCB cb = new ProductCB(); cb.xsetupForMyselfInScope(this); subQuery.query(cb);
        String pp = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(ProductCQ sq);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected ProductCB newMyCB() {
        return new ProductCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return ProductCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
