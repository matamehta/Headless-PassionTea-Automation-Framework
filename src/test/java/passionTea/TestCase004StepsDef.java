package passionTea;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import executionAction.TalkTeaPageAction;

/**
 * Created by zhangd on 4/04/2016.
 */
public class TestCase004StepsDef {
    private static TalkTeaPageAction ttpa;

    @Given("^I open PassionTea talk-to-tea page URL$")
    public void I_open_PassionTea_talktotea_page_URL() throws Throwable {
        ttpa = new TalkTeaPageAction();
    }

    @When("^I fill in the form with \'([^\']*)\', \'([^\']*)\', \'([^\']*)\', \'([^\']*)\' and submit$")
    public void I_fill_in_the_form(String name, String email, String subject, String message) throws Throwable {
        ttpa.sendEmail(name, email, subject, message);
    }

    @Then("^I should see successful message$")
    public void I_should_see_successfuly_message() throws Throwable {
        ttpa.assertSuccessful();
    }
}
