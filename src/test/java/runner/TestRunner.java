package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\cz\\sazka\\tests\\Features", glue = "cz.sazka.tests.Steps")
public class TestRunner {
}
