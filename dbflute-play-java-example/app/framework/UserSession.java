package framework;

import java.util.UUID;

import play.cache.Cache;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Http.Session;

public class UserSession {

    private final String SESSION_KEY = UserSession.class.getName();

    public static UserSession get() {
        final Context context = Http.Context.current();
        final Session session = context.session();
        return new UserSession(session);
    }

    private final Session session;
    private final String userKey;
    // timeout時間。単位は秒
    private int expirationSeconds = 60 * 30;

    private UserSession(final Session session) {
        this.session = session;

        String userKey = session.get(SESSION_KEY);
        if (userKey == null) {
            session.clear();
            userKey = UUID.randomUUID().toString();
            session.put(SESSION_KEY, userKey);
        }
        this.userKey = userKey;
    }

    public void put(final String key, Object obj) {
        Cache.set(myKey(key), obj, expirationSeconds);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(final String key) {
        final Object obj = Cache.get(myKey(key));
        if (obj != null) {
            // timeout時間をリセット
            put(key, obj);
        }
        return (T) obj;
    }

    private String myKey(final String key) {
        return userKey + "." + key;
    }

}
