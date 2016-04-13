package objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TalkTeaPage {
    @FindBy(name = "name")
    public WebElement textName;
    @FindBy(name = "email")
    public WebElement textEmail;
    @FindBy(name = "subject")
    public WebElement textSubject;
    @FindBy(name = "message")
    public WebElement textareaMessage;
}
