package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.LoginPage;
import util.ConfigReader;

import java.util.Properties;

public class LandingSteps {

    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("user is on landing page")
    public void userIsOnLandingPage() {
        DriverFactory.getDriver().get("https://www.myntra.com/");
    }


    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        String actualTitle = landingPage.getTitle();
        Assert.assertTrue("Verify title for the page", actualTitle.contains(expectedTitle));
    }

    @Given("user searches for product {string} on product page")
    public void userSearchesForProductOnProductPage(String arg0) {
        landingPage.enterSearchQuery(arg0);
    }

    @When("user logs in with his credentials")
    public void userLogsInWithHisCredentials() {
        landingPage.hoverOverProfileTab();
        landingPage.clickLoginSignupButton();
        loginPage.enterMobileNumber();
        loginPage.clickEnterPassword();
        loginPage.enterPasswordText();
        loginPage.clickLoginButton();
    }

    @Then("user has successfully logged in")
    public void userHasSuccessfullyLoggedIn() {
        String welcomeText = "Welcome Kalidas";
        landingPage.hoverOverProfileTab();
        Assert.assertTrue("Verify Welcome message", welcomeText.equalsIgnoreCase(landingPage.getWelcomeText()));
    }
}
