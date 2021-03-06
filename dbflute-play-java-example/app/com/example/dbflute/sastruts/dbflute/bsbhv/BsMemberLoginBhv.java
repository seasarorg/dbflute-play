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
package com.example.dbflute.sastruts.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.sastruts.dbflute.exbhv.*;
import com.example.dbflute.sastruts.dbflute.exentity.*;
import com.example.dbflute.sastruts.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.sastruts.dbflute.cbean.*;

/**
 * The behavior of (会員ログイン)MEMBER_LOGIN as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_LOGIN_ID
 *
 * [column]
 *     MEMBER_LOGIN_ID, MEMBER_ID, LOGIN_DATETIME, MOBILE_LOGIN_FLG, LOGIN_MEMBER_STATUS_CODE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MEMBER_LOGIN_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     MEMBER, MEMBER_STATUS
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member, memberStatus
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberLoginBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_LOGIN"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return MemberLoginDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberLoginDbm getMyDBMeta() { return MemberLoginDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberLogin newMyEntity() { return new MemberLogin(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberLoginCB newMyConditionBean() { return new MemberLoginCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * int count = memberLoginBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberLoginCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberLoginCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberLoginCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * MemberLogin memberLogin = memberLoginBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (memberLogin != null) {
     *     ... = memberLogin.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberLogin selectEntity(MemberLoginCB cb) {
        return doSelectEntity(cb, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> ENTITY doSelectEntity(final MemberLoginCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, MemberLoginCB>() {
            public List<ENTITY> callbackSelectList(MemberLoginCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * MemberLogin memberLogin = memberLoginBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberLogin.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberLogin selectEntityWithDeletedCheck(MemberLoginCB cb) {
        return doSelectEntityWithDeletedCheck(cb, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> ENTITY doSelectEntityWithDeletedCheck(final MemberLoginCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberLoginCB>() {
            public List<ENTITY> callbackSelectList(MemberLoginCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberLoginId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberLogin selectByPKValue(Long memberLoginId) {
        return doSelectByPKValue(memberLoginId, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> ENTITY doSelectByPKValue(Long memberLoginId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(memberLoginId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberLoginId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberLogin selectByPKValueWithDeletedCheck(Long memberLoginId) {
        return doSelectByPKValueWithDeletedCheck(memberLoginId, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> ENTITY doSelectByPKValueWithDeletedCheck(Long memberLoginId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(memberLoginId), entityType);
    }

    private MemberLoginCB buildPKCB(Long memberLoginId) {
        assertObjectNotNull("memberLoginId", memberLoginId);
        MemberLoginCB cb = newMyConditionBean();
        cb.query().setMemberLoginId_Equal(memberLoginId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberLogin&gt; memberLoginList = memberLoginBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (MemberLogin memberLogin : memberLoginList) {
     *     ... = memberLogin.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberLogin> selectList(MemberLoginCB cb) {
        return doSelectList(cb, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> ListResultBean<ENTITY> doSelectList(MemberLoginCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, MemberLoginCB>() {
            public List<ENTITY> callbackSelectList(MemberLoginCB cb, Class<ENTITY> tp) { return delegateSelectList(cb, tp); } });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberLogin&gt; page = memberLoginBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberLogin memberLogin : page) {
     *     ... = memberLogin.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberLogin> selectPage(MemberLoginCB cb) {
        return doSelectPage(cb, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> PagingResultBean<ENTITY> doSelectPage(MemberLoginCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, MemberLoginCB>() {
            public int callbackSelectCount(MemberLoginCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberLoginCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * memberLoginBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberLogin&gt;() {
     *     public void handle(MemberLogin entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberLogin. (NotNull)
     */
    public void selectCursor(MemberLoginCB cb, EntityRowHandler<MemberLogin> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, MemberLogin.class);
    }

    protected <ENTITY extends MemberLogin> void doSelectCursor(MemberLoginCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, MemberLoginCB>() {
            public void callbackSelectCursor(MemberLoginCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(MemberLoginCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberLoginBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberLoginCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<MemberLoginCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends MemberLoginCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends MemberLoginCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
        return new SLFunction<CB, RESULT>(cb, tp);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
        return doScalarSelect(tp, newMyConditionBean());
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberLoginList The list of memberLogin. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<MemberLogin> memberLoginList) {
        return helpPulloutInternally(memberLoginList, new InternalPulloutCallback<MemberLogin, Member>() {
            public Member getFr(MemberLogin et) { return et.getMember(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<MemberLogin> ls)
            { et.setMemberLoginList(ls); }
        });
    }
    /**
     * Pull out the list of foreign table 'MemberStatus'.
     * @param memberLoginList The list of memberLogin. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberStatus> pulloutMemberStatus(List<MemberLogin> memberLoginList) {
        return helpPulloutInternally(memberLoginList, new InternalPulloutCallback<MemberLogin, MemberStatus>() {
            public MemberStatus getFr(MemberLogin et) { return et.getMemberStatus(); }
            public boolean hasRf() { return true; }
            public void setRfLs(MemberStatus et, List<MemberLogin> ls)
            { et.setMemberLoginList(ls); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberLoginId.
     * @param memberLoginList The list of memberLogin. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractMemberLoginIdList(List<MemberLogin> memberLoginList) {
        return helpExtractListInternally(memberLoginList, new InternalExtractCallback<MemberLogin, Long>() {
            public Long getCV(MemberLogin et) { return et.getMemberLoginId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberLogin memberLogin = new MemberLogin();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberLogin.setFoo...(value);
     * memberLogin.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberLogin.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberLogin.set...;</span>
     * memberLoginBhv.<span style="color: #FD4747">insert</span>(memberLogin);
     * ... = memberLogin.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberLogin The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberLogin memberLogin) {
        doInsert(memberLogin, null);
    }

    protected void doInsert(MemberLogin memberLogin, InsertOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLogin", memberLogin);
        prepareInsertOption(op);
        delegateInsert(memberLogin, op);
    }

    protected void prepareInsertOption(InsertOption<MemberLoginCB> op) {
        if (op == null) { return; }
        assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) {
            op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity et, InsertOption<? extends ConditionBean> op) {
        if (op == null) { insert(downcast(et)); }
        else { varyingInsert(downcast(et), downcast(op)); }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * MemberLogin memberLogin = new MemberLogin();
     * memberLogin.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberLogin.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberLogin.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberLogin.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberLogin.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberLoginBhv.<span style="color: #FD4747">update</span>(memberLogin);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberLogin The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final MemberLogin memberLogin) {
        doUpdate(memberLogin, null);
    }

    protected void doUpdate(MemberLogin memberLogin, final UpdateOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLogin", memberLogin);
        prepareUpdateOption(op);
        helpUpdateInternally(memberLogin, new InternalUpdateCallback<MemberLogin>() {
            public int callbackDelegateUpdate(MemberLogin et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberLoginCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected MemberLoginCB createCBForVaryingUpdate() {
        MemberLoginCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected MemberLoginCB createCBForSpecifiedUpdate() {
        MemberLoginCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { update(downcast(et)); }
        else { varyingUpdate(downcast(et), downcast(op)); }
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doModify(et, op);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberLogin The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberLogin memberLogin) {
        doInesrtOrUpdate(memberLogin, null, null);
    }

    protected void doInesrtOrUpdate(MemberLogin memberLogin, final InsertOption<MemberLoginCB> iop, final UpdateOption<MemberLoginCB> uop) {
        helpInsertOrUpdateInternally(memberLogin, new InternalInsertOrUpdateCallback<MemberLogin, MemberLoginCB>() {
            public void callbackInsert(MemberLogin et) { doInsert(et, iop); }
            public void callbackUpdate(MemberLogin et) { doUpdate(et, uop); }
            public MemberLoginCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(MemberLoginCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<MemberLoginCB>();
            uop = uop != null ? uop : new UpdateOption<MemberLoginCB>();
            varyingInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doCreateOrModify(et, iop, uop);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * MemberLogin memberLogin = new MemberLogin();
     * memberLogin.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberLogin.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberLoginBhv.<span style="color: #FD4747">delete</span>(memberLogin);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberLogin The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberLogin memberLogin) {
        doDelete(memberLogin, null);
    }

    protected void doDelete(MemberLogin memberLogin, final DeleteOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLogin", memberLogin);
        prepareDeleteOption(op);
        helpDeleteInternally(memberLogin, new InternalDeleteCallback<MemberLogin>() {
            public int callbackDelegateDelete(MemberLogin et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberLoginCB> op) {
        if (op == null) { return; }
        assertDeleteOptionStatus(op);
    }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { delete(downcast(et)); }
        else { varyingDelete(downcast(et), downcast(op)); }
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        doRemove(et, op);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #FD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     MemberLogin memberLogin = new MemberLogin();
     *     memberLogin.setFooName("foo");
     *     if (...) {
     *         memberLogin.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberLoginList.add(memberLogin);
     * }
     * memberLoginBhv.<span style="color: #FD4747">batchInsert</span>(memberLoginList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberLogin> memberLoginList) {
        InsertOption<MemberLoginCB> op = createInsertUpdateOption();
        return doBatchInsert(memberLoginList, op);
    }

    protected int[] doBatchInsert(List<MemberLogin> memberLoginList, InsertOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLoginList", memberLoginList);
        prepareBatchInsertOption(memberLoginList, op);
        return delegateBatchInsert(memberLoginList, op);
    }

    protected void prepareBatchInsertOption(List<MemberLogin> memberLoginList, InsertOption<MemberLoginCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(memberLoginList);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        if (op == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberLogin memberLogin = new MemberLogin();
     *     memberLogin.setFooName("foo");
     *     if (...) {
     *         memberLogin.setFooPrice(123);
     *     } else {
     *         memberLogin.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberLogin.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberLoginList.add(memberLogin);
     * }
     * memberLoginBhv.<span style="color: #FD4747">batchUpdate</span>(memberLoginList);
     * </pre>
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberLogin> memberLoginList) {
        UpdateOption<MemberLoginCB> op = createPlainUpdateOption();
        return doBatchUpdate(memberLoginList, op);
    }

    protected int[] doBatchUpdate(List<MemberLogin> memberLoginList, UpdateOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLoginList", memberLoginList);
        prepareBatchUpdateOption(memberLoginList, op);
        return delegateBatchUpdate(memberLoginList, op);
    }

    protected void prepareBatchUpdateOption(List<MemberLogin> memberLoginList, UpdateOption<MemberLoginCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(memberLoginList);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * memberLoginBhv.<span style="color: #FD4747">batchUpdate</span>(memberLoginList, new SpecifyQuery<MemberLoginCB>() {
     *     public void specify(MemberLoginCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberLoginBhv.<span style="color: #FD4747">batchUpdate</span>(memberLoginList, new SpecifyQuery<MemberLoginCB>() {
     *     public void specify(MemberLoginCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberLogin> memberLoginList, SpecifyQuery<MemberLoginCB> updateColumnSpec) {
        return doBatchUpdate(memberLoginList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<MemberLogin> memberLoginList) {
        return doBatchDelete(memberLoginList, null);
    }

    protected int[] doBatchDelete(List<MemberLogin> memberLoginList, DeleteOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLoginList", memberLoginList);
        prepareDeleteOption(op);
        return delegateBatchDelete(memberLoginList, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(op)); }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doLumpRemove(ls, op);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * memberLoginBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberLogin, MemberLoginCB&gt;() {
     *     public ConditionBean setup(memberLogin entity, MemberLoginCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<MemberLogin, MemberLoginCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberLogin, MemberLoginCB> sp, InsertOption<MemberLoginCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        MemberLogin e = new MemberLogin();
        MemberLoginCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected MemberLoginCB createCBForQueryInsert() {
        MemberLoginCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return queryInsert(downcast(setupper)); }
        else { return varyingQueryInsert(downcast(setupper), downcast(option)); }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * MemberLogin memberLogin = new MemberLogin();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberLogin.setPK...(value);</span>
     * memberLogin.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberLogin.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberLogin.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberLogin.setVersionNo(value);</span>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * memberLoginBhv.<span style="color: #FD4747">queryUpdate</span>(memberLogin, cb);
     * </pre>
     * @param memberLogin The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberLogin memberLogin, MemberLoginCB cb) {
        return doQueryUpdate(memberLogin, cb, null);
    }

    protected int doQueryUpdate(MemberLogin memberLogin, MemberLoginCB cb, UpdateOption<MemberLoginCB> op) {
        assertObjectNotNull("memberLogin", memberLogin); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(memberLogin, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (MemberLoginCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (MemberLoginCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * memberLoginBhv.<span style="color: #FD4747">queryDelete</span>(memberLogin, cb);
     * </pre>
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberLoginCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberLoginCB cb, DeleteOption<MemberLoginCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((MemberLoginCB)cb); }
        else { return varyingQueryDelete((MemberLoginCB)cb, downcast(op)); }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * MemberLogin memberLogin = new MemberLogin();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberLogin.setFoo...(value);
     * memberLogin.setBar...(value);
     * InsertOption<MemberLoginCB> option = new InsertOption<MemberLoginCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberLoginBhv.<span style="color: #FD4747">varyingInsert</span>(memberLogin, option);
     * ... = memberLogin.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberLogin The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberLogin memberLogin, InsertOption<MemberLoginCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberLogin, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberLogin memberLogin = new MemberLogin();
     * memberLogin.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberLogin.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberLogin.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberLoginCB&gt; option = new UpdateOption&lt;MemberLoginCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberLoginCB&gt;() {
     *         public void specify(MemberLoginCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberLoginBhv.<span style="color: #FD4747">varyingUpdate</span>(memberLogin, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberLogin The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberLogin memberLogin, UpdateOption<MemberLoginCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberLogin, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberLogin The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberLogin memberLogin, InsertOption<MemberLoginCB> insertOption, UpdateOption<MemberLoginCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(memberLogin, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberLogin The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberLogin memberLogin, DeleteOption<MemberLoginCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberLogin, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberLogin> memberLoginList, InsertOption<MemberLoginCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberLoginList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberLogin> memberLoginList, UpdateOption<MemberLoginCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberLoginList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberLoginList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberLogin> memberLoginList, DeleteOption<MemberLoginCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberLoginList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper).
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<MemberLogin, MemberLoginCB> setupper, InsertOption<MemberLoginCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * MemberLogin memberLogin = new MemberLogin();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberLogin.setPK...(value);</span>
     * memberLogin.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberLogin.setVersionNo(value);</span>
     * MemberLoginCB cb = new MemberLoginCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberLoginCB&gt; option = new UpdateOption&lt;MemberLoginCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberLoginCB&gt;() {
     *     public void specify(MemberLoginCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberLoginBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(memberLogin, cb, option);
     * </pre>
     * @param memberLogin The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberLogin memberLogin, MemberLoginCB cb, UpdateOption<MemberLoginCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberLogin, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberLogin. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberLoginCB cb, DeleteOption<MemberLoginCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     *
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     *
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     *
     * {Cursor}
     *   o cursorHandling().selectCursor()
     *
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull)
     */
    public OutsideSqlBasicExecutor<MemberLoginBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberLoginCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberLoginCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberLogin> void delegateSelectCursor(MemberLoginCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends MemberLogin> List<ENTITY> delegateSelectList(MemberLoginCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberLogin et, InsertOption<MemberLoginCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(MemberLogin et, UpdateOption<MemberLoginCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(MemberLogin et, UpdateOption<MemberLoginCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(MemberLogin et, DeleteOption<MemberLoginCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(MemberLogin et, DeleteOption<MemberLoginCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<MemberLogin> ls, InsertOption<MemberLoginCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberLogin> ls, UpdateOption<MemberLoginCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberLogin> ls, UpdateOption<MemberLoginCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberLogin> ls, DeleteOption<MemberLoginCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberLogin> ls, DeleteOption<MemberLoginCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberLogin et, MemberLoginCB inCB, ConditionBean resCB, InsertOption<MemberLoginCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberLogin et, MemberLoginCB cb, UpdateOption<MemberLoginCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(MemberLoginCB cb, DeleteOption<MemberLoginCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(Entity et) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected MemberLogin downcast(Entity et) {
        return helpEntityDowncastInternally(et, MemberLogin.class);
    }

    protected MemberLoginCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, MemberLoginCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<MemberLogin> downcast(List<? extends Entity> ls) {
        return (List<MemberLogin>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberLoginCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<MemberLoginCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberLoginCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<MemberLoginCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberLoginCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<MemberLoginCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberLogin, MemberLoginCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<MemberLogin, MemberLoginCB>)sp;
    }
}
