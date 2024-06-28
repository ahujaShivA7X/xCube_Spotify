package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import drivers.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;

import utils.AppiumServerManager;
import utils.ExtentReportsManager;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginSteps {

    private final LoginPage loginPage;
    public ScreenshotUtils screenshotUtils;

    public LoginSteps() throws MalformedURLException {
        AndroidDriver<MobileElement> driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        screenshotUtils = new ScreenshotUtils(driver);
    }

    @Given("I am on the Spotify login page")
    public void i_am_on_the_Spotify_login_page() throws IOException, InterruptedException {
       // AppiumServerManager.startServer();
        loginPage.isFacebookButtonPresent();
        //ExtentTest test = ExtentReportsManager.createTest("Login Test");
    }

    @And("I verify the username and password label texts")
    public void iVerifyTheUsernameAndPasswordLabelTexts() {
        String userText = loginPage.getUsernameLabelText();
        String passText = loginPage.getPasswordLabelText();
        Assert.assertEquals(userText, "Email or username");
        Assert.assertEquals(passText, "Password");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the home page")
    public void i_should_see_the_home_page() throws InterruptedException {
        Thread.sleep(6000);
        screenshotUtils.takeScreenshot("LoginSuccess");
        //SlackIntegration.sendNotification("Search test completed");
        /*if (loginPage.isMaybeLaterButtonVisible()) {
            loginPage.clickMaybeLaterButton();
        }
        boolean isSelectMusicButtonVisible = loginPage.isSelectMusicButtonVisible();
        Assert.assertTrue("Home page is not displayed", isSelectMusicButtonVisible);*/
    }

    @Then("I should see the {string} button")
    public void i_should_see_the_button(String buttonText) {
        screenshotUtils.takeScreenshot("Login Page Success");
        switch (buttonText) {
            case "Sign up free":
                Assert.assertTrue(loginPage.isSignupFreeButtonPresent());
                break;
            case "Continue with phone number":
                Assert.assertTrue(loginPage.isPhoneNumberButtonPresent());
                break;
            case "Continue with Google":
                Assert.assertTrue(loginPage.isGoogleButtonPresent());
                break;
            case "Continue with Facebook":
                Assert.assertTrue(loginPage.isFacebookButtonPresent());
                break;
            default:
                Assert.fail("Button not found: " + buttonText);
        }
    }
}

