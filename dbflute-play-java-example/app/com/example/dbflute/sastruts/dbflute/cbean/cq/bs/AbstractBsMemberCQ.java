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
 * The abstract condition-query of MEMBER.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsMemberCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsMemberCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "MEMBER";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberId The value of memberId as equal. (NullAllowed: if null, no condition)
     */
    public void setMemberId_Equal(Integer memberId) {
        doSetMemberId_Equal(memberId);
    }

    protected void doSetMemberId_Equal(Integer memberId) {
        regMemberId(CK_EQ, memberId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberId The value of memberId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_NotEqual(Integer memberId) {
        doSetMemberId_NotEqual(memberId);
    }

    protected void doSetMemberId_NotEqual(Integer memberId) {
        regMemberId(CK_NES, memberId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberId The value of memberId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMemberId_GreaterThan(Integer memberId) {
        regMemberId(CK_GT, memberId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberId The value of memberId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMemberId_LessThan(Integer memberId) {
        regMemberId(CK_LT, memberId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberId The value of memberId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_GreaterEqual(Integer memberId) {
        regMemberId(CK_GE, memberId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberId The value of memberId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_LessEqual(Integer memberId) {
        regMemberId(CK_LE, memberId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param minNumber The min number of memberId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of memberId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMemberId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMemberId(), "MEMBER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberIdList The collection of memberId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberId_InScope(Collection<Integer> memberIdList) {
        doSetMemberId_InScope(memberIdList);
    }

    protected void doSetMemberId_InScope(Collection<Integer> memberIdList) {
        regINS(CK_INS, cTL(memberIdList), getCValueMemberId(), "MEMBER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @param memberIdList The collection of memberId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberId_NotInScope(Collection<Integer> memberIdList) {
        doSetMemberId_NotInScope(memberIdList);
    }

    protected void doSetMemberId_NotInScope(Collection<Integer> memberIdList) {
        regINS(CK_NINS, cTL(memberIdList), getCValueMemberId(), "MEMBER_ID");
    }

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_ID from MEMBER_ADDRESS where ...)} <br />
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberAddressList</span>(new SubQuery&lt;MemberAddressCB&gt;() {
     *     public void query(MemberAddressCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberAddressList for 'exists'. (NotNull)
     */
    public void existsMemberAddressList(SubQuery<MemberAddressCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberAddressCB cb = new MemberAddressCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_ExistsReferrer_MemberAddressList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberAddressList");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberAddressList(MemberAddressCQ sq);

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_ID from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberLoginList</span>(new SubQuery&lt;MemberLoginCB&gt;() {
     *     public void query(MemberLoginCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberLoginList for 'exists'. (NotNull)
     */
    public void existsMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_ExistsReferrer_MemberLoginList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberLoginList");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberLoginList(MemberLoginCQ sq);

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_ID from MEMBER_SECURITY where ...)} <br />
     * (会員セキュリティ情報)MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberSecurityAsOne</span>(new SubQuery&lt;MemberSecurityCB&gt;() {
     *     public void query(MemberSecurityCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberSecurityAsOne for 'exists'. (NotNull)
     */
    public void existsMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_ExistsReferrer_MemberSecurityAsOne(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_ID from MEMBER_SERVICE where ...)} <br />
     * (会員サービス)MEMBER_SERVICE by MEMBER_ID, named 'memberServiceAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberServiceAsOne</span>(new SubQuery&lt;MemberServiceCB&gt;() {
     *     public void query(MemberServiceCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberServiceAsOne for 'exists'. (NotNull)
     */
    public void existsMemberServiceAsOne(SubQuery<MemberServiceCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberServiceCB cb = new MemberServiceCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_ExistsReferrer_MemberServiceAsOne(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberServiceAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberServiceAsOne(MemberServiceCQ sq);

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_ID from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberWithdrawalAsOne</span>(new SubQuery&lt;MemberWithdrawalCB&gt;() {
     *     public void query(MemberWithdrawalCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberWithdrawalAsOne for 'exists'. (NotNull)
     */
    public void existsMemberWithdrawalAsOne(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_ExistsReferrer_MemberWithdrawalAsOne(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawalAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberWithdrawalAsOne(MemberWithdrawalCQ sq);

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseAsOne'.
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
        String pp = keepMemberId_ExistsReferrer_PurchaseList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "purchaseList");
    }
    public abstract String keepMemberId_ExistsReferrer_PurchaseList(PurchaseCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_ID from MEMBER_ADDRESS where ...)} <br />
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberAddressList</span>(new SubQuery&lt;MemberAddressCB&gt;() {
     *     public void query(MemberAddressCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberAddressList for 'not exists'. (NotNull)
     */
    public void notExistsMemberAddressList(SubQuery<MemberAddressCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberAddressCB cb = new MemberAddressCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_NotExistsReferrer_MemberAddressList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberAddressList");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberAddressList(MemberAddressCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_ID from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberLoginList</span>(new SubQuery&lt;MemberLoginCB&gt;() {
     *     public void query(MemberLoginCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberLoginList for 'not exists'. (NotNull)
     */
    public void notExistsMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_NotExistsReferrer_MemberLoginList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberLoginList");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberLoginList(MemberLoginCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_ID from MEMBER_SECURITY where ...)} <br />
     * (会員セキュリティ情報)MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberSecurityAsOne</span>(new SubQuery&lt;MemberSecurityCB&gt;() {
     *     public void query(MemberSecurityCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberSecurityAsOne for 'not exists'. (NotNull)
     */
    public void notExistsMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_NotExistsReferrer_MemberSecurityAsOne(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_ID from MEMBER_SERVICE where ...)} <br />
     * (会員サービス)MEMBER_SERVICE by MEMBER_ID, named 'memberServiceAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberServiceAsOne</span>(new SubQuery&lt;MemberServiceCB&gt;() {
     *     public void query(MemberServiceCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberServiceAsOne for 'not exists'. (NotNull)
     */
    public void notExistsMemberServiceAsOne(SubQuery<MemberServiceCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberServiceCB cb = new MemberServiceCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_NotExistsReferrer_MemberServiceAsOne(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberServiceAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberServiceAsOne(MemberServiceCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_ID from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberWithdrawalAsOne</span>(new SubQuery&lt;MemberWithdrawalCB&gt;() {
     *     public void query(MemberWithdrawalCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberWithdrawalAsOne for 'not exists'. (NotNull)
     */
    public void notExistsMemberWithdrawalAsOne(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_NotExistsReferrer_MemberWithdrawalAsOne(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawalAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberWithdrawalAsOne(MemberWithdrawalCQ sq);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsPurchaseList</span>(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_PurchaseList for 'not exists'. (NotNull)
     */
    public void notExistsPurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String pp = keepMemberId_NotExistsReferrer_PurchaseList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "purchaseList");
    }
    public abstract String keepMemberId_NotExistsReferrer_PurchaseList(PurchaseCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from MEMBER_ADDRESS where ...)} <br />
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressAsOne'.
     * @param subQuery The sub-query of MemberAddressList for 'in-scope'. (NotNull)
     */
    public void inScopeMemberAddressList(SubQuery<MemberAddressCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberAddressCB cb = new MemberAddressCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_InScopeRelation_MemberAddressList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberAddressList");
    }
    public abstract String keepMemberId_InScopeRelation_MemberAddressList(MemberAddressCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginAsOne'.
     * @param subQuery The sub-query of MemberLoginList for 'in-scope'. (NotNull)
     */
    public void inScopeMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_InScopeRelation_MemberLoginList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberLoginList");
    }
    public abstract String keepMemberId_InScopeRelation_MemberLoginList(MemberLoginCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from MEMBER_SECURITY where ...)} <br />
     * (会員セキュリティ情報)MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param subQuery The sub-query of MemberSecurityAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_InScopeRelation_MemberSecurityAsOne(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from MEMBER_SERVICE where ...)} <br />
     * (会員サービス)MEMBER_SERVICE by MEMBER_ID, named 'memberServiceAsOne'.
     * @param subQuery The sub-query of MemberServiceAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeMemberServiceAsOne(SubQuery<MemberServiceCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberServiceCB cb = new MemberServiceCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_InScopeRelation_MemberServiceAsOne(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberServiceAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_MemberServiceAsOne(MemberServiceCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @param subQuery The sub-query of MemberWithdrawalAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeMemberWithdrawalAsOne(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_InScopeRelation_MemberWithdrawalAsOne(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawalAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_MemberWithdrawalAsOne(MemberWithdrawalCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseAsOne'.
     * @param subQuery The sub-query of PurchaseList for 'in-scope'. (NotNull)
     */
    public void inScopePurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_InScopeRelation_PurchaseList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "purchaseList");
    }
    public abstract String keepMemberId_InScopeRelation_PurchaseList(PurchaseCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from MEMBER_ADDRESS where ...)} <br />
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressAsOne'.
     * @param subQuery The sub-query of MemberAddressList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberAddressList(SubQuery<MemberAddressCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberAddressCB cb = new MemberAddressCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_NotInScopeRelation_MemberAddressList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberAddressList");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberAddressList(MemberAddressCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginAsOne'.
     * @param subQuery The sub-query of MemberLoginList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_NotInScopeRelation_MemberLoginList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberLoginList");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberLoginList(MemberLoginCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from MEMBER_SECURITY where ...)} <br />
     * (会員セキュリティ情報)MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param subQuery The sub-query of MemberSecurityAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_NotInScopeRelation_MemberSecurityAsOne(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from MEMBER_SERVICE where ...)} <br />
     * (会員サービス)MEMBER_SERVICE by MEMBER_ID, named 'memberServiceAsOne'.
     * @param subQuery The sub-query of MemberServiceAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberServiceAsOne(SubQuery<MemberServiceCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberServiceCB cb = new MemberServiceCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_NotInScopeRelation_MemberServiceAsOne(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberServiceAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberServiceAsOne(MemberServiceCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @param subQuery The sub-query of MemberWithdrawalAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberWithdrawalAsOne(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_NotInScopeRelation_MemberWithdrawalAsOne(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawalAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberWithdrawalAsOne(MemberWithdrawalCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from PURCHASE where ...)} <br />
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseAsOne'.
     * @param subQuery The sub-query of PurchaseList for 'not in-scope'. (NotNull)
     */
    public void notInScopePurchaseList(SubQuery<PurchaseCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberId_NotInScopeRelation_PurchaseList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "purchaseList");
    }
    public abstract String keepMemberId_NotInScopeRelation_PurchaseList(PurchaseCQ sq);

    public void xsderiveMemberAddressList(String fn, SubQuery<MemberAddressCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberAddressCB cb = new MemberAddressCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pp = keepMemberId_SpecifyDerivedReferrer_MemberAddressList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberAddressList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_MemberAddressList(MemberAddressCQ sq);

    public void xsderiveMemberLoginList(String fn, SubQuery<MemberLoginCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pp = keepMemberId_SpecifyDerivedReferrer_MemberLoginList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberLoginList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_MemberLoginList(MemberLoginCQ sq);

    public void xsderivePurchaseList(String fn, SubQuery<PurchaseCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        PurchaseCB cb = new PurchaseCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pp = keepMemberId_SpecifyDerivedReferrer_PurchaseList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "purchaseList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_PurchaseList(PurchaseCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from MEMBER_ADDRESS where ...)} <br />
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedMemberAddressList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;MemberAddressCB&gt;() {
     *     public void query(MemberAddressCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MemberAddressCB> derivedMemberAddressList() {
        return xcreateQDRFunctionMemberAddressList();
    }
    protected HpQDRFunction<MemberAddressCB> xcreateQDRFunctionMemberAddressList() {
        return new HpQDRFunction<MemberAddressCB>(new HpQDRSetupper<MemberAddressCB>() {
            public void setup(String fn, SubQuery<MemberAddressCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveMemberAddressList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveMemberAddressList(String fn, SubQuery<MemberAddressCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberAddressCB cb = new MemberAddressCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String sqpp = keepMemberId_QueryDerivedReferrer_MemberAddressList(cb.query()); // for saving query-value.
        String prpp = keepMemberId_QueryDerivedReferrer_MemberAddressListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", sqpp, "memberAddressList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_MemberAddressList(MemberAddressCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_MemberAddressListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedMemberLoginList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;MemberLoginCB&gt;() {
     *     public void query(MemberLoginCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MemberLoginCB> derivedMemberLoginList() {
        return xcreateQDRFunctionMemberLoginList();
    }
    protected HpQDRFunction<MemberLoginCB> xcreateQDRFunctionMemberLoginList() {
        return new HpQDRFunction<MemberLoginCB>(new HpQDRSetupper<MemberLoginCB>() {
            public void setup(String fn, SubQuery<MemberLoginCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveMemberLoginList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveMemberLoginList(String fn, SubQuery<MemberLoginCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String sqpp = keepMemberId_QueryDerivedReferrer_MemberLoginList(cb.query()); // for saving query-value.
        String prpp = keepMemberId_QueryDerivedReferrer_MemberLoginListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", sqpp, "memberLoginList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_MemberLoginList(MemberLoginCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_MemberLoginListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from PURCHASE where ...)} <br />
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseAsOne'.
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
        String sqpp = keepMemberId_QueryDerivedReferrer_PurchaseList(cb.query()); // for saving query-value.
        String prpp = keepMemberId_QueryDerivedReferrer_PurchaseListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", sqpp, "purchaseList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_PurchaseList(PurchaseCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_PurchaseListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     */
    public void setMemberId_IsNull() { regMemberId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     */
    public void setMemberId_IsNotNull() { regMemberId(CK_ISNN, DOBJ); }

    protected void regMemberId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberId(), "MEMBER_ID"); }
    protected abstract ConditionValue getCValueMemberId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)}
     * @param memberName The value of memberName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberName_Equal(String memberName) {
        doSetMemberName_Equal(fRES(memberName));
    }

    protected void doSetMemberName_Equal(String memberName) {
        regMemberName(CK_EQ, memberName);
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)}
     * @param memberName The value of memberName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberName_PrefixSearch(String memberName) {
        setMemberName_LikeSearch(memberName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * <pre>e.g. setMemberName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param memberName The value of memberName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMemberName_LikeSearch(String memberName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(memberName), getCValueMemberName(), "MEMBER_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)}
     * @param memberName The value of memberName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMemberName_NotLikeSearch(String memberName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(memberName), getCValueMemberName(), "MEMBER_NAME", likeSearchOption);
    }

    protected void regMemberName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberName(), "MEMBER_NAME"); }
    protected abstract ConditionValue getCValueMemberName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @param memberAccount The value of memberAccount as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberAccount_Equal(String memberAccount) {
        doSetMemberAccount_Equal(fRES(memberAccount));
    }

    protected void doSetMemberAccount_Equal(String memberAccount) {
        regMemberAccount(CK_EQ, memberAccount);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @param memberAccount The value of memberAccount as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberAccount_NotEqual(String memberAccount) {
        doSetMemberAccount_NotEqual(fRES(memberAccount));
    }

    protected void doSetMemberAccount_NotEqual(String memberAccount) {
        regMemberAccount(CK_NES, memberAccount);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @param memberAccountList The collection of memberAccount as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberAccount_InScope(Collection<String> memberAccountList) {
        doSetMemberAccount_InScope(memberAccountList);
    }

    public void doSetMemberAccount_InScope(Collection<String> memberAccountList) {
        regINS(CK_INS, cTL(memberAccountList), getCValueMemberAccount(), "MEMBER_ACCOUNT");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @param memberAccountList The collection of memberAccount as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberAccount_NotInScope(Collection<String> memberAccountList) {
        doSetMemberAccount_NotInScope(memberAccountList);
    }

    public void doSetMemberAccount_NotInScope(Collection<String> memberAccountList) {
        regINS(CK_NINS, cTL(memberAccountList), getCValueMemberAccount(), "MEMBER_ACCOUNT");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @param memberAccount The value of memberAccount as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberAccount_PrefixSearch(String memberAccount) {
        setMemberAccount_LikeSearch(memberAccount, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setMemberAccount_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param memberAccount The value of memberAccount as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMemberAccount_LikeSearch(String memberAccount, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(memberAccount), getCValueMemberAccount(), "MEMBER_ACCOUNT", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @param memberAccount The value of memberAccount as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMemberAccount_NotLikeSearch(String memberAccount, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(memberAccount), getCValueMemberAccount(), "MEMBER_ACCOUNT", likeSearchOption);
    }

    protected void regMemberAccount(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberAccount(), "MEMBER_ACCOUNT"); }
    protected abstract ConditionValue getCValueMemberAccount();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}
     * @param memberStatusCode The value of memberStatusCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    protected void setMemberStatusCode_Equal(String memberStatusCode) {
        doSetMemberStatusCode_Equal(fRES(memberStatusCode));
    }

    /**
     * Equal(=). As MemberStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus cdef) {
        doSetMemberStatusCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As 正式会員 (FML). And OnlyOnceRegistered. <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     */
    public void setMemberStatusCode_Equal_正式会員() {
        setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.正式会員);
    }

    /**
     * Equal(=). As 退会会員 (WDL). And OnlyOnceRegistered. <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     */
    public void setMemberStatusCode_Equal_退会会員() {
        setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.退会会員);
    }

    /**
     * Equal(=). As 仮会員 (PRV). And OnlyOnceRegistered. <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     */
    public void setMemberStatusCode_Equal_仮会員() {
        setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.仮会員);
    }

    protected void doSetMemberStatusCode_Equal(String memberStatusCode) {
        regMemberStatusCode(CK_EQ, memberStatusCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}
     * @param memberStatusCode The value of memberStatusCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    protected void setMemberStatusCode_NotEqual(String memberStatusCode) {
        doSetMemberStatusCode_NotEqual(fRES(memberStatusCode));
    }

    /**
     * NotEqual(&lt;&gt;). As MemberStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus cdef) {
        doSetMemberStatusCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As 正式会員 (FML). And OnlyOnceRegistered. <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     */
    public void setMemberStatusCode_NotEqual_正式会員() {
        setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus.正式会員);
    }

    /**
     * NotEqual(&lt;&gt;). As 退会会員 (WDL). And OnlyOnceRegistered. <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     */
    public void setMemberStatusCode_NotEqual_退会会員() {
        setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus.退会会員);
    }

    /**
     * NotEqual(&lt;&gt;). As 仮会員 (PRV). And OnlyOnceRegistered. <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     */
    public void setMemberStatusCode_NotEqual_仮会員() {
        setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus.仮会員);
    }

    protected void doSetMemberStatusCode_NotEqual(String memberStatusCode) {
        regMemberStatusCode(CK_NES, memberStatusCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}
     * @param memberStatusCodeList The collection of memberStatusCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_InScope(Collection<String> memberStatusCodeList) {
        doSetMemberStatusCode_InScope(memberStatusCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As MemberStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_InScope_AsMemberStatus(Collection<CDef.MemberStatus> cdefList) {
        doSetMemberStatusCode_InScope(cTStrL(cdefList));
    }

    /**
     * InScope {in ('a', 'b')}. As MemberStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * 入会から退会までの会員のステータスを示す <br />
     * サービスが利用できる会員
     */
    public void setMemberStatusCode_InScope_ServiceAvailable() {
        setMemberStatusCode_InScope_AsMemberStatus(CDef.MemberStatus.listOfServiceAvailable());
    }

    /**
     * InScope {in ('a', 'b')}. As MemberStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * 入会から退会までの会員のステータスを示す <br />
     * まだ正式会員に達してない会員
     */
    public void setMemberStatusCode_InScope_ShortOfFormalized() {
        setMemberStatusCode_InScope_AsMemberStatus(CDef.MemberStatus.listOfShortOfFormalized());
    }

    public void doSetMemberStatusCode_InScope(Collection<String> memberStatusCodeList) {
        regINS(CK_INS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}
     * @param memberStatusCodeList The collection of memberStatusCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_NotInScope(Collection<String> memberStatusCodeList) {
        doSetMemberStatusCode_NotInScope(memberStatusCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As MemberStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_NotInScope_AsMemberStatus(Collection<CDef.MemberStatus> cdefList) {
        doSetMemberStatusCode_NotInScope(cTStrL(cdefList));
    }

    public void doSetMemberStatusCode_NotInScope(Collection<String> memberStatusCodeList) {
        regINS(CK_NINS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_STATUS_CODE from MEMBER_STATUS where ...)} <br />
     * (会員ステータス)MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param subQuery The sub-query of MemberStatus for 'in-scope'. (NotNull)
     */
    public void inScopeMemberStatus(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberStatusCode_InScopeRelation_MemberStatus(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberStatus");
    }
    public abstract String keepMemberStatusCode_InScopeRelation_MemberStatus(MemberStatusCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_STATUS_CODE from MEMBER_STATUS where ...)} <br />
     * (会員ステータス)MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param subQuery The sub-query of MemberStatus for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberStatus(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String pp = keepMemberStatusCode_NotInScopeRelation_MemberStatus(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberStatus");
    }
    public abstract String keepMemberStatusCode_NotInScopeRelation_MemberStatus(MemberStatusCQ sq);

    protected void regMemberStatusCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberStatusCode(), "MEMBER_STATUS_CODE"); }
    protected abstract ConditionValue getCValueMemberStatusCode();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @param formalizedDatetime The value of formalizedDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setFormalizedDatetime_Equal(java.sql.Timestamp formalizedDatetime) {
        regFormalizedDatetime(CK_EQ,  formalizedDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @param formalizedDatetime The value of formalizedDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setFormalizedDatetime_GreaterThan(java.sql.Timestamp formalizedDatetime) {
        regFormalizedDatetime(CK_GT,  formalizedDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @param formalizedDatetime The value of formalizedDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setFormalizedDatetime_LessThan(java.sql.Timestamp formalizedDatetime) {
        regFormalizedDatetime(CK_LT,  formalizedDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @param formalizedDatetime The value of formalizedDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setFormalizedDatetime_GreaterEqual(java.sql.Timestamp formalizedDatetime) {
        regFormalizedDatetime(CK_GE,  formalizedDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @param formalizedDatetime The value of formalizedDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setFormalizedDatetime_LessEqual(java.sql.Timestamp formalizedDatetime) {
        regFormalizedDatetime(CK_LE, formalizedDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * <pre>e.g. setFormalizedDatetime_FromTo(fromDate, toDate, new <span style="color: #FD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of formalizedDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of formalizedDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setFormalizedDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueFormalizedDatetime(), "FORMALIZED_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #FD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of formalizedDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of formalizedDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setFormalizedDatetime_DateFromTo(Date fromDate, Date toDate) {
        setFormalizedDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     */
    public void setFormalizedDatetime_IsNull() { regFormalizedDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     */
    public void setFormalizedDatetime_IsNotNull() { regFormalizedDatetime(CK_ISNN, DOBJ); }

    protected void regFormalizedDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueFormalizedDatetime(), "FORMALIZED_DATETIME"); }
    protected abstract ConditionValue getCValueFormalizedDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @param birthdate The value of birthdate as equal. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_Equal(java.util.Date birthdate) {
        regBirthdate(CK_EQ,  fCTPD(birthdate));
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @param birthdate The value of birthdate as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_GreaterThan(java.util.Date birthdate) {
        regBirthdate(CK_GT,  fCTPD(birthdate));
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @param birthdate The value of birthdate as lessThan. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_LessThan(java.util.Date birthdate) {
        regBirthdate(CK_LT,  fCTPD(birthdate));
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @param birthdate The value of birthdate as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_GreaterEqual(java.util.Date birthdate) {
        regBirthdate(CK_GE,  fCTPD(birthdate));
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @param birthdate The value of birthdate as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_LessEqual(java.util.Date birthdate) {
        regBirthdate(CK_LE, fCTPD(birthdate));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * <pre>e.g. setBirthdate_FromTo(fromDate, toDate, new <span style="color: #FD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of birthdate. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of birthdate. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setBirthdate_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ(fCTPD(fromDatetime), fCTPD(toDatetime), getCValueBirthdate(), "BIRTHDATE", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #FD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of birthdate. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of birthdate. (NullAllowed: if null, no to-condition)
     */
    public void setBirthdate_DateFromTo(Date fromDate, Date toDate) {
        setBirthdate_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     */
    public void setBirthdate_IsNull() { regBirthdate(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     */
    public void setBirthdate_IsNotNull() { regBirthdate(CK_ISNN, DOBJ); }

    protected void regBirthdate(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueBirthdate(), "BIRTHDATE"); }
    protected abstract ConditionValue getCValueBirthdate();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * (登録日時)REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @param registerDatetime The value of registerDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setRegisterDatetime_Equal(java.sql.Timestamp registerDatetime) {
        regRegisterDatetime(CK_EQ,  registerDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (登録日時)REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
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
     * (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)}
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
     * (更新日時)UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @param updateDatetime The value of updateDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_Equal(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (更新日時)UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
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
     * (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)}
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
     * (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)}
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
     * (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)}
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
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), MemberCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(MemberCQ sq);

    protected MemberCB xcreateScalarConditionCB() {
        MemberCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected MemberCB xcreateScalarConditionPartitionByCB() {
        MemberCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<MemberCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pk = "MEMBER_ID";
        String pp = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(MemberCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<MemberCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(MemberCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "MEMBER_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(MemberCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForMyselfExists(this); subQuery.query(cb);
        String pp = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(MemberCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForMyselfInScope(this); subQuery.query(cb);
        String pp = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(MemberCQ sq);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected MemberCB newMyCB() {
        return new MemberCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return MemberCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
