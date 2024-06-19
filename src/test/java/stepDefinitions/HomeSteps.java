package stepDefinitions;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;

public class HomeSteps {

    private final HomePage homePage;
    private final LoginPage loginPage;

    public HomeSteps(LoginPage loginPage) throws MalformedURLException {
        this.loginPage = loginPage;
        homePage = new HomePage(DriverFactory.getDriver());
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        /*boolean isSelectMusicButtonVisible = loginPage.isSelectMusicButtonVisible();
        Assert.assertTrue("Home page is not displayed", isSelectMusicButtonVisible);*/
    }

    @Then("I should see the podcast button")
    public void i_should_see_the_podcast_button() {
        Assert.assertTrue("Podcast button is not visible", homePage.isPodcastButtonVisible());
    }

    @Then("I should see the profile button")
    public void i_should_see_the_profile_button() {
        Assert.assertTrue("Profile button is not visible", homePage.isProfileButtonVisible());
    }

    @Then("I should see the premium button")
    public void i_should_see_the_premium_button() {
        Assert.assertTrue("Premium button is not visible", homePage.isPremiumButtonVisible());
    }

    @Then("I should see the home button")
    public void i_should_see_the_home_button() {
        Assert.assertTrue("Home button is not visible", homePage.isHomeButtonVisible());
    }
}
