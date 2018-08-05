package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = {"@sample"}, 
/*        plugin = { "pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json" }, */
        glue = { "stepDefinitions" })

public class CucumberRunner {

}
