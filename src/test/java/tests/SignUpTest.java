package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;
import utils.RandomDataGenerator;

/**
 * SignUpTest class verifies the sign-up functionality using random data for email and password.
 */
public class SignUpTest extends BaseTest {

    @Test(description = "Verifies successful sign-up with random email and password")
    public void testSignUp() {
        // Generate random email and password
        String randomEmail = RandomDataGenerator.generateRandomEmail();
        String randomPassword = RandomDataGenerator.generateRandomPassword(10); // Password with 10 characters

        // Instantiate the SignUpPage and wait for it to load
        SignUpPage signUpPage = new SignUpPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginScreen();
        signUpPage.waitForPageToLoad();

        // Navigate to the Sign-Up tab
        signUpPage.selectSignUpTab();

        // Perform sign-up action with random email and password (repeat password matches password)
        signUpPage.signUp(randomEmail, randomPassword, randomPassword);

        // Verify if the sign-up was successful by checking the displayed message
        String messageText = signUpPage.getMessageText();
        Assert.assertEquals(messageText, "You successfully signed up!");

        // Confirm the dialog, if necessary
        signUpPage.clickConfirmButton();
    }
}
