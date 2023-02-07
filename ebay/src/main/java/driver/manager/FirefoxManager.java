package driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager {
    private FirefoxManager() {
    }

    public static WebDriver getDriver() {
        return new FirefoxDriver();
    }
}