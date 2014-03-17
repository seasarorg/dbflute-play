package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
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

import com.google.common.base.Strings;
import com.google.common.io.Closer;

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
        final Map<String, ManifestEntry> map = new TreeMap<String, ManifestEntry>();
        final Set<URL> versions = new HashSet<URL>();
        collectJars(versions);
        for (final URL url : versions) {
            final ManifestEntry m = createManifestEntry(url);
            map.put(m.getName(), m);
        }

        final Status ret = ok(views.html.debug.jars.render(map));
        return ret;
    }

    public Result system() {
        final Map<String, String> props = new TreeMap<String, String>();
        final Map properties = System.getProperties();
        toMap(properties, props);

        final Map<String, String> envs = new TreeMap<String, String>();
        final Map<String, String> getenv = System.getenv();
        toMap(getenv, envs);

        final Status ret = ok(views.html.debug.system.render(props, envs));
        return ret;
    }

    private void toMap(final Map properties, final Map<String, String> destMap) {
        for (Map.Entry<String, String> entry : (Set<Map.Entry<String, String>>) properties.entrySet()) {
            final String key = entry.getKey();
            final String value = entry.getValue();
            if (Strings.isNullOrEmpty(value)) {
                destMap.put(key, "(empty)");
            } else {
                StringBuilder sb = new StringBuilder();
                final char[] chars = value.toCharArray();
                for (char c : chars) {
                    if (Character.isISOControl(c)) {
                        sb.append(String.format("(0x%02X)", (int) c));
                    } else {
                        sb.append(c);
                    }
                }
                destMap.put(key, sb.toString());
            }
        }
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

    private ManifestEntry createManifestEntry(final URL url) throws IOException {
        if (url == null) {
            return null;
        }

        final URLConnection con = url.openConnection();
        con.setUseCaches(false);
        final InputStream is = con.getInputStream();
        final ManifestEntry manifest = createManifest(is);

        final String externalForm = url.toExternalForm();
        final String jarName = extractJarFileName(externalForm);
        manifest.setName(jarName);
        final String path = extractJarPathName(externalForm);
        manifest.setPath(path);

        return manifest;
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

    private ManifestEntry createManifest(final InputStream is) throws IOException {
        Closer closer = Closer.create();
        try {
            closer.register(is);
            final Manifest manifest = new Manifest(is);
            return new ManifestEntry(manifest);
        } finally {
            closer.close();
        }
    }

    public static class ManifestEntry {

        private String name;
        private final Manifest manifest;
        private final Attributes attributes;
        private String path;
        private final String text;
        private String version;

        public ManifestEntry(final Manifest manifest) throws IOException {
            this.manifest = manifest;
            this.attributes = manifest.getMainAttributes();
            this.text = extractBody(manifest);
            this.version = extractVersion(attributes);
        }

        private String extractBody(final Manifest manifest) throws IOException {
            // MANIFEST本文
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
            manifest.write(baos);
            final String text = baos.toString("UTF-8");
            return text;
        }

        private String extractVersion(Attributes attributes) {
            final String implVersion = attributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            if (!Strings.isNullOrEmpty(implVersion)) {
                return implVersion;
            }
            // OSGi
            final String bundleVersion = attributes.getValue("Bundle-Version");
            return bundleVersion;

        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getText() {
            return text;
        }

    }

}
