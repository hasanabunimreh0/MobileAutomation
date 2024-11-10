package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SwipePage;

/**
 * SwipeTest class verifies the swipe functionality to ensure that the SUPPORT VIDEOS card is displayed.
 */
public class SwipeTest extends BaseTest {

    @Test(description = "Navigate to Swipe screen and swipe until SUPPORT VIDEOS card is visible")
    public void testSwipeUntilSupportVideos() {
        // Instantiate the SwipePage and wait for it to load
        SwipePage swipePage = new SwipePage(driver);
        swipePage.waitForPageToLoad();

        // Navigate to the Swipe tab
        swipePage.openSwipeTab();

        // Swipe until the SUPPORT VIDEOS card is visible
        swipePage.swipeUntilSupportVideosVisible();

        // Assert that the SUPPORT VIDEOS card is displayed on the screen
        Assert.assertTrue(swipePage.getSupportVideosCard().isDisplayed(),
                "SUPPORT VIDEOS card should be visible after swiping.");
    }
}
