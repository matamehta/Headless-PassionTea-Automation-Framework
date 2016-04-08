package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zhangd on 4/04/2016.
 */
public class CheckOutPage {
    @FindBy(id = "email")
    public WebElement txtEmail;
    @FindBy(id = "name")
    public WebElement txtName;
    @FindBy(id = "address")
    public WebElement txtAddress;
    @FindBy(id = "card_type")
    public WebElement selectCard;
    @FindBy(id = "card_number")
    public WebElement txtCardNo;
    @FindBy(id = "cardholder_name")
    public WebElement txtCardHolderName;
    @FindBy(id = "verification_code")
    public WebElement txtVerificationCode;
    @FindBy(css = ".btn.btn-primary")
    public WebElement btnPlaceOrder;
}
