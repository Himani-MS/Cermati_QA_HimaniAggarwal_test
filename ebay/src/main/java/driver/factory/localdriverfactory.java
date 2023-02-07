package driver.factory;

import driver.enums.BrowserType;
import driver.manager.ChromeManager;
import driver.manager.FirefoxManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class localdriverfactory {
    private localdriverfactory() {
    }

    private static final Map<BrowserType, Supplier<WebDriver>> MAP =
            new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }
}
