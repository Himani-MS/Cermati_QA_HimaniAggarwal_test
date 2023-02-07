package constants;

import factory.configfactory;

public final class frameworkconstants {
    private frameworkconstants() {
    }

    private static final int EXPLICITWAIT_TIME = 20;
    private static final int IMPLICITWAIT_TIME = 20;
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String FEATURE_PATH = RESOURCESPATH + "/features/oms";
    private static final String STEP_DEFS_PATH = System.getProperty("user.dir") + "/src/test/java/setpdef";
    private static final String HOOKS_PATH = System.getProperty("user.dir") + "/src/test/java/Hooks";
    private static final String ORDER_MGT_URL = "https://www.ebay.com";

    public static final String getHooksPath() {
        return HOOKS_PATH;
    }

    public static final String getOmsFeaturePath() {
        return FEATURE_PATH;
    }

    public static final String getStepDefsPath() {
        return STEP_DEFS_PATH;
    }

    public static int getExplicitWaitTime() {
        return EXPLICITWAIT_TIME;
    }

    public static int getImplicitWaitTime() {
        return IMPLICITWAIT_TIME;
    }

    public static String getResourcesPath() {
        return RESOURCESPATH;
    }

    public static String getOrderMgtURL() {
        return ORDER_MGT_URL;
    }

}
