package utils;

import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility to take base64 screenshot.
 */
public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    /**
     * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
     * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
     * a new method. It is advisable to use this method for many reasons.
     */
    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static byte[] getByteImage() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
