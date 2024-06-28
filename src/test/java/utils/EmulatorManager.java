package utils;

import java.io.IOException;

public class EmulatorManager {

    public static void startEmulator() throws IOException {
        Runtime.getRuntime().exec("emulator -avd emulator-5554");
    }

    public static void stopEmulator() throws IOException {
        Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
    }
}
