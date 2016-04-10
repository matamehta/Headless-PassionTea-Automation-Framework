package utility;

import net.anthavio.phanbedder.Phanbedder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by zhangd on 4/04/2016.
 */
public class BrowserDriver {
    private static File phantomJSFile = Phanbedder.unpack();
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static WebDriver driver;

    public synchronized static WebDriver getCurrentDriver() {
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJSFile.getAbsolutePath());

        if (driver == null) {
            try {
                driver = new PhantomJSDriver(desiredCapabilities);
                driver.manage().window().maximize();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            driver = null;
        } catch (UnreachableBrowserException e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate to the specified page
     *
     * @param url       page URL
     * @param pageTitle the title of page
     */
    public static void loadPage(String url, String pageTitle) {
        getCurrentDriver().navigate().to(url);
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.titleIs(pageTitle));
    }
}
