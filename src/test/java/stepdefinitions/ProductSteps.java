package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LandingPage;
import pages.ProductPage;

public class ProductSteps {

    LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
    ProductPage productPage = new ProductPage(DriverFactory.getDriver());

    @When("user selects {string} from product search")
    public void userSelectsFromProductSearch(String arg0) {
        landingPage.selectSuggestionFromDropDown(arg0);
    }

    @When("user picks {string} from available products")
    public void userPicksFromAvailableProducts(String arg0) {
        productPage.selectProductByTitle(arg0);
    }


    @Then("user is shown product details for {string}")
    public void userIsShownProductDetailsFor(String productName) {
        String productBrand = "Roadster";

        Assert.assertTrue("Verify product brand", productBrand.equalsIgnoreCase(productPage.getProductBrandText()));
        Assert.assertTrue("Verify product name", productName.equalsIgnoreCase(productPage.getProductNameText()));

    }

    @When("user enters pin code {string}")
    public void userEntersPinCode(String arg0) {
        productPage.checkPinCodeAvailable(arg0);
    }

    @Then("verify user entered pin code is serviceable")
    public void verifyUserEnteredPinCodeIsServiceable() {
        String deliveryDate = "Get it by Thu, Oct 28";
        String deliveryPayment = "Pay on delivery available";
        String deliveryReturn = "Easy 30 days return & exchange available";

        Assert.assertTrue("Verify pincode delivery date text", deliveryDate.contains(productPage.getPinCodeDeliveryDateText()));
        Assert.assertTrue("Verify pincode payment text", deliveryPayment.equalsIgnoreCase(productPage.getPinCodeDeliveryPaymentText()));
        Assert.assertTrue("Verify pincode return text", deliveryReturn.equalsIgnoreCase(productPage.getPinCodeDeliveryReturnText()));
    }
}
