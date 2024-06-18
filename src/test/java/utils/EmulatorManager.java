package utils;

import java.io.IOException;

public class EmulatorManager {

    public static void startEmulator(String avdName) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("emulator", "@" + avdName);
        processBuilder.inheritIO().start();
        Thread.sleep(5000);
    }
}
