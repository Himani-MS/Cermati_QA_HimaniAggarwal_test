package driver.factory;

import driver.IWebDriver;
import driver.enums.RunModeType;
import driver.impl.LocalWebDriverImpl;
import driver.impl.LocalWebDriverImpl;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class driverfactory {
    private driverfactory() {
    }

    private static final Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);

    static {
        WEB.put(RunModeType.LOCAL, LocalWebDriverImpl::new);
    }

    public static IWebDriver getDriverForWeb(RunModeType runModeType) {
        return WEB.get(runModeType).get();
    }
}
