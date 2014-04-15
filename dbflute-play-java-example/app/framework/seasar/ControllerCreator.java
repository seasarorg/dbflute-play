package framework.seasar;

import org.seasar.framework.container.ComponentCustomizer;
import org.seasar.framework.container.ComponentDef;
import org.seasar.framework.container.creator.ComponentCreatorImpl;
import org.seasar.framework.container.deployer.InstanceDefFactory;
import org.seasar.framework.convention.NamingConvention;

import play.mvc.Controller;

/**
 * {@link play.mvc.Controller} サブクラスを対象とする {@link org.seasar.framework.container.ComponentCreator} です。
 *
 * @author manhole
 */
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
             * 
             * controllers.member.MemberListController に対してplayが生成するのは3クラス
             * - controllers.member.javascript.ReverseMemberListController
             * - controllers.member.ref.ReverseMemberListController
             * - controllers.member.ReverseMemberListController
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
