package framework;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.Application;
import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Http.Request;

public class ApplicationGlobal extends GlobalSettings {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationGlobal.class);

    public ApplicationGlobal() {
        logger.debug("<init>");
    }

    @Override
    public void onStart(final Application app) {
        super.onStart(app);
        logger.debug("onStart: {}", app);
    }

    @Override
    public void onStop(final Application app) {
        logger.debug("onStop: {}", app);
        super.onStop(app);
    }

    @Override
    public Action onRequest(final Request request, final Method actionMethod) {
        logger.debug("onRequest: {}", request);
        return super.onRequest(request, actionMethod);
    }

}
