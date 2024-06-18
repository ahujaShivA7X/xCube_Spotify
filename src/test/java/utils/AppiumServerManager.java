package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerManager {

    private static AppiumDriverLocalService appiumService;

    public static void startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        appiumService = AppiumDriverLocalService.buildService(builder);
        appiumService.start();
    }

    public static void stopAppiumServer() {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
        }
    }
}
