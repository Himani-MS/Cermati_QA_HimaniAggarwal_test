
package pages;

import constants.frameworkconstants;
import driver.DriverManager;
import enums.WaitStrategy;
import explicitfactory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static enums.LogType.CONSOLE;
import static logger.FrameworkLogger.log;

public class BasePO {

    protected BasePO() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(BasePO.class);

    protected void click(By by, WaitStrategy waitstrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        log(CONSOLE, elementName + " is clicked");
    }

    protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        log(CONSOLE, value + " is entered successfully in " + elementName);
    }

    protected String getText(By by, WaitStrategy waitstrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        return element.getText();
    }

    protected boolean isElementAvailable(By by) {
        try {
            return ExplicitWaitFactory.elementPresenceLocated(by);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected void performImplicitWait() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(frameworkconstants.getImplicitWaitTime()));
    }

    protected String getCurrentPageURL() {
        LOG.info("Fetching current page URL");
        return DriverManager.getDriver().getCurrentUrl();
    }

    protected List<WebElement> getListOfWebElement(By by) {
        return DriverManager.getDriver().findElements(by);
    }

}
