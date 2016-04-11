package passionTea;

import config._Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import executionAction.MenuPageAction;
import org.junit.Assert;
import utility.DriverFactory;

/**
 * Created by zhangd on 4/04/2016.
 * This is the step definition of test case 003
 */
public class TestCase003StepsDef {
    private static MenuPageAction mpa;

    @Given("^I open PassionTea menu page URL$")
    public void I_open_PassionTea_menu_page_URL() throws Throwable {
        mpa = new MenuPageAction();
    }

    @And("^I check out \"([^\"]*)\"$")
    public void I_check_out_tea(String tea) throws Throwable {
        mpa.clickCheckOut(tea);
    }

    @Then("^I should land at check out page$")
    public void I_should_land_at_check_out_page() throws Throwable {
        Assert.assertTrue(DriverFactory.getCurrentDriver().getTitle().equals(_Constants.CheckOutPageTitle));
    }
}
