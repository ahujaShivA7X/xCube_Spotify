package stepDefinitions;

import drivers.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import pages.LoginPage;
import pages.TestSetup;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginSteps {

    public void setUp() throws IOException, InterruptedException {
        TestSetup.setUp();
    }

    private LoginPage loginPage;

    public LoginSteps() throws MalformedURLException {
        AppiumDriver<MobileElement> driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I start the Appium server and emulator")
    public void i_start_the_Appium_server_and_emulator() throws IOException, InterruptedException {
       setUp();
    }

    @Given("I am on the Spotify login page")
    public void i_am_on_the_Spotify_login_page() {
        loginPage.isFacebookButtonPresent();
    }

    @And("I verify the username and password label texts")
    public void iVerifyTheUsernameAndPasswordLabelTexts() {
        String userText = loginPage.getUsernameLabelText();
        String passText = loginPage.getPasswordLabelText();
        Assert.assertEquals(userText, "Email or Username");
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
    public void i_should_see_the_home_page() {
        if (loginPage.isMaybeLaterButtonVisible()) {
            loginPage.clickMaybeLaterButton();
        }
        boolean isSelectMusicButtonVisible = loginPage.isSelectMusicButtonVisible();
        Assert.assertTrue("Home page is not displayed", isSelectMusicButtonVisible);
    }

    @Then("I should see the {string} button")
    public void i_should_see_the_button(String buttonText) {
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

    @After
    public void tearDown() {
        TestSetup.tearDown();
    }


}

