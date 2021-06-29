package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/main/resources/Features/",
        glue="stepDefs",
        tags={"@ringcentral"}
)
public class testrunner extends AbstractTestNGCucumberTests {}

