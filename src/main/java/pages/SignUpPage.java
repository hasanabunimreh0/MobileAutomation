package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * SignUpPage handles all elements and actions on the Sign-Up screen.
 * It includes methods for interacting with fields like email, password, and repeat password,
 * as well as elements such as the Sign-Up button and confirmation message.
 */
public class SignUpPage extends BasePage {

    // Locate the Sign-Up tab by XPath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up']")
    private MobileElement signUpTab;

    // Locate the email input field by accessibility ID
    @AndroidFindBy(accessibility = "input-email")
    private MobileElement emailInputField;

    // Locate the password input field by accessibility ID
    @AndroidFindBy(accessibility = "input-password")
    private MobileElement passwordInputField;

    // Locate the repeat password input field by accessibility ID
    @AndroidFindBy(accessibility = "input-repeat-password")
    private MobileElement repeatPasswordInputField;

    // Locate the Sign-Up button by XPath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN UP']")
    private MobileElement signUpButton;

    // Locate the confirmation message by ID
    @AndroidFindBy(id = "android:id/message")
    private MobileElement messageElement;

    // Locate the confirm button by ID
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmButton;

    /**
     * Constructor initializes the driver for the SignUpPage.
     * @param driver - AppiumDriver used to interact with mobile elements.
     */
    public SignUpPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Method to perform the sign-up action by entering email, password, and repeat password.
     * After filling in the fields, it clicks the Sign-Up button.
     * @param email - User email address to be entered.
     * @param password - User password to be entered.
     * @param repeatPassword - Confirmation of the user password.
     */
    public void signUp(String email, String password, String repeatPassword) {
        typeText(emailInputField, email);
        typeText(passwordInputField, password);
        typeText(repeatPasswordInputField, repeatPassword);
        click(signUpButton);
    }

    /**
     * Retrieves the text of the confirmation message element.
     * @return String - the text displayed in the confirmation message.
     */
    public String getMessageText() {
        return messageElement.getText();
    }

    /**
     * Clicks the confirm button to close the confirmation dialog.
     */
    public void clickConfirmButton() {
        confirmButton.click();
    }

    /**
     * Clicks on the Sign-Up tab to navigate to the Sign-Up screen.
     */
    public void selectSignUpTab() {
        signUpTab.click();
    }

    /**
     * Waits for the page to load by waiting until the email input field is visible.
     * This ensures that the main elements of the page are loaded before any interaction.
     */
    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(emailInputField));
    }
}
