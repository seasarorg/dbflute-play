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
package com.example.dbflute.sastruts.interceptor;

import java.sql.Timestamp;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.dbflute.AccessContext;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

/**
 * @author jflute
 */
public class AccessContextSetupInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1L;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (AccessContext.isExistAccessContextOnThread()) {
            // 既に設定されていたら何もしないで次へ
            // (二度呼び出しされたときのために念のため)
            return invocation.proceed();
        }
        try {
            AccessContext context = new AccessContext();

            // 実際のアプリではちゃんとやること by jflute
            //  - 現在日時の取得は、専用のインターフェースから
            //  - ユーザー情報はセッションなどから
            context.setAccessTimestamp(new Timestamp(System.currentTimeMillis()));
            context.setAccessUser("jflute");

            AccessContext.setAccessContextOnThread(context);
            return invocation.proceed();
        } finally {
            AccessContext.clearAccessContextOnThread();
        }
    }
}
