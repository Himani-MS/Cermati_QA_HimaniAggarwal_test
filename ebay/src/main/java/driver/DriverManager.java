package driver;

import driver.enums.Platformtype;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;

import static driver.enums.Platformtype.WEB;

public final class DriverManager {
    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Platformtype> CONTEXT = ThreadLocal.withInitial(() -> WEB);
    private static final Map<Platformtype, ThreadLocal<WebDriver>> DRIVER_MAP = new EnumMap<>(Platformtype.class);

    public static WebDriver getDriver() {
        return CONTEXT.get() == WEB
                ? WEB_DRIVER_THREAD_LOCAL.get()
                : MOBILE_DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriver(WebDriver driver) {
        WEB_DRIVER_THREAD_LOCAL.set(driver);
        DRIVER_MAP.put(WEB, WEB_DRIVER_THREAD_LOCAL);
        CONTEXT.set(WEB);
    }

    public static void unload() {
        WEB_DRIVER_THREAD_LOCAL.remove();
        MOBILE_DRIVER_THREAD_LOCAL.remove();
        CONTEXT.remove();
    }

}
