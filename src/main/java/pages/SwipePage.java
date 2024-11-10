package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/**
 * SwipePage handles interactions on the swipe screen, including navigation and swiping.
 */
public class SwipePage extends BasePage {

    // Locate the Swipe tab by XPath
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swipe' and @selected='true']")
    private MobileElement swipeTab;

    // Locate the SUPPORT VIDEOS card by its text and class
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SUPPORT VIDEOS' and @class='android.widget.TextView']")
    private MobileElement supportVideosCard;

    public SwipePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    /**
     * Method to navigate to the Swipe tab.
     */
    public void openSwipeTab() {
        click(swipeTab);
    }

    /**
     * Swipes horizontally until the SUPPORT VIDEOS card is visible on the screen.
     * Uses a left-to-right swipe gesture to search for the card.
     */
    public void swipeUntilSupportVideosVisible() {
        Dimension size = driver.manage().window().getSize();
        int startX = (int) (size.width * 0.8); // Start swipe near the right edge of the screen
        int endX = (int) (size.width * 0.2);   // End swipe near the left edge of the screen
        int y = (int) (size.height * 0.71);    // Swipe at the vertical position of SUPPORT VIDEOS

        while (!isElementVisible(supportVideosCard)) {
            new TouchAction<>(driver)
                    .press(PointOption.point(startX, y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(endX, y))
                    .release()
                    .perform();
        }
    }

    /**
     * Checks if an element is currently visible on the screen.
     * @param element The MobileElement to check.
     * @return true if the element is visible, false otherwise.
     */
    private boolean isElementVisible(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Exposes the SUPPORT VIDEOS card for assertion checks.
     * @return MobileElement - the SUPPORT VIDEOS card.
     */
    public MobileElement getSupportVideosCard() {
        return supportVideosCard;
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(swipeTab));
    }
}
