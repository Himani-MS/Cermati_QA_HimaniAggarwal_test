package converters;

import driver.enums.RunModeType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class stringToRunmodeTypeconverter implements Converter<RunModeType> {
    @Override
    public RunModeType convert(Method method, String runMode) {
        return RunModeType.valueOf(runMode.toUpperCase());
    }
}