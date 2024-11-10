package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * LoginPage class for managing login functionality.
 * Contains methods to interact with the email and password fields, login button, and any login-related messages.
 */
public class LoginPage extends BasePage {

    // Locate the email input field by accessibility ID
    @AndroidFindBy(accessibility = "input-email")
    private MobileElement emailField;

    // Locate the password input field by accessibility ID
    @AndroidFindBy(accessibility = "input-password")
    private MobileElement passwordField;

    // Locate the login button by XPath
    @AndroidFindBy(xpath = "/hierarchy/2/0/0/0/0/0/0/0/0/0/0/0/0/0/0/0/3/6/0")
    private MobileElement loginButton;

    // Locate the message element by ID, used for confirmation or error messages
    @AndroidFindBy(id = "android:id/message")
    private MobileElement messageElement;

    // Locate the Login tab by XPath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login' and @class='android.widget.TextView']")
    private MobileElement loginTab;

    /**
     * Constructor to initialize the LoginPage with the given driver.
     * @param driver - AppiumDriver used to interact with mobile elements.
     */
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Method to perform login action by entering email and password and clicking the login button.
     * @param email - User email address to be entered.
     * @param password - User password to be entered.
     */
    public void login(String email, String password) {
        typeText(emailField, email); // Enter email
        typeText(passwordField, password); // Enter password
        click(loginButton); // Click login button
    }

    /**
     * Retrieves the text from the message element, which could display a confirmation or error message.
     * @return String - the text displayed in the message element.
     */
    public String getMessageText() {
        return messageElement.getText();
    }

    /**
     * Navigates to the Login screen by clicking on the Login tab.
     */
    public void openLoginScreen() {
        click(loginTab);
    }

    /**
     * Waits for the page to load by waiting until the email field is visible.
     * This ensures that the main elements of the page are loaded before any interactions are performed.
     */
    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(emailField));
    }
}
