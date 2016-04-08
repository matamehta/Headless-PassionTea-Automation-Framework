package executionAction;

import config._Constants;
import objectRepo.TalkTeaPage;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;
import utility.PublicFunctions;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TalkTeaPageAction {
    TalkTeaPage ttp = new TalkTeaPage();
    WebDriver driver = BrowserDriver.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public TalkTeaPageAction() {
        BrowserDriver.loadPage(_Constants.TalkTeaPageURL, _Constants.TalkTeaPageTitle);
        PageFactory.initElements(driver, ttp);
    }

    /**
     * Fill in the form and submit it
     * @param name
     * @param email
     * @param subject
     * @param message
     */
    public void sendEmail(String name, String email, String subject, String message) throws InterruptedException {
        ttp.textName.sendKeys(name);
        ttp.textEmail.sendKeys(email);
        ttp.textSubject.sendKeys(subject);
        ttp.textareaMessage.sendKeys(message);
        Thread.sleep(5);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement btnSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.className("form-submit")));

        btnSubmit.click();

    }

    /**
     * Assert if the form is submitted successfully or not
     */
    public void assertSuccessful() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement textSuccessfulMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='msg_78ea690540a24bd8b9dcfbf99e999fea']")));
        Assert.assertEquals("Thank you sending us your information. We will get back to you with your Chai :)", textSuccessfulMsg.getText());
    }
}
