package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", plugin = { "pretty", "html:target/cucumber-html-report",
		"json:target/cucumber.json" }, glue = { "stepDefinition" })
public class TestRunner {

}
