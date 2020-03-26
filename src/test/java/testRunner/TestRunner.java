package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
        (

                features = "src/test/Features/Login.feature",
                glue= "",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty","html:test-output"}
        )


public class TestRunner {


}
