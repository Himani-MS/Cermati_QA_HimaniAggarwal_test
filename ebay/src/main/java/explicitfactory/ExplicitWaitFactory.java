
package explicitfactory;

import constants.frameworkconstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(ExplicitWaitFactory.class);

    public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if (waitstrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(frameworkconstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitstrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(frameworkconstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitstrategy == WaitStrategy.VISIBILITY) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(frameworkconstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitstrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }

    public static boolean elementPresenceLocated(By by) {
        try {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(frameworkconstants.getExplicitWaitTime()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static List<WebElement> performVisibilityOfAllElements(List<WebElement> list) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(frameworkconstants.getExplicitWaitTime()))
                .until(ExpectedConditions.visibilityOfAllElements(list));
    }
}

