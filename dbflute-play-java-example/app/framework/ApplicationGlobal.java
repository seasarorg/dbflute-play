package framework;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.joda.time.Interval;
import org.seasar.dbflute.AccessContext;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.framework.container.servlet.S2ContainerDestroyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.Application;
import play.GlobalSettings;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Http.RequestBody;
import play.mvc.Http.Session;
import play.mvc.Result;

public class ApplicationGlobal extends GlobalSettings {

    private final Logger logger = LoggerFactory.getLogger(ApplicationGlobal.class);
    private S2Container container;

    /**
     * リクエスト通番(1オリジン)
     */
    private final RequestCounter requestCounter = new RequestCounter();

    public ApplicationGlobal() {
        logger.debug("<init>");
    }

    @Override
    public void onStart(final Application app) {
        super.onStart(app);
        logger.debug("onStart: {}", app);

        /*
         * see: S2ContainerListener
         * 
         * SingletonS2ContainerInitializerはServletに依存しているので使えない。。。
         */
        //        SingletonS2ContainerInitializer initializer = new SingletonS2ContainerInitializer();
        //        initializer.setConfigPath("app.dicon");
        //        initializer.setApplication(null);
        //        initializer.initialize();
        SingletonS2ContainerFactory.init();
        container = SingletonS2ContainerFactory.getContainer();
    }

    @Override
    public void onStop(final Application app) {
        logger.debug("onStop: {}", app);
        S2ContainerDestroyer.destroy();
        super.onStop(app);
    }

    @Override
    public <A> A getControllerInstance(final Class<A> controllerClass) throws Exception {
        logger.debug("getControllerInstance: {}", controllerClass);
        final A component = (A) container.getComponent(controllerClass);
        return component;
    }

    @Override
    public Action onRequest(final Request request, final Method actionMethod) {
        // 1始まりの通番
        final RequestCount requestCount = requestCounter.next();
        final long begin = System.currentTimeMillis();
        if (logger.isDebugEnabled()) {
            final String sb = toString(request);
            logger.debug(String.format("[%s] BEGIN: request={%s}\n  action=%s\n  %s", requestCount, request,
                    actionMethod, sb));
        }

        final Action origAction = super.onRequest(request, actionMethod);
        final AppAction appAction = new AppAction(requestCount, request, actionMethod, begin);
        //dbFluteAction.delegate = origAction;
        //appAction.delegate = dbFluteAction;
        // delegateはplayによって設定されるようだ。
        return appAction;
    }

    private String toString(final Http.Request request) {
        final StringBuilder sb = new StringBuilder();
        sb.append("uri=").append(request.uri());
        sb.append(", method=").append(request.method());
        sb.append(", version=").append(request.version());
        sb.append(", host=").append(request.host());
        sb.append(", path=").append(request.path());
        sb.append(", remoteAddress=").append(request.remoteAddress());
        sb.append(", headers=");
        final Map<String, String[]> headers = request.headers();
        for (final Entry<String, String[]> entry : new TreeMap<String, String[]>(headers).entrySet()) {
            sb.append("\n");
            sb.append("    ");
            sb.append(entry.getKey());
            sb.append("=");
            final String[] values = entry.getValue();
            if (values.length == 1) {
                sb.append(values[0]);
            } else {
                sb.append("Array: ");
                sb.append(Arrays.toString(values));
            }
        }

        sb.append("\n");
        sb.append("  ");
        sb.append("body=");
        final RequestBody body = request.body();
        sb.append(body.toString());
        return sb.toString();
    }

    static class AppAction extends Action {

        private final Logger logger = LoggerFactory.getLogger(AppAction.class);
        private final String COUNTER_KEY = "requestCount";
        private final RequestCount requestCount;
        private final Request request;
        private final Method actionMethod;
        private final long begin;

        public AppAction(final RequestCount requestCount, final Request request, final Method actionMethod, long begin) {
            this.requestCount = requestCount;
            this.request = request;
            this.actionMethod = actionMethod;
            this.begin = begin;
        }

        @Override
        public F.Promise<Result> call(final Context ctx) throws Throwable {
            ctx.args.put(COUNTER_KEY, String.format("[req-%s]", requestCount.getCount()));
            if (logger.isDebugEnabled()) {
                final Session session = ctx.session();
                logger.debug(String.format("[%s] args=%s\n  session=%s", requestCount, ctx.args, session));
            }

            boolean success = false;
            try {
                /*
                 * 3つのPromiseは全て異なるスレッドで実行される可能性がある。
                 */
                final F.Promise<String> beforeAction = F.Promise.promise(new F.Function0<String>() {
                    @Override
                    public String apply() {
                        logger.info(String.format("[%s] BEGIN: Function", requestCount));
                        return null;
                    }
                });
                final F.Promise<Result> controllerAction = beforeAction
                        .flatMap(new F.Function<String, F.Promise<Result>>() {
                            @Override
                            public F.Promise<Result> apply(final String dummy) throws Throwable {
                                return call0(ctx);
                            }
                        });
                final F.Promise<Result> result = controllerAction.map(new F.Function<Result, Result>() {
                    @Override
                    public Result apply(final Result o) throws Throwable {
                        final long end = System.currentTimeMillis();
                        final Interval interval = new Interval(begin, end);
                        logger.info(String.format("[%s] END: Success, %sms", requestCount, interval.toDurationMillis()));
                        return o;
                    }
                });
                final F.Callback<Throwable> onFailure = new F.Callback<Throwable>() {
                    @Override
                    public void invoke(final Throwable th) throws Throwable {
                        final long end = System.currentTimeMillis();
                        final Interval interval = new Interval(begin, end);
                        logger.warn(
                                String.format("[%s] END: Failure, %sms", requestCount, interval.toDurationMillis()), th);
                    }
                };
                result.onFailure(onFailure);
                success = true;
                return result;
            } finally {
                final long end = System.currentTimeMillis();
                final Interval interval = new Interval(begin, end);
                final String ret = success ? "Success" : "Failure";
                logger.debug(String.format("[%s] END: %s, %sms, args=%s", requestCount, ret,
                        interval.toDurationMillis(), ctx.args));
            }
        }

        /*
         * DBFluteのAccessContextを設定するインタセプタ処理
         * 
         * 当初はDBFlute用のDBFluteActionを作って、GlobalでActionのchainにしようと考えたが、
         * delegateはplay側に設定されるので、1段しか作れないようなので、
         * 諦めて元のActionにDBFlute用ロジックも組み込んだ。
         */
        private F.Promise<Result> call0(final Context ctx) throws Throwable {
            // ログインするシステムならばログイン者のID等にする
            final String user = request.remoteAddress();
            final String processName = String.format("%s#%s", actionMethod.getDeclaringClass().getSimpleName(),
                    actionMethod.getName());
            logger.debug("user={}, processName={}", user, processName);
            final AccessContext context = new AccessContext();
            context.setAccessTimestamp(new Timestamp(System.currentTimeMillis()));
            context.setAccessUser(user);
            context.setAccessProcess(processName);
            try {
                AccessContext.setAccessContextOnThread(context);
                final F.Promise<Result> call = delegate.call(ctx);
                return call;
            } finally {
                AccessContext.clearAccessContextOnThread();
            }
        }
    }

}
