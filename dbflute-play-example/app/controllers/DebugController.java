package controllers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.util.ConnectionUtil;
import org.seasar.extension.jdbc.util.DataSourceUtil;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;
import play.mvc.Result;

public class DebugController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @Binding(bindingType = BindingType.MUST)
    private DataSource dataSource;

    public DebugController() {
        logger.debug("<init>");
    }

    public Result index() {
        final Connection conn = DataSourceUtil.getConnection(dataSource);
        try {
            final DatabaseMetaData metaData = ConnectionUtil.getMetaData(conn);
            final Status ret = ok(views.html.debug.render("DEBUG Your new application is ready.", metaData));
            return ret;
        } finally {
            ConnectionUtil.close(conn);
        }
    }

}
