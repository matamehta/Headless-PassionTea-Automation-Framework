package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zhangd on 4/04/2016.
 */
public class WelcomePage {
    @FindBy(linkText = "Welcome")
    public WebElement navbarWelcome;
    @FindBy(linkText = "Our Passion")
    public WebElement navbarPassion;
    @FindBy(linkText = "Menu")
    public WebElement navbarMenu;
    @FindBy(linkText = "Let's Talk Tea")
    public WebElement navbarTalkTea;
    @FindBy(linkText = "Check Out")
    public WebElement navbarCheckOut;
}
