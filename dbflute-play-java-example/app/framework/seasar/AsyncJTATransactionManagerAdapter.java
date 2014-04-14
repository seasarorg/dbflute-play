package framework.seasar;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.seasar.extension.tx.TransactionCallback;
import org.seasar.extension.tx.adapter.JTATransactionManagerAdapter;

import play.libs.F;
import play.libs.F.Callback;
import play.mvc.Result;

public class AsyncJTATransactionManagerAdapter extends JTATransactionManagerAdapter {

    public AsyncJTATransactionManagerAdapter(final UserTransaction userTransaction,
            final TransactionManager transactionManager) {
        super(userTransaction, transactionManager);
    }

    @Override
    public Object required(final TransactionCallback callback) throws Throwable {
        final boolean began = begin();
        final Object executed;
        try {
            executed = callback.execute(this);
        } catch (final Throwable th) {
            // 同期処理で例外が起きたらここを通る
            if (began) {
                end();
            }
            throw th;
        }

        // play.mvc.Result などの場合は同期処理。
        if (!(executed instanceof F.Promise)) {
            if (began) {
                end();
            }
            return executed;
        }

        final F.Promise<Result> promise = (F.Promise<Result>) executed;
        final F.Promise<Result> result = promise.map(new F.Function<Result, Result>() {
            @Override
            public Result apply(final Result o) throws Throwable {
                if (began) {
                    end();
                }
                return o;
            }
        });
        result.onFailure(new Callback<Throwable>() {
            @Override
            public void invoke(final Throwable th) throws Throwable {
                /*
                 * 汎用化するならTxRuleに対応する必要があるかな?
                 */
                setRollbackOnly();
                if (began) {
                    end();
                }
            }
        });
        return result;
    }

    @Override
    public Object requiresNew(final TransactionCallback callback) throws Throwable {
        throw new UnsupportedOperationException("NotImplemented: requiresNew");
    }

    @Override
    public Object mandatory(final TransactionCallback callback) throws Throwable {
        throw new UnsupportedOperationException("NotImplemented: mandatory");
    }

    @Override
    public Object notSupported(final TransactionCallback callback) throws Throwable {
        throw new UnsupportedOperationException("NotImplemented: notSupported");
    }

    @Override
    public Object never(final TransactionCallback callback) throws Throwable {
        throw new UnsupportedOperationException("NotImplemented: never");
    }

}
