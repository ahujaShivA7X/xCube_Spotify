package pages;

import utils.AppiumServerManager;
import utils.EmulatorManager;

import java.io.IOException;

public class TestSetup {

    public static void setUp() throws IOException, InterruptedException {
        AppiumServerManager.startAppiumServer();

        EmulatorManager.startEmulator("Pixel8");

    }

    public static void tearDown() {
        AppiumServerManager.stopAppiumServer();
    }
}
