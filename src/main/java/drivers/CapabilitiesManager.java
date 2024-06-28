package drivers;

import config.Config;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;


public class CapabilitiesManager {

    public static AndroidDriver<MobileElement> getCapabilities() throws MalformedURLException {
/*        Properties properties = new Properties();
        try {
            String filePath = "C:\\Users\\Shivansh Ahuja\\Documents\\xCube_Spotify_Appium\\src\\test\\resources\\capabilities.properties";
            FileInputStream input = new FileInputStream(filePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //taskkill /F /IM node.exe

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Config.get("platformName"));
        capabilities.setCapability("platformVersion", Config.get("platformVersion"));
        capabilities.setCapability("deviceName", Config.get("deviceName"));
        capabilities.setCapability("automationName", Config.get("automationName"));
        capabilities.setCapability("autoGrantPermissions", Config.get("autoGrantPermissions"));
        capabilities.setCapability("unicodeKeyboard", Config.get("unicodeKeyboard"));
        capabilities.setCapability("resetKeyboard", Config.get("resetKeyboard"));
        String appPath = System.getProperty("user.dir") + "/" + Config.get("appPath");
        capabilities.setCapability("app", appPath);

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL(Config.get("appiumServerUrl")), capabilities);
        return driver;
    }

    public static AndroidDriver<MobileElement> getBrowserStackCapabilities() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.user", Config.get("browserstackUser"));
        caps.setCapability("browserstack.key", Config.get("browserstackKey"));
        caps.setCapability("app", Config.get("browserstackAppId"));
        caps.setCapability("device", Config.get("browserstackDevice"));
        caps.setCapability("os_version", Config.get("browserstackOSVersion"));
        caps.setCapability("project", "My Project");
        caps.setCapability("build", "My Build");
        caps.setCapability("name", "My Test");

        return new AndroidDriver<>(new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
    }
}