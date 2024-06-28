package runner;

import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.ExtentReportsManager;
import utils.Hooks;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@Regression",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner {

    @BeforeClass
    public static void setUp() throws Exception {
       // EmulatorManager.startEmulator();
        Hooks.setUp();
        ExtentReportsManager.getInstance();
    }

    @AfterClass
    public static void tearDown() throws IOException {
        //EmulatorManager.stopEmulator();
        Hooks.tearDown();
        ExtentReportsManager.flush();
    }
}
