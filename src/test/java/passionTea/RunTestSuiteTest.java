package passionTea;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by zhangd on 4/04/2016.
 * This is the endpoint of running test suites
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/passionTea/"},
        tags = {"@All"},
        format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        plugin = {"json:target/cucumber-json-report.json"}
)

public class RunTestSuiteTest {
}
