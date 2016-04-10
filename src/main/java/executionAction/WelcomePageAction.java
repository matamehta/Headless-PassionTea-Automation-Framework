package executionAction;

import config._Constants;
import objectRepo.WelcomePage;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
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
public class WelcomePageAction {
    WelcomePage wp = new WelcomePage();
    WebDriver driver = BrowserDriver.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public WelcomePageAction() {
        BrowserDriver.loadPage(_Constants.WelcomePageURL, _Constants.WelcomePageTitle);
        PageFactory.initElements(driver, wp);

        // Clean previous files in the directory
        try {
            FileUtils.cleanDirectory(new File(_Constants.WelcomePageScreenshot));
            PublicFunctions.captureScreenShot(driver, _Constants.WelcomePageScreenshot, "TestCase001");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Assert if navigation bar's link and text are correct
     */
    public void assertWelcomePageLink() {
        try {
            // Assert link
            Assert.assertEquals(_Constants.BaseURL + "welcome.html", wp.navbarWelcome.getAttribute("href"));
            Assert.assertEquals(_Constants.BaseURL + "our-passion.html", wp.navbarPassion.getAttribute("href"));
            Assert.assertEquals(_Constants.BaseURL + "menu.html", wp.navbarMenu.getAttribute("href"));
            Assert.assertEquals(_Constants.BaseURL + "let-s-talk-tea.html", wp.navbarTalkTea.getAttribute("href"));
            Assert.assertEquals(_Constants.BaseURL + "check-out.html", wp.navbarCheckOut.getAttribute("href"));

            // Assert text
            Assert.assertEquals("Welcome", wp.navbarWelcome.getText());
            Assert.assertEquals("Our Passion", wp.navbarPassion.getText());
            Assert.assertEquals("Menu", wp.navbarMenu.getText());
            Assert.assertEquals("Let's Talk Tea", wp.navbarTalkTea.getText());
            Assert.assertEquals("Check Out", wp.navbarCheckOut.getText());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
