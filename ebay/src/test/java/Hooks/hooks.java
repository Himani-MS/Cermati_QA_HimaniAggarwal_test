
package Hooks;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import factory.configfactory;
import driver.Driver;
import io.cucumber.java.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.ScreenshotUtils.getBase64Image;

public final class hooks {

    private static final Logger LOG = LoggerFactory.getLogger(hooks.class);

    private hooks() {
    }

    Scenario scenario;

    @BeforeAll
    public static void beforeAll() {
        LOG.info("*-*-*-*-*-*-*-*-*-*-*-*-*-*- Execution Started -*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    @Before
    public static void setUp(Scenario scenario) {
        Driver.initDriverForWeb();
        LOG.info("Driver initialized successfully!");
        scenario.log("Driver initialized successfully!");
    }

    @BeforeStep
    public static void beforeStep(Scenario scenario) {
        if (scenario.getStatus() == Status.PASSED) {
            if (includeAllScreenshots()) {
                //scenario.attach(getByteImage(), "image/png", scenario.getName());
                ExtentCucumberAdapter.getCurrentStep().log(com.aventstack.extentreports.Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            }
        }
    }

    @AfterStep
    public static void afterStep(Scenario scenario) {
        if (scenario.getStatus() == Status.PASSED) {
            if (includeAllScreenshots()) {
                //scenario.attach(getByteImage(), "image/png", scenario.getName());
                ExtentCucumberAdapter.getCurrentStep().log(com.aventstack.extentreports.Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
            }
        }
    }

    @After
    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LOG.info(scenario.getName() + " scenario has failed!!");
            scenario.log(scenario.getName() + " scenario has failed!!");
            //scenario.attach(getByteImage(), "image/png", scenario.getName().replaceAll(" ", "_"));
            ExtentCucumberAdapter.getCurrentStep().log(com.aventstack.extentreports.Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
        }
        Driver.quitDriver();
        LOG.info("Driver closed successfully!");
        scenario.log("Driver closed successfully!");
    }

    @AfterAll
    public static void afterAll() {
        LOG.info("*-*-*-*-*-*-*-*-*-*-*-*-*-*- Execution Ended -*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    /**
     * reads value from config to include screenshot in reports
     *
     * @return
     */
    private static boolean includeAllScreenshots() {
        if (configfactory.getConfig().inlcudeAllScreenshots().equalsIgnoreCase("YES")) {
            return true;
        }
        return false;
    }

    /**
     * reads value from config to include failed step screenshot in reports
     *
     * @return
     */
    private static boolean includeFailedStepScreenshot() {
        if (configfactory.getConfig().includeFailedStepScreenshot().equalsIgnoreCase("YES")) {
            return true;
        }
        return false;
    }

}
