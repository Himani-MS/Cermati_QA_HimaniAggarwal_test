package driver;

import driver.entity.webdriverdata;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
    WebDriver getDriver(webdriverdata webDriverData);
}