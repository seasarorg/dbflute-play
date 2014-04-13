package com.example.dbflute.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.util.OptionHelper;
import play.mvc.Http;

import java.util.Map;

/**
 * PlayFrameworkの {@link Http.Context} から取得するlogback converter。
 *
 * Http.ContextをMDCのように利用するためのクラス。
 */
public class PlayHttpContextConverter extends ClassicConverter {

    private String key;
    private String defaultValue = "";

    /*
     * see: ch.qos.logback.classic.pattern.MDCConverter
     */
    @Override
    public void start() {
        final String[] keyInfo = OptionHelper.extractDefaultReplacement(getFirstOption());
        key = keyInfo[0];
        if (keyInfo[1] != null) {
            defaultValue = keyInfo[1];
        }
        super.start();
    }

    @Override
    public void stop() {
        key = null;
        defaultValue = "";
        super.stop();
    }

    @Override
    public String convert(final ILoggingEvent event) {
        final Http.Context context = Http.Context.current.get();
        if (context != null) {
            final Map<String, Object> args = context.args;
            final Object value = args.get(key);
            if (value != null) {
                return String.valueOf(value);
            }
        }
        return defaultValue;
    }

}
