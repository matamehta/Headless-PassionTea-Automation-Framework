package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 * This is a Public Functions class to define some public functions
 */
public class Utilities {
    private static WebDriver driver = DriverFactory.getCurrentDriver();
    private static Actions actions = new Actions(driver);

    /**
     * Capture the screen shot
     *
     * @param testCase test case's name
     * @param pageName the current web page's name
     */
    public static void captureScreenShot(String testCase, String pageName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(testCase + "\\" + pageName + "-" + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Double click one web element
     *
     * @param element the web element user want to double click
     */
    public static void mouseDoubleClick(WebElement element) {
        actions.doubleClick(element);
    }

    /**
     * Mouse right click one web element
     *
     * @param element the web element user want to perform right click on
     */
    public static void mouseRightClick(WebElement element) {
        actions.moveToElement(element).perform();
        actions.contextClick().perform();
    }

    /**
     * Move mouse to one element
     *
     * @param element the web element user want to perform hover on
     */
    public static void mouseHover(WebElement element) {
        actions.moveToElement(element);
    }

    /**
     * Drag one element to another element
     *
     * @param sourceElement the source web element user want to drag
     * @param targetElement the target web element user want to drop
     */
    public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    /**
     * Type a ENTER, BACKSPACE or whatever
     *
     * @param key the specific keyboard character user want to enter
     */
    public static void sendKeyBoard(Keys key) {
        actions.sendKeys(key);
    }
}
