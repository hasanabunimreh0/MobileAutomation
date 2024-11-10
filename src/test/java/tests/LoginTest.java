package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import data.UserData;
import utils.PropertiesLoader;
import java.util.Properties;

/**
 * LoginTest class verifies login functionality using test data from a properties file.
 */
public class LoginTest extends BaseTest {

    @Test(description = "Verifies user can log in with valid credentials")
    public void testLogin() {
        // Load test data from the properties file
        Properties props = PropertiesLoader.loadProperties("testData.properties");

        // Create a UserData object with email and password retrieved from properties
        UserData userData = new UserData(props.getProperty("email"), props.getProperty("password"));

        // Instantiate the LoginPage object and wait for the page to load
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForPageToLoad();

        // Navigate to the login screen
        loginPage.openLoginScreen();

        // Retrieve any initial message on the login screen, if applicable
        String messageText = loginPage.getMessageText();

        // Perform login action with the user's email and password
        loginPage.login(userData.getEmail(), userData.getPassword());

        // Assert that the login was successful by checking the confirmation message
        Assert.assertEquals(messageText, "You are logged in!");
    }
}
