package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import utils.ExtentReportsManager;
import utils.Hooks;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@Login",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner {

    @BeforeClass
    public static void setUp() throws Exception {
        Hooks.setUp();
    }

    @AfterClass
    public static void tearDown() {
        Hooks.tearDown();
    }
}
