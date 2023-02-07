
package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/oms",
        glue = {"stepDefs", "hooks"},
        //tags = "@Test",
        monochrome = false,
        publish = true,
        plugin = {"pretty",
                "html:target/custom-reports/cucumber-htmlreports.html",
                "json:target/custom-reports/cucumber-reports/cucumber-jsonreports.json",
                "junit:target/custom-reports/cucumber-reports/cucumber-junitreports.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        }
)
public class testNgparallel extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
