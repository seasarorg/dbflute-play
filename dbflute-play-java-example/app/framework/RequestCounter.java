package framework;

import org.apache.log4j.MDC;
import play.mvc.Http;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class RequestCounter {

    /**
     * リクエスト通番(1オリジン)
     */
    private final AtomicLong requestCounter = new AtomicLong();

    public RequestCount next() {
        final long v = requestCounter.incrementAndGet();
        return new RequestCount(v);
    }

}
