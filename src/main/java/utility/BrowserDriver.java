package utility;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zhangd on 4/04/2016.
 */
public class BrowserDriver {
    private static HtmlUnitDriver driver;

    public synchronized static WebDriver getCurrentDriver() {
        String browser;

        if (System.getProperty("selenium.browser") == null) {
            browser = "firefox";
        } else {
            browser = System.getProperty("selenium.browser");
        }

        if (driver == null) {
            try {
                switch (browser) {
                    case "chrome":
                        driver = new HtmlUnitDriver(BrowserVersion.CHROME);
                        break;
                    case "ie":
                        driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11);
                        break;
                    case "firefox":
                    default:
                        driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
                        break;
                }
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
