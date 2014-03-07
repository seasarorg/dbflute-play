package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;
import play.mvc.Result;

public class DebugController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    public DebugController() {
        logger.debug("<init>");
    }

    public Result index() {
        return ok(views.html.debug.render("DEBUG Your new application is ready."));
    }

}
