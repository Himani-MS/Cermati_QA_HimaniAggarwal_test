package driver;


import constants.frameworkconstants;
import driver.entity.webdriverdata;
import driver.factory.driverfactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

import static factory.configfactory.getConfig;

public final class Driver {
    private Driver() {
    }

    public static void initDriverForWeb() {
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = driverfactory.getDriverForWeb(getConfig().runModeType()).getDriver(webDriverData);
            DriverManager.setDriver(driver);
            loadURL();
            implicitWait();
        }
    }

    private static void loadURL() {
        DriverManager.getDriver().get(getConfig().webUrl());
    }

    private static void implicitWait() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(frameworkconstants.getImplicitWaitTime()));
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
