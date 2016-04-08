package executionAction;

import config._Constants;
import objectRepo.CheckOutPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.BrowserDriver;
import utility.PublicFunctions;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 */
public class CheckOutPageAction {
    CheckOutPage cop = new CheckOutPage();
    WebDriver driver = BrowserDriver.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public CheckOutPageAction() {
        BrowserDriver.loadPage(_Constants.CheckOutPageURL, _Constants.CheckOutPageTitle);
        PageFactory.initElements(driver, cop);
    }

    /**
     * Fill in the customer form
     *
     * @param email
     * @param name
     * @param address
     */
    public void fillCustomerInfo(String email, String name, String address) {
        cop.txtEmail.sendKeys(email);
        cop.txtName.sendKeys(name);
        cop.txtAddress.sendKeys(address);
    }

    /**
     * Fill in the payment form
     *
     * @param cardType
     * @param cardNo
     * @param cardholderName
     * @param verificationCode
     */
    public void fillPaymentInfo(String cardType, String cardNo, String cardholderName, String verificationCode) {
        cop.selectCard.sendKeys(cardType);
        cop.txtCardNo.sendKeys(cardNo);
        cop.txtCardHolderName.sendKeys(cardholderName);
        cop.txtVerificationCode.sendKeys(verificationCode);
        cop.btnPlaceOrder.click();
    }
}
