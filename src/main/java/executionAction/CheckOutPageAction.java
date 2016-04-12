package executionAction;

import config._Constants;
import objectRepo.CheckOutPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;
import utility.Utilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhangd on 4/04/2016.
 * This is the page actions for check out page
 */
public class CheckOutPageAction {
    private CheckOutPage cop = new CheckOutPage();
    private WebDriver driver = DriverFactory.getCurrentDriver();

    /**
     * Constructor
     * Load the page, initiate page elements and clean files in the directory
     */
    public CheckOutPageAction() {
        DriverFactory.loadPage(_Constants.CheckOutPageURL, _Constants.CheckOutPageTitle);
        PageFactory.initElements(driver, cop);

        // Clean previous files in the directory
        try {
            FileUtils.cleanDirectory(new File(_Constants.CheckOutScreenshot));
            Utilities.captureScreenShot(_Constants.CheckOutScreenshot, "TestCase005");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fill in the customer form
     *
     * @param email customer email address
     * @param name customer name
     * @param address customer address
     */
    public void fillCustomerInfo(String email, String name, String address) {
        cop.txtEmail.sendKeys(email);
        cop.txtName.sendKeys(name);
        cop.txtAddress.sendKeys(address);
    }

    /**
     * Fill in the payment form
     *
     * @param cardType customer card type
     * @param cardNo customer card number
     * @param cardholderName customer cardholder name
     * @param verificationCode customer verification code
     */
    public void fillPaymentInfo(String cardType, String cardNo, String cardholderName, String verificationCode) {
        cop.selectCard.sendKeys(cardType);
        cop.txtCardNo.sendKeys(cardNo);
        cop.txtCardHolderName.sendKeys(cardholderName);
        cop.txtVerificationCode.sendKeys(verificationCode);
        cop.btnPlaceOrder.click();
    }
}
