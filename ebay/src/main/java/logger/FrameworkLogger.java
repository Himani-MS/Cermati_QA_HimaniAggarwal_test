package logger;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static utils.ScreenshotUtils.getBase64Image;

public class FrameworkLogger {
    private FrameworkLogger() {
    }

    private static Consumer<String> CONSOLE = ($) -> System.out.println("INFO----> " + $);

    private static Map<LogType, Consumer<String>> MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.CONSOLE, CONSOLE);
    }

    public static void log(LogType status, String message) {
        MAP.get(status).accept(message);
    }

}
