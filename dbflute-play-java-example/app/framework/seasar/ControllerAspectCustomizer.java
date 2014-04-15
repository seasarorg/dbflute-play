package framework.seasar;

import org.seasar.framework.aop.Pointcut;
import org.seasar.framework.container.customizer.AspectCustomizer;

/**
 * 常に {@link framework.seasar.ControllerPointcut} を返す {@link org.seasar.framework.container.customizer.AspectCustomizer} です。
 * 
 * @author manhole
 */
public class ControllerAspectCustomizer extends AspectCustomizer {

    private final Pointcut pointcut = new ControllerPointcut();

    @Override
    public void setPointcut(final String pointcut) {
        throw new UnsupportedOperationException("setPointcut");
    }

    @Override
    protected Pointcut createPointcut() {
        return pointcut;
    }

}
