package framework.seasar;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.seasar.framework.aop.Pointcut;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.mvc.Controller;

/**
 * {@link play.mvc.Controller} サブクラスで、getter/setter以外のメソッドを対象とする {@link org.seasar.framework.aop.Pointcut} です。
 *
 * @author manhole
 */
class ControllerPointcut implements Pointcut {

    private static final Logger logger = LoggerFactory.getLogger(ControllerPointcut.class);

    /*
     * ここに渡されるメソッドは、publicのみ。
     */
    @Override
    public boolean isApplied(final Method method) {
        final Class<?> declaringClass = method.getDeclaringClass();
        final int modifiers = method.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            return false;
        }
        if (Modifier.isFinal(method.getModifiers())) {
            return false;
        }
        if (!Controller.class.isAssignableFrom(declaringClass)) {
            return false;
        }

        /*
         * getter/setterを除く
         */
        final BeanDesc beanDesc = BeanDescFactory.getBeanDesc(declaringClass);
        final int propertyDescSize = beanDesc.getPropertyDescSize();
        for (int i = 0; i < propertyDescSize; i++) {
            final PropertyDesc pd = beanDesc.getPropertyDesc(i);
            if (pd.hasReadMethod()) {
                if (pd.getReadMethod().equals(method)) {
                    return false;
                }
            }
            if (pd.hasWriteMethod()) {
                if (pd.getWriteMethod().equals(method)) {
                    return false;
                }
            }
        }

        logger.debug("apply: {}", method);
        return true;
    }

}
