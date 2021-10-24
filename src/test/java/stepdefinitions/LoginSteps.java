package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @When("user gets title of page")
    public void userGetsTitleOfPage() {
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String arg0) {
    }

    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        DriverFactory.getDriver().get("https://www.myntra.com/");
    }
}
