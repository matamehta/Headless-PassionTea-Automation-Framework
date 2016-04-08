package passionTea;

import config._Constants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executionAction.CheckOutPageAction;
import org.junit.Assert;
import utility.BrowserDriver;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TestCase005StepsDef {
    private static CheckOutPageAction copa;

    @Given("^I open PassionTea checkout page URL$")
    public void I_open_PassionTea_checkout_page_URL() throws Throwable {
        copa = new CheckOutPageAction();
    }

    @When("^I fill in the customer form with \'([^\"]*)\', \'([^\"]*)\' and \'([^\"]*)\'$")
    public void I_fill_in_the_customer_form(String email, String name, String address) throws Throwable {
        copa.fillCustomerInfo(email, name, address);
    }

    @When("^I fill in the payment form with \'([^\"]*)\', \'([^\"]*)\', \'([^\"]*)\' and \'([^\"]*)\'$")
    public void I_fill_in_the_payment_form(String cardType, String cardNo, String cardholderName, String verificationCode) throws Throwable {
        copa.fillPaymentInfo(cardType, cardNo, cardholderName, verificationCode);
    }

    @Then("^I should go back to menu page$")
    public void I_should_go_back_to_menu_page() throws Throwable {
        Assert.assertTrue(BrowserDriver.getCurrentDriver().getTitle().equals(_Constants.MenuPageTitle));
    }
}
