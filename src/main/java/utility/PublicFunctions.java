package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 */
public class PublicFunctions {
    /**
     * Capture the screen shot
     *
     * @param driver the instance of WebDriver
     */
    public static void captureScreenShot(WebDriver driver, String testCase, String pageName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(testCase + "\\" + pageName + "-" + System.currentTimeMillis() + ".jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
