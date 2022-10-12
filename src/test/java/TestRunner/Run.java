package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {".//Features/LoginFeatures.feature"},
        glue = "StepDefinition",
        dryRun = false,  //mapping of feature file with step definition in case of True
        monochrome = true,
        tags = "@Sanity",
        plugin = {"pretty", "html:Target/cucumber-reports/reports1.html"}

)

public class Run extends AbstractTestNGCucumberTests {
    // No code inside this
}
