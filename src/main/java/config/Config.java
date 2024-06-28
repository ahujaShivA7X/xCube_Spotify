package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try {
            String filePath = "C:\\Users\\Shivansh Ahuja\\Documents\\xCube_Spotify_Appium\\src\\test\\resources\\capabilities.properties";
            FileInputStream input = new FileInputStream(filePath);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
