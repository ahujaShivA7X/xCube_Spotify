package stepDefinitions;

import drivers.DriverFactory;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ScreenshotUtils;

import java.net.MalformedURLException;

public class HomeSteps {

    private final HomePage homePage;
    public ScreenshotUtils screenshotUtils;

    public HomeSteps(LoginPage loginPage) throws MalformedURLException {
        homePage = new HomePage(DriverFactory.getDriver());
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws InterruptedException {
        Thread.sleep(10000);
        boolean isPodcastButtonVisible = homePage.isPodcastButtonVisible();
        Assert.assertTrue(isPodcastButtonVisible);
        screenshotUtils.takeScreenshot("HomePage");
    }

    @Then("user should see the {string} button")
    public void user_should_see_the_button(String buttonName) {
        switch (buttonName) {
            case "Select Podcasts":
                Assert.assertTrue("Podcast button is not visible", homePage.isPodcastButtonVisible());
                break;
            case "Profile":
                Assert.assertTrue("Profile button is not visible", homePage.isProfileButtonVisible());
                break;
            case "Premium":
                Assert.assertTrue("Premium button is not visible", homePage.isPremiumButtonVisible());
                break;
            case "Home":
                Assert.assertTrue("Home button is not visible", homePage.isHomeButtonVisible());
                break;
            default:
                throw new IllegalArgumentException("Invalid button name: " + buttonName);
        }
    }
}
