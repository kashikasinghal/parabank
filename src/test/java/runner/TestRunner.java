package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    tags = "@TC_002 or @TC_003 or @TC_004",
    plugin = {
        "pretty",
        // Built-in Cucumber reports
        "html:target/cucumber-reports/cucumber.html"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {}
