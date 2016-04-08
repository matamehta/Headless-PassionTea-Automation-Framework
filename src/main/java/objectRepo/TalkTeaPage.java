package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TalkTeaPage {
    @FindBy(xpath = ".//*[@id='form_78ea690540a24bd8b9dcfbf99e999fea']/div[1]/div[1]/input")
    public WebElement textName;
    @FindBy(name = "email")
    public WebElement textEmail;
    @FindBy(name = "subject")
    public WebElement textSubject;
    @FindBy(xpath = ".//*[@id='form_78ea690540a24bd8b9dcfbf99e999fea']/div[1]/div[4]/textarea")
    public WebElement textareaMessage;
}
