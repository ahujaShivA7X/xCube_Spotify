package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public static void setUp() throws Exception {
        AppiumServerManager.startServer();
    }

    @After
    public static void tearDown() {
        AppiumServerManager.stopServer();
    }
}
