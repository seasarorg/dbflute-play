package framework.seasar;

import java.util.Map;

import javax.transaction.Status;

import org.seasar.extension.jta.ExtendedTransaction;
import org.seasar.extension.jta.TransactionManagerImpl;
import org.seasar.framework.util.TransactionUtil;

import play.mvc.Http;

/**
 * {@link java.lang.ThreadLocal} の代わりにPlayFramework2の {@link play.mvc.Http.Context} をトランザクション保存先とする
 * {@link javax.transaction.TransactionManager} です。
 *
 * @see org.seasar.extension.jta.TransactionManagerImpl
 *
 * @author manhole
 */
public class HttpContextBoundTransactionManager extends TransactionManagerImpl {

    public static final String KEY = HttpContextBoundTransactionManager.class.getSimpleName();

    protected ExtendedTransaction getCurrent() {
        final ExtendedTransaction tx = _getTransaction();
        if (tx != null && TransactionUtil.getStatus(tx) == Status.STATUS_NO_TRANSACTION) {
            setCurrent(null);
            return null;
        }
        return tx;
    }

    protected void setCurrent(final ExtendedTransaction current) {
        _setTransaction(current);
    }

    protected ExtendedTransaction attachNewTransaction() {
        ExtendedTransaction tx = _getTransaction();
        if (tx == null) {
            tx = createTransaction();
            setCurrent(tx);
        }
        return tx;
    }

    protected ExtendedTransaction _getTransaction() {
        final Http.Context context = Http.Context.current.get();
        final Map<String, Object> args = context.args;
        final ExtendedTransaction tx = (ExtendedTransaction) args.get(KEY);
        return tx;
    }

    protected void _setTransaction(final ExtendedTransaction tx) {
        final Http.Context context = Http.Context.current.get();
        final Map<String, Object> args = context.args;
        args.put(KEY, tx);
    }

}
