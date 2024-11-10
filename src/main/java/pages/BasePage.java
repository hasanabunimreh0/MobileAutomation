package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage class provides common methods and setup for all page classes.
 * It includes actions like click and type text, as well as a WebDriverWait instance
 * to handle element synchronization.
 */
public abstract class BasePage {

    // Protected driver instance to be used by subclasses
    protected AppiumDriver<MobileElement> driver;

    // WebDriverWait instance for managing explicit waits
    protected WebDriverWait wait;

    /**
     * Constructor initializes the Appium driver and WebDriverWait for subclasses.
     * Uses PageFactory to initialize MobileElement fields with Appium annotations.
     * @param driver - AppiumDriver instance used for interacting with mobile elements.
     */
    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15); // 15-second wait time
        PageFactory.initElements(driver, this); // Initialize elements with PageFactory
    }

    /**
     * Clicks on the given element after waiting until it is clickable.
     * @param element - MobileElement to be clicked.
     */
    protected void click(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Types the given text into the specified element after waiting until it is visible.
     * @param element - MobileElement in which text is to be entered.
     * @param text - String text to be typed into the element.
     */
    protected void typeText(MobileElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    /**
     * Abstract method that must be implemented by subclasses to define how each page waits
     * for its elements to load, ensuring the page is fully loaded before any actions are taken.
     */
    public abstract void waitForPageToLoad();
}
