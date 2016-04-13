package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zhangd on 4/04/2016.
 */
public class MenuPage {
    @FindBy(xpath = "//a[@id='wsb-button-00000000-0000-0000-0000-000451955160']")
    public WebElement btnCheckOutGreenTea;
    @FindBy(xpath = "//a[@id='wsb-button-00000000-0000-0000-0000-000451959280']")
    public WebElement btnCheckOutRedTea;
    @FindBy(xpath = "//a[@id='wsb-button-00000000-0000-0000-0000-000451961556']")
    public WebElement btnCheckOutOolongTea;
}
