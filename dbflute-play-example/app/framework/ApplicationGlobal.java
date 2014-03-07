package framework;

import java.lang.reflect.Method;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.framework.container.servlet.S2ContainerDestroyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.Application;
import play.GlobalSettings;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;

public class ApplicationGlobal extends GlobalSettings {

    private final Logger logger = LoggerFactory.getLogger(ApplicationGlobal.class);
    private S2Container container;

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
        logger.debug("onRequest: {} ({})", request, actionMethod);
        final Action action = super.onRequest(request, actionMethod);
        return new AppAction(action);
    }

    static class AppAction extends Action {

        private final Logger logger = LoggerFactory.getLogger(AppAction.class);

        public AppAction(final Action delegate) {
            this.delegate = delegate;
        }

        @Override
        public Promise call(final Context ctx) throws Throwable {
            logger.debug("call before");
            try {
                final Promise result = delegate.call(ctx);
                return result;
            } finally {
                logger.debug("call after");
            }
        }
    }

}
