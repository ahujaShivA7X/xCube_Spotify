package utils;

import drivers.CapabilitiesManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

import java.io.File;
import java.net.MalformedURLException;

public class AppiumServerManager {

    private static AppiumDriverLocalService appiumService;

    public static void startServer() {

        appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                .withArgument(() -> "-pa", "/wd/hub")
                .withAppiumJS(new File("C:\\Users\\Shivansh Ahuja\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")));
        appiumService.start();
    }

    public static void stopServer() {
        if (appiumService != null) {
            appiumService.stop();
        }
    }
}
