package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Select Podcasts']")
    private MobileElement podcastButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Profile']")
    private MobileElement profileButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Premium']")
    private MobileElement premiumButton;

    @AndroidFindBy(id = "com.spotify.music:id/home_tab")
    private MobileElement homeButton;

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isPodcastButtonVisible() {
        return podcastButton.isDisplayed();
    }

    public boolean isProfileButtonVisible() {
        return profileButton.isDisplayed();
    }

    public boolean isPremiumButtonVisible() {
        return premiumButton.isDisplayed();
    }

    public boolean isHomeButtonVisible() {
        return homeButton.isDisplayed();
    }
}
