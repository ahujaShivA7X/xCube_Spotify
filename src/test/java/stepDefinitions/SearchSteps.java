package stepDefinitions;

import drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchPage;

import java.net.MalformedURLException;

public class SearchSteps {

    private final SearchPage searchPage;

    public SearchSteps(SearchPage searchPage) throws MalformedURLException {
        this.searchPage = searchPage;
    }

    @When("I go to the search page and search for {string}")
    public void i_go_to_the_search_page_and_search_for(String searchText) {
        searchPage.clickOnSearchField();
        searchPage.clickSearch();
        searchPage.searchFor(searchText);
    }

    @Then("I should see search results")
    public void i_should_see_search_results() {
        Assert.assertTrue("Search results are not displayed", searchPage.areSearchResultsDisplayed());
    }


}
