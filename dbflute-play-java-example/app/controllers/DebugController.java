package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
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

import play.Application;
import play.Configuration;
import play.Play;
import play.data.Form;
import play.libs.F.Function;
import play.libs.F.Function0;
import play.libs.F.Promise;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import scala.Tuple3;

import com.example.dbflute.sastruts.web.DebugResourceForm;
import com.google.common.base.Strings;
import com.google.common.io.Closer;
import com.typesafe.config.ConfigOrigin;
import com.typesafe.config.ConfigValue;

public class DebugController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    /*
     * CLASSPATHから取得するときは、先頭の"/"は不要
     * [META-INF/MANIFEST.MF]
     */
    private static final String CL_MANIFEST_PATH = JarFile.MANIFEST_NAME;
    private final Pattern jarFileNamePattern = Pattern.compile("([^/]+\\.(jar|zip))");
    private final Pattern jarPathPattern = Pattern.compile("(.+\\.(jar|zip))[!]*?");

    @Binding(bindingType = BindingType.MUST)
    private DataSource dataSource;

    public DebugController() {
        logger.debug("<init>");
    }

    public Result index() {
        logger.debug("before OK");
        final Status ret = ok(views.html.debug.debug.render("DEBUG Your new application is ready."));
        logger.debug("after OK");
        return ret;
    }

    /*
     * メソッド名が"request"だと、親クラスとぶつかるため。
     */
    public Result request1() {
        final Status ret = ok(views.html.debug.request1.render("DEBUG Your new application is ready."));
        return ret;
    }

    public Result resources() throws IOException {
        // query stringからもbindしてくれる
        Form<DebugResourceForm> form = Form.form(DebugResourceForm.class).bindFromRequest();
        final DebugResourceForm resourceForm = form.get();

        final String resourceName = resourceForm.p;
        final List<String> resources = new ArrayList<String>();
        if (!Strings.isNullOrEmpty(resourceName)) {
            collectResources(resourceName, resources);
            if (resourceForm.isSort()) {
                Collections.sort(resources);
            }
        }
        final Status ret = ok(views.html.debug.resources.render(form, resources));
        return ret;
    }

    public Result database() {
        final Connection conn = DataSourceUtil.getConnection(dataSource);
        try {
            final DatabaseMetaData metaData = ConnectionUtil.getMetaData(conn);
            final Status ret = ok(views.html.debug.database.render("DEBUG Your new application is ready.", metaData));
            return ret;
        } finally {
            ConnectionUtil.close(conn);
        }
    }

    public Result jars() throws IOException {
        final Map<String, ManifestEntry> map = new TreeMap<String, ManifestEntry>();
        final Set<URL> versions = new HashSet<URL>();
        final List<ManifestEntry> manifests = new ArrayList<ManifestEntry>();
        collectJars(versions);
        for (final URL url : versions) {
            final ManifestEntry m = createManifestEntry(url);
            map.put(m.getName(), m);
        }
        /*
         * TreeMapをzipWithIndexに掛けたらindex順に並ばなかったので、Listで扱うようにした。
         */
        for (final ManifestEntry m : map.values()) {
            manifests.add(m);
        }

        final Status ret = ok(views.html.debug.jars.render(manifests));
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

    public Result memory() {
        final Runtime runtime = Runtime.getRuntime();
        final Map<String, String> runtimeProp = new LinkedHashMap<String, String>();
        runtimeProp.put("freeMemory", toMegaBinaryString(runtime.freeMemory()));
        runtimeProp.put("totalMemory", toMegaBinaryString(runtime.totalMemory()));
        runtimeProp.put("maxMemory", toMegaBinaryString(runtime.maxMemory()));

        final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        final MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();
        final Map<String, String> heapProp = new LinkedHashMap<String, String>();
        logger.debug("heapUsage: {}", heapUsage);
        heapProp.put("init", toMegaBinaryString(heapUsage.getInit()));
        heapProp.put("used", toMegaBinaryString(heapUsage.getUsed()));
        heapProp.put("committed", toMegaBinaryString(heapUsage.getCommitted()));
        heapProp.put("max", toMegaBinaryString(heapUsage.getMax()));

        final MemoryUsage nonHeapUsage = memoryMXBean.getNonHeapMemoryUsage();
        logger.debug("nonHeapUsage: {}", nonHeapUsage);
        final Map<String, String> nonHeapProp = new LinkedHashMap<String, String>();
        nonHeapProp.put("init", toMegaBinaryString(nonHeapUsage.getInit()));
        nonHeapProp.put("used", toMegaBinaryString(nonHeapUsage.getUsed()));
        nonHeapProp.put("committed", toMegaBinaryString(nonHeapUsage.getCommitted()));
        nonHeapProp.put("max", toMegaBinaryString(nonHeapUsage.getMax()));

        final Status ret = ok(views.html.debug.memory.render(runtimeProp, heapProp, nonHeapProp));
        return ret;
    }

    private String toMegaBinaryString(long value) {
        final NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setRoundingMode(RoundingMode.HALF_UP);
        formatter.setMinimumFractionDigits(0);
        formatter.setMaximumFractionDigits(0);

        final double d = value / (1024.0 * 1024.0);
        return formatter.format(d) + "MiB";
    }

    public Result play1() throws IOException {
        final Application application = Play.application();
        final Map<String, String> props = new LinkedHashMap<String, String>();
        props.put("mode", application.getWrappedApplication().mode().toString());
        props.put("path", application.path().getCanonicalPath());

        /*
         * ConfigurationにはSystem.propertyも含まれている。
         * ここではplay側の情報に興味があるので、分離して表示する。
         */

        final Map<String, List<Tuple3<String, String, String>>> configs = new TreeMap<String, List<Tuple3<String, String, String>>>();
        final Configuration configuration = application.configuration();
        final Set<Map.Entry<String, ConfigValue>> keys = configuration.entrySet();
        for (final Map.Entry<String, ConfigValue> entry : keys) {
            final String key = entry.getKey();
            final ConfigValue configValue = entry.getValue();
            final String value = configValue.render();
            final ConfigOrigin origin = configValue.origin();
            final String orig = _toStr(origin);
            List<Tuple3<String, String, String>> values = configs.get(orig);
            if (values == null) {
                values = new ArrayList<Tuple3<String, String, String>>();
                configs.put(orig, values);
            }
            values.add(new Tuple3(key, value, orig));
        }
        final Comparator<Tuple3<String, String, String>> comparator = new Comparator<Tuple3<String, String, String>>() {
            @Override
            public int compare(Tuple3<String, String, String> o1, Tuple3<String, String, String> o2) {
                return o1._1().compareTo(o2._1());
            }
        };
        for (final List<Tuple3<String, String, String>> value : configs.values()) {
            Collections.sort(value, comparator);
        }

        scala.collection.Seq<play.api.Plugin> plugins = application.getWrappedApplication().plugins();
        // java側でscalaのループを回すのは手間なので、scalaテンプレート側で扱う
        //        for (final play.api.Plugin plugin : plugins) {
        //
        //        }

        final Status ret = ok(views.html.debug.play1.render(props, configs, plugins));
        return ret;
    }

    public Result exception() {
        logger.debug("例外を投げます");
        throw new RuntimeException("dummy");
    }

    /*
     * http://www.playframework.com/documentation/2.2.x/JavaAsync
     * Async results
     */
    public Promise<Result> async1() {
        logger.debug("ctx: {}", _toStr(ctx()));
        final Promise<Integer> promiseOfInt = Promise.promise(new Function0<Integer>() {
            public Integer apply() {
                logger.debug("ctx: {}", _toStr(ctx()));
                /*
                 * ここに来た時点でTransactionは終了してしまっている...
                 * 
                 * ここはControllerが呼ばれたのとは別のスレッドになる。
                 */
                _sleep(5000L);
                return 23;
            }
        });
        final Promise<Result> promiseOfResult = promiseOfInt.map(new Function<Integer, Result>() {
            public Result apply(final Integer i) {
                logger.debug("ctx: {}", _toStr(ctx()));
                /*
                 * ここは、上のFunction0と同じスレッド
                 */
                _sleep(10L);
                return ok("Got result: " + i);
            }
        });
        return promiseOfResult;
    }

    private void _sleep(final long millis) {
        logger.debug("sleep {}ms ...", millis);
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            logger.debug(e.getMessage(), e);
        }
        logger.debug("... wakeup from sleep {}ms", millis);
    }

    private String _toStr(Http.Context ctx) {
        return String.format("%08x, %s", System.identityHashCode(ctx), ctx);
    }

    private String _identityHashCode(final Object o) {
        return String.format("%08x", System.identityHashCode(o));
    }

    private String _toStr(final ConfigOrigin origin) {
        final URL url = origin.url();
        if (url != null) {
            return url.toExternalForm();
        }
        return origin.description();
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

    private void collectResources(String path, final List<String> resources) throws IOException {
        final ClassLoader cl = Thread.currentThread().getContextClassLoader();
        for (final Enumeration<URL> it = cl.getResources(path); it.hasMoreElements();) {
            final URL url = it.nextElement();
            final String externalForm = url.toExternalForm();
            resources.add(externalForm);
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
