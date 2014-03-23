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
package com.example.dbflute.sastruts.web.member;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.helper.HandyDate;
import org.seasar.dbflute.util.DfTypeUtil;

import com.example.dbflute.sastruts.dbflute.exentity.Member;
import com.example.dbflute.sastruts.unit.UnitContainerTestCase;

/**
 * @author jflute
 */
public class ListActionTest extends UnitContainerTestCase {

    public void test_doSearch_memberName_and_status() throws Exception {
        // ## Arrange ##
        ListAction searchAction = new ListAction();
        inject(searchAction);

        searchAction.listForm.memberName = "S";
        searchAction.listForm.memberStatus = "FML";

        // ## Act ##
        String moveTo = searchAction.doSearch();

        // ## Assert ##
        Map<String, String> memberStatusMap = searchAction.memberStatusMap;
        assertHasAnyElement(memberStatusMap.keySet());

        List<MemberWebBean> memberList = searchAction.beanList;
        assertHasAnyElement(memberList);
        for (MemberWebBean member : memberList) {
            log(member.memberName + ", " + member.memberStatusName);
            assertTrue(member.memberName.startsWith("S"));
            assertFalse(member.withdrawalMember);
        }

        assertEquals("index.jsp", moveTo);
    }

    public void test_doSearch_formalizedDatetime_DateFromTo() throws Exception {
        // ## Arrange ##
        ListAction searchAction = new ListAction();
        inject(searchAction);
        String from = "2005/01/01";
        String to = "2006/12/31";
        searchAction.listForm.formalizedDateFrom = from;
        searchAction.listForm.formalizedDateTo = to;

        // ## Act ##
        searchAction.doSearch();

        // ## Assert ##
        List<MemberWebBean> memberList = searchAction.beanList;
        assertHasAnyElement(memberList);
        for (MemberWebBean member : memberList) {
            Timestamp formalizedDatetime = member.formalizedDatetime;
            log(member.memberName + ", " + formalizedDatetime);
            Timestamp fromTime = DfTypeUtil.toTimestamp(from);
            Timestamp toTime = DfTypeUtil.toTimestamp(to);
            Timestamp addedToTime = new HandyDate(toTime).addDay(1).getTimestamp();
            assertTrue(formalizedDatetime.after(fromTime) || formalizedDatetime.equals(fromTime));
            assertTrue(formalizedDatetime.before(addedToTime));
        }
    }

    public void test_doSearch_MockExample() throws Exception {
        // ## Arrange ##
        final PagingResultBean<Member> rb = new PagingResultBean<Member>();
        ListAction searchAction = new ListAction() {
            @Override
            protected PagingResultBean<Member> selectMemberPage() {
                return rb;
            }
        };
        inject(searchAction);

        // ## Act ##
        searchAction.doSearch();

        // ## Assert ##
        assertEquals(rb.size(), searchAction.beanList.size());
        Map<String, String> memberStatusMap = searchAction.memberStatusMap;
        assertHasAnyElement(memberStatusMap.keySet());
    }
}
