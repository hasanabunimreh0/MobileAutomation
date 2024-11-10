package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

/**
 * DriverFactory uses the Singleton pattern to create a single instance of the Appium Driver.
 * This ensures only one instance of the driver is active at a time, preventing conflicts and
 * improving resource management.
 */
public class DriverFactory {

    // Static variable to hold the single instance of the Appium driver
    private static AppiumDriver<MobileElement> driver;

    // Private constructor to prevent instantiation
    private DriverFactory() {}

    /**
     * Initializes and returns the single instance of Appium driver if it is not already created.
     * @return AppiumDriver<MobileElement> - the singleton Appium driver instance
     */
    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) { // Check if driver instance already exists
            try {
                // Set desired capabilities for the driver
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Name of the emulator or device
                caps.setCapability(MobileCapabilityType.APP, "/path/to/wdiodemoapp.apk"); // Path to the app APK

                // Initialize the Appium driver with the specified capabilities and Appium server URL
                driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
            } catch (Exception e) {
                // Print stack trace if an exception occurs during driver initialization
                e.printStackTrace();
            }
        }
        return driver; // Return the driver instance (newly created or existing)
    }

    /**
     * Quits the driver if it is not null, and resets the driver instance to null.
     * This allows the driver to be reinitialized in future if needed.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit(); // Quit the driver to release resources
            driver = null; // Reset the driver instance to null
        }
    }
}
