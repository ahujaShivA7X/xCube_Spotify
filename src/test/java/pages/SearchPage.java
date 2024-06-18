package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BasePage{

    @AndroidFindBy(id = "com.spotify.music:id/find_search_field_text")
    private MobileElement searchField;

    @AndroidFindBy(id = "com.spotify.music:id/query")
    private MobileElement search;

    @AndroidFindBy(id = "//android.widget.TextView[@resource-id=\"com.spotify.music:id/title\" and @text=\"Linkin Park\"]")
    private MobileElement LinkinPark;

    //android.widget.TextView[@resource-id="com.spotify.music:id/title" and @text="Linkin Park"]

    

    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickOnSearchField() {
        searchField.click();
    }

    public void searchFor(String text) {
        search.sendKeys(text);
    }

    public void clickSearch() {
        search.click();
    }

    public boolean areSearchResultsDisplayed() {
        return LinkinPark.isDisplayed();
    }
}
