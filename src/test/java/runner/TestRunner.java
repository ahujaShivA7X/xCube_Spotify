package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ExtentReportsManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner {

    @BeforeClass
    public void setup() {
        ExtentReportsManager.createInstance("test-output/extent.html");
    }

    @AfterClass
    public void teardown() {
        ExtentReportsManager.flush();
    }
}
