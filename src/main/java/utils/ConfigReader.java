package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fis;
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/GlobalData.properties");
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load GlobalData.properties: " + e.getMessage());
        }
    }

    public static String getProp(String key) {
        if (prop == null) {
            loadConfig();
        }
        return prop.getProperty(key);
    }
}
