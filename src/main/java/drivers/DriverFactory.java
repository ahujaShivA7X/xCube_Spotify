package drivers;

import config.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = CapabilitiesManager.getCapabilities();
            driver = new AndroidDriver<>(new URL(Config.get("appium.server.url")), capabilities);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
