package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/login.feature",
        glue = {"steps"},
        tags = "@smoke or @regression",
        monochrome = true,
        plugin = {"pretty","json:target/JSONReports"})
public class CucumberTestRunner {
}
