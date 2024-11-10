package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesLoader is a utility class for loading configuration data from a properties file.
 * This class simplifies reading key-value pairs from a specified properties file, making it
 * easy to manage test data and configurations.
 */
public class PropertiesLoader {

    /**
     * Loads properties from a specified file path.
     * @param filePath - The relative path to the properties file.
     * @return Properties - The loaded properties object containing key-value pairs from the file.
     */
    public static Properties loadProperties(String filePath) {
        Properties props = new Properties(); // Create a new Properties object to hold data

        // Try-with-resources to ensure the FileInputStream is closed after use
        try (FileInputStream fis = new FileInputStream("src/test/resources/" + filePath)) {
            props.load(fis); // Load properties from the file input stream
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an exception occurs while loading properties
        }

        return props; // Return the loaded properties
    }
}
