package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature", glue = { "StepDefinition" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports/index.html", "json:target/Jsonreports/report.json",
		"junit:target/JunitReports/report.xml" }

//plugin= {"pretty","json:target/Jsonreports/report.json"} to generate JSon reports
//plugin= {"pretty","junit:target/JunitReports/report.xml"} to genrate Junit reports
//tags= "@smoketest" to run test based on particular tags
)
public class runnerClass extends AbstractTestNGCucumberTests {

}
