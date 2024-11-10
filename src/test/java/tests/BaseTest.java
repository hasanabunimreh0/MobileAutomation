package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverFactory;

/**
 * BaseTest class initializes and quits the Appium driver for each test class.
 * Provides setup and teardown methods for managing the driver lifecycle.
 */
public abstract class BaseTest {

    // Protected driver instance accessible by subclasses
    protected AppiumDriver<MobileElement> driver;

    /**
     * Set up method to initialize the Appium driver before any test methods in the class.
     * This method is annotated with @BeforeClass, so it runs once per class, before all tests.
     */
    @BeforeClass
    public void setUp() {
        // Get an instance of the driver from DriverFactory
        driver = DriverFactory.getDriver();
    }

    /**
     * Tear down method to quit the Appium driver after all test methods in the class.
     * This method is annotated with @AfterClass, so it runs once per class, after all tests.
     */
    @AfterClass
    public void tearDown() {
        // Quit the driver using DriverFactory to ensure clean-up
        DriverFactory.quitDriver();
    }
}
