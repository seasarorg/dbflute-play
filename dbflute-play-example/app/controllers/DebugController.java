package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /*
     * CLASSPATHから取得するときは、先頭の"/"は不要
     * [META-INF/MANIFEST.MF]
     */
    private static final String CL_MANIFEST_PATH = JarFile.MANIFEST_NAME;
    private final Pattern jarFileNamePattern = Pattern.compile("([^/]+\\.jar)");
    private final Pattern jarPathPattern = Pattern.compile("(.+\\.jar)[!]*?");

    @Binding(bindingType = BindingType.MUST)
    private DataSource dataSource;

    public DebugController() {
        logger.debug("<init>");
    }

    public Result index() {
        final Connection conn = DataSourceUtil.getConnection(dataSource);
        try {
            final DatabaseMetaData metaData = ConnectionUtil.getMetaData(conn);
            final Status ret = ok(views.html.debug.debug.render("DEBUG Your new application is ready.", metaData));
            return ret;
        } finally {
            ConnectionUtil.close(conn);
        }
    }

    public Result jars() throws IOException {
        final Map<String, String> map = new TreeMap<String, String>();
        final Set<URL> versions = new HashSet<URL>();
        collectJars(versions);
        for (final URL url : versions) {
            final String externalForm = url.toExternalForm();
            final String path = extractJarPathName(externalForm);
            final String jarFileName = extractJarFileName(externalForm);
            map.put(jarFileName, path);
        }

        final Status ret = ok(views.html.debug.jars.render(map));
        return ret;
    }

    private void collectJars(final Set<URL> versions) throws IOException {
        final ClassLoader cl = Thread.currentThread().getContextClassLoader();
        final Enumeration<URL> resources = cl.getResources(CL_MANIFEST_PATH);
        for (int i = 0; resources.hasMoreElements(); i++) {
            final URL resource = resources.nextElement();
            logger.debug("[{}] {}", i, resource);
            versions.add(resource);
        }
    }

    /*
     * jarファイル名を含むフルパスから、jarファイル名部分だけを取り出す。
     */
    protected String extractJarFileName(final String s) {
        final Matcher matcher = jarFileNamePattern.matcher(s);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    protected String extractJarPathName(final String s) {
        final Matcher matcher = jarPathPattern.matcher(s);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
