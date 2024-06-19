package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.spotify.music:id/username_label")
    private MobileElement usernameLabel;

    @AndroidFindBy(id = "com.spotify.music:id/username_text")
    private MobileElement usernameField;

    @AndroidFindBy(id = "com.spotify.music:id/password_label")
    private MobileElement passwordLabel;

    @AndroidFindBy(id = "com.spotify.music:id/password_text")
    private MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
    private MobileElement loginButton;

    @AndroidFindBy(id = "com.spotify.music:id/later_button")
    private MobileElement maybeLaterButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign up free']")
    private MobileElement signupFreeButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue with phone number']")
    private MobileElement phoneNumberButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue with Google']")
    private MobileElement googleButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue with Facebook']")
    private MobileElement facebookButton;


    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public String getUsernameLabelText() {
        return usernameLabel.getText();
    }

    public String getPasswordLabelText() {
        return passwordLabel.getText();
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickMaybeLaterButton() {
        maybeLaterButton.click();
    }

    public boolean isSignupFreeButtonPresent() {
        return signupFreeButton.isDisplayed();
    }

    public boolean isPhoneNumberButtonPresent() {
        return phoneNumberButton.isDisplayed();
    }

    public boolean isGoogleButtonPresent() {
        return googleButton.isDisplayed();
    }

    public boolean isFacebookButtonPresent() {
        return facebookButton.isDisplayed();
    }

    public boolean isMaybeLaterButtonVisible() {
        try {
            return maybeLaterButton.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}

 /*   public boolean isSelectMusicButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            return wait.until(ExpectedConditions.visibilityOf(By.xpath("//android.widget.Button[@content-desc='Select Music']")))
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}*/