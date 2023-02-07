package driver.impl;

import driver.IWebDriver;
import driver.entity.*;
import driver.factory.localdriverfactory;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver {
    @Override
    public WebDriver getDriver(webdriverdata webDriverData) {
        return localdriverfactory.getDriver(webDriverData.getbrowserType());
    }
}