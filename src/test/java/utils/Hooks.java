package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportsManager;
import utils.SlackIntegration;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentReportsManager.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportsManager.getTest().fail("Scenario failed: " + scenario.getName());
            SlackIntegration.sendMessage("Test failed: " + scenario.getName());
        } else {
            ExtentReportsManager.getTest().pass("Scenario passed: " + scenario.getName());
        }
    }
}
