package framework.seasar;

import org.seasar.framework.convention.impl.NamingConventionImpl;
import org.seasar.framework.util.StringUtil;

public class PlayNamingConvention extends NamingConventionImpl {

    //private static final Logger logger = LoggerFactory.getLogger(PlayNamingConvention.class);

    @Override
    public boolean isTargetClassName(final String className, final String suffix) {
        // logger.debug("{}, {}", className, suffix);
        final boolean result = super.isTargetClassName(className, suffix);
        if (!result) {
            /*
             * middlePkgName抜きでもOKにする。
             * 
             * playのControllerは"controllers.FooController"というネーミングが標準であるため、
             * S2のmiddle package nameと相性が悪い。
             * ここに来た時点でrootPackageNameの判定はクリアしているので、suffixが合っているかだけをチェックすればOK
             */
            // 末尾の"Impl"を除く
            final String trimSuffix = StringUtil.trimSuffix(className, getImplementationSuffix());
            if (trimSuffix.endsWith(suffix)) {
                return true;
            }
        }
        return result;
    }

}
