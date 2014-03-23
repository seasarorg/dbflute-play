package framework;

import org.seasar.framework.aop.Pointcut;
import org.seasar.framework.container.customizer.AspectCustomizer;

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
