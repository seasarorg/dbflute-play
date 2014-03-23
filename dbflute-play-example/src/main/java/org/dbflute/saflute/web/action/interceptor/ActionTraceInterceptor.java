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
package org.dbflute.saflute.web.action.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.annotation.Execute;

/**
 * @author jflute
 */
public class ActionTraceInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;
    private static final Log LOG = LogFactory.getLog(ActionTraceInterceptor.class);

    public Object invoke(final MethodInvocation invocation) throws Throwable {
        if (!LOG.isDebugEnabled()) {
            return invocation.proceed();
        }
        final Method method = invocation.getMethod();
        if (method.getAnnotation(Execute.class) != null) {
            return handle(invocation, method, InvocationType.ACTION);
        } else { // e.g. doValidate()
            final String methodName = method.getName();
            final boolean validation = mightBeValidation(methodName);
            return handle(invocation, method, validation ? InvocationType.VALIDATION : InvocationType.UNKNOWN);
        }
    }

    protected boolean mightBeValidation(final String methodName) {
        return methodName.startsWith("validate") || methodName.startsWith("doValidate");
    }

    protected Object handle(MethodInvocation invocation, Method method, InvocationType type) throws Throwable {
        Object ret = null;
        Throwable cause = null;
        final String classPureName = getTargetClass(invocation).getSimpleName();
        final String methodName = method.getName();
        final String actionExp = classPureName + "." + methodName + "()";
        final String beginning = buildBeginning(type);
        final String title = buildTitle(type);
        LOG.debug(beginning + title + ": " + actionExp);
        try {
            ret = invocation.proceed();
        } catch (Throwable t) {
            cause = t;
        }
        final String ending = buildEnding(type);
        // RequestProcessor of Struts shows forward info so comment out here
        //final String forwardExp = buildForwardExp(type, ret, cause);
        final String failureMark = buildFailureMark(cause);
        LOG.debug(ending + title + ": " + actionExp + failureMark);
        if (cause != null) {
            throw cause; // you can see the exception details in logging filter
        }
        return ret;
    }

    protected String buildBeginning(InvocationType type) {
        if (InvocationType.ACTION.equals(type)) {
            return "...Beginning ";
        }
        if (InvocationType.VALIDATION.equals(type)) {
            return "...Calling ";
        }
        return "...Calling "; // unknown
    }

    protected String buildTitle(InvocationType type) {
        if (InvocationType.ACTION.equals(type)) {
            return "action";
        }
        if (InvocationType.VALIDATION.equals(type)) {
            return "validation";
        }
        return "method"; // unknown
    }

    protected String buildForwardExp(InvocationType type, Object ret, Throwable cause) {
        if (InvocationType.ACTION.equals(type) && cause == null) {
            return " to " + (ret != null ? ret.toString() : null);
        }
        return "";
    }

    protected String buildFailureMark(Throwable cause) {
        return cause != null ? " *failure" : "";
    }

    protected String buildEnding(InvocationType type) {
        if (InvocationType.ACTION.equals(type)) {
            return "...Ending ";
        }
        if (InvocationType.VALIDATION.equals(type)) {
            return "...Ending ";
        }
        return "...Ending "; // unknown
    }

    public enum InvocationType {
        ACTION, VALIDATION, UNKNOWN
    }
}
