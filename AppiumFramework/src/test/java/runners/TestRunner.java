package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/Reports/cucumber.json", "pretty", "html:target/Reports/cucumber.html"},
        features = "src/test/resources/FeatureFiles",
        glue = "steps",
        tags = "@CToFDemo or @CalculatorDemo"
        )

public class TestRunner {
	
	
}


