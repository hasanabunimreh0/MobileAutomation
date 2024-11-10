package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;

/**
 * FormsTest class verifies the functionality of the Forms page elements and interactions.
 */
public class FormsTest extends BaseTest {

    @Test(description = "Verifies navigation to Forms tab and text input functionality")
    public void testFormsTabAndTextInput() {
        // Instantiate the FormsPage object and wait for the page to load
        FormsPage formsPage = new FormsPage(driver);
        formsPage.waitForPageToLoad();

        // Navigate to the Forms tab
        formsPage.openFormsTab();

        // Enter text into the input field
        String inputText = "Sample Input";
        formsPage.enterText(inputText);

    }

    @Test(description = "Verifies dropdown selection functionality with each option")
    public void testDropdownSelection() {
        // Instantiate the FormsPage object
        FormsPage formsPage = new FormsPage(driver);

        // Open the dropdown and select the first option
        formsPage.openDropdown();
        formsPage.selectDropdownOption1();

        // Re-open the dropdown and select the second option
        formsPage.openDropdown();
        formsPage.selectDropdownOption2();

        // Re-open the dropdown and select the third option
        formsPage.openDropdown();
        formsPage.selectDropdownOption3();
    }

    @Test(description = "Verifies activation button functionality and confirmation message")
    public void testActivationAndConfirmationMessage() {
        // Instantiate the FormsPage object
        FormsPage formsPage = new FormsPage(driver);

        // Click the Active button to trigger activation
        formsPage.clickActiveButton();

        // Retrieve and verify the confirmation message text
        String actualMessage = formsPage.getConfirmationMessageText();
        String expectedMessage = "This button is active";
        Assert.assertEquals(actualMessage, expectedMessage);

        // Dismiss the confirmation message by clicking the OK button
        formsPage.clickOkButton();
    }
}
