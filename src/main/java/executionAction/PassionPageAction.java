package executionAction;

import config._Constants;
import objectRepo.PassionPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserDriver;
import utility.PublicFunctions;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 */
public class PassionPageAction {
    PassionPage pp = new PassionPage();
    WebDriver driver = BrowserDriver.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public PassionPageAction() {
        BrowserDriver.loadPage(_Constants.PassionPageURL, _Constants.PassionPageTitle);
        PageFactory.initElements(driver, pp);

        // Clean previous files in the directory
        try {
            FileUtils.cleanDirectory(new File(_Constants.PassionPageScreenshot));
            PublicFunctions.captureScreenShot(driver, _Constants.PassionPageScreenshot, "TestCase002");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
