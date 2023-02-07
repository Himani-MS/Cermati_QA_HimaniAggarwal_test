
package factory;

import converters.*;
import driver.enums.*;
import driver.enums.RunModeType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
})
public interface frameworkconfig extends Config {

    @Key("${environment}.webUrl")
    String webUrl();

    @DefaultValue("CHROME")
    @ConverterClass(stringToBrowserTypeConverter.class)
    BrowserType localBrowser();

    @Key("runMode")
    @ConverterClass(stringToRunmodeTypeconverter.class)
    RunModeType runModeType();

    @Key("${environment}.systemUserEmail")
    String username();

    @Key("${environment}.systemUserPwd")
    String encodedPassword();

    @DefaultValue("NO")
    @Key("inlcudeAllScreenshots")
    String inlcudeAllScreenshots();

    @DefaultValue("YES")
    @Key("includeFailedStepScreenshot")
    String includeFailedStepScreenshot();

    @Key("selenoidURL")
    @ConverterClass(stringToURLConverter.class)
    URL selenoidURL();

   

}
