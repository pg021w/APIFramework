package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",glue = "stepDefinitions",
dryRun = false,tags = "@GetNegative",plugin = "json:target/Reports/Report.json")
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
