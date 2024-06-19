package pages;

import drivers.CapabilitiesManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.AppiumServerManager;
import utils.EmulatorManager;

import java.io.IOException;

public class TestSetup {

    public static void setUp() throws IOException, InterruptedException {
        AppiumServerManager.startAppiumServer();
        EmulatorManager.startEmulator("Pixel 7 Pro API 34");
    }

    public static void tearDown() {
        AppiumServerManager.stopAppiumServer();
    }
}
