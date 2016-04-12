package executionAction;

import config._Constants;
import objectRepo.MenuPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;
import utility.Utilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 * This is the page actions for menu page
 */
public class MenuPageAction {
    private MenuPage mp = new MenuPage();
    private WebDriver driver = DriverFactory.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public MenuPageAction() {
        DriverFactory.loadPage(_Constants.MenuPageURL, _Constants.MenuPageTitle);
        PageFactory.initElements(driver, mp);

        // Clean previous files in the directory
        try {
            FileUtils.cleanDirectory(new File(_Constants.MenuPageScreenshot));
            Utilities.captureScreenShot(_Constants.MenuPageScreenshot, "TestCase003");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check out one type of tea
     *
     * @param teaType tea type
     */
    public void clickCheckOut(String teaType) {
        switch (teaType) {
            case "Green Tea":
                mp.btnCheckOutGreenTea.click();
                break;
            case "Red Tea":
                mp.btnCheckOutRedTea.click();
                break;
            case "Oolong Tea":
                mp.btnCheckOutOolongTea.click();
                break;
        }
    }
}
