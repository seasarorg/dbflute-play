package framework;

import org.seasar.framework.container.ComponentCustomizer;
import org.seasar.framework.container.ComponentDef;
import org.seasar.framework.container.creator.ComponentCreatorImpl;
import org.seasar.framework.container.deployer.InstanceDefFactory;
import org.seasar.framework.convention.NamingConvention;

import play.mvc.Controller;

public class ControllerCreator extends ComponentCreatorImpl {

    public ControllerCreator(final NamingConvention namingConvention) {
        super(namingConvention);
        setNameSuffix("Controller");
        setInstanceDef(InstanceDefFactory.SINGLETON);
    }

    @Override
    public ComponentDef createComponentDef(final Class componentClass) {
        if (!Controller.class.isAssignableFrom(componentClass)) {
            /*
             * playが生成するControllerではないクラス
             * (routesやReverseXxxxController)を除外する
             */
            return null;
        }
        final ComponentDef cd = super.createComponentDef(componentClass);
        return cd;
    }

    public ComponentCustomizer getControllerCustomizer() {
        return getCustomizer();
    }

    public void setControllerCustomizer(final ComponentCustomizer customizer) {
        setCustomizer(customizer);
    }

}
