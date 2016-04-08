package passionTea;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by zhangd on 4/04/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/passionTea/"},
        format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        tags = {"@all"}
)

public class RunTestSuiteTest {
}
