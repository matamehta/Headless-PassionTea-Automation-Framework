package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by zhangd on 4/04/2016.
 */
public class PublicFunctions {

    /**
     * Move the mouse to one specific element
     * @param driver the instance of WebDriver
     * @param element WebElement you want to hover on
     */
    public static void mouseHoverToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
