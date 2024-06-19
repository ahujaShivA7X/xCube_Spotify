package drivers;

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
        Properties properties = new Properties();
        try {
            String filePath = "C:\\Users\\Shivansh Ahuja\\Documents\\xCube_Spotify_Appium\\src\\test\\resources\\capabilities.properties";
            FileInputStream input = new FileInputStream(filePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", properties.getProperty("platformName"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
        capabilities.setCapability("automationName", properties.getProperty("automationName"));
        capabilities.setCapability("autoGrantPermissions", properties.getProperty("autoGrantPermissions"));
        capabilities.setCapability("unicodeKeyboard", properties.getProperty("unicodeKeyboard"));
        capabilities.setCapability("resetKeyboard", properties.getProperty("resetKeyboard"));
        String appPath = System.getProperty("user.dir") + "/" + properties.getProperty("appPath");
        capabilities.setCapability("app", appPath);

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL(properties.getProperty("appiumServerUrl")), capabilities);
        return driver;
    }
}