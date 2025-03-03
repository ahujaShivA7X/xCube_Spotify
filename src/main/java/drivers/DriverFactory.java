package drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class DriverFactory {
    private static AndroidDriver driver;

    public static AndroidDriver<MobileElement> getDriver() throws MalformedURLException {
        /*if (driver == null) {
            AndroidDriver<MobileElement> capabilities = CapabilitiesManager.getCapabilities();
            driver = capabilities;
        }
        return driver;*/

        try {
            if (Boolean.parseBoolean(config.Config.get("useBrowserStack"))) {
                driver = CapabilitiesManager.getBrowserStackCapabilities();
            } else {
                driver = CapabilitiesManager.getCapabilities();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
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
