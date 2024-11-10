package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormsPage extends BasePage {

    // Locate the Forms tab using XPath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Forms' and @selected='true']")
    private MobileElement formsTab;

    // Locate the text input field by Accessibility ID
    @AndroidFindBy(accessibility = "text-input")
    private MobileElement textInputField;

    // Locate the dropdown field by ID
    @AndroidFindBy(id = "android:id/text1")
    private MobileElement dropdown;

    // Locate dropdown options by XPath
    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='webdriver.io is awesome']")
    private MobileElement dropdownOption1;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Appium is awesome']")
    private MobileElement dropdownOption2;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='This app is awesome']")
    private MobileElement dropdownOption3;

    // Locate the Active button by XPath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Active']")
    private MobileElement activeButton;

    // Locate the confirmation message by ID
    @AndroidFindBy(id = "android:id/message")
    private MobileElement confirmationMessage;

    // Locate the OK button by ID
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    // Constructor to initialize elements
    public FormsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Method to navigate to Forms tab
    public void openFormsTab() {
        formsTab.click();
    }

    // Method to enter text in the input field
    public void enterText(String text) {
        textInputField.sendKeys(text);
    }

    // Method to open dropdown menu
    public void openDropdown() {
        dropdown.click();
    }

    // Method to select dropdown option 1
    public void selectDropdownOption1() {
        dropdownOption1.click();
    }

    // Method to select dropdown option 2
    public void selectDropdownOption2() {
        dropdownOption2.click();
    }

    // Method to select dropdown option 3
    public void selectDropdownOption3() {
        dropdownOption3.click();
    }

    // Method to click the Active button
    public void clickActiveButton() {
        activeButton.click();
    }

    // Method to get the confirmation message text
    public String getConfirmationMessageText() {
        return confirmationMessage.getText();
    }

    // Method to click the OK button
    public void clickOkButton() {
        okButton.click();
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(formsTab));
    }
}
