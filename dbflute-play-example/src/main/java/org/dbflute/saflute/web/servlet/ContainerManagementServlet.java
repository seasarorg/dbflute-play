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
package org.dbflute.saflute.web.servlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.container.servlet.S2ContainerServlet;

/**
 * The servlet to manage DI container. <br />
 * This extends Seasar's servlet to cache exception from initialization. <br />
 * If no extension, you cannot search the exception in log files created by logger.
 * @author jflute
 */
public class ContainerManagementServlet extends S2ContainerServlet {

    private static final long serialVersionUID = 1L;
    private static final Log LOG = LogFactory.getLog(ContainerManagementServlet.class);

    @Override
    public void init() {
        try {
            super.init();
        } catch (RuntimeException e) {
            LOG.error("Failed to initialize S2Container.", e);
            throw e;
        }
    }
}
