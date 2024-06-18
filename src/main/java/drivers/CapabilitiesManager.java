package drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesManager {

    public static DesiredCapabilities getCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "14.0");
        capabilities.setCapability("deviceName", "Pixel8");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", false);
        capabilities.setCapability("app", "src/test/resources/spotify-8-9-48-575.apk");
        //caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "your.app.package");
        //caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "your.app.MainActivity");

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);


        return capabilities;
    }
}
