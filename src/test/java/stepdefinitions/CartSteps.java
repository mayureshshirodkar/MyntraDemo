package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.CartPage;
import pages.LandingPage;
import pages.ProductPage;

public class CartSteps {
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());
    private CartPage cartPage =new CartPage(DriverFactory.getDriver());
    private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());


    @When("user adds product {string} to cart")
    public void userAddsProductToCart(String arg0) {
        productPage.selectProductSize("40");
        productPage.clickAddToBag();
        landingPage.clickOnBagButton();

    }

    @Then("verify product details added to cart")
    public void verifyProductDetailsAddedToCart() {
        String productBrand = "Roadster";
        String productName = "Men Teal Blue Regular Fit Printed Casual Shirt";
        String productSize = "Size: 40";
        String productQuantity = "Qty: 1";
        String productPrice = "749";
        String productDelivery = "Delivery by 28 Oct 2021";

        Assert.assertTrue("Verify product brand", productBrand.equalsIgnoreCase(cartPage.getProductBrandText()));
        Assert.assertTrue("Verify product name", productName.equalsIgnoreCase(cartPage.getProductNameText()));
        Assert.assertTrue("Verify product size", productSize.equalsIgnoreCase(cartPage.getProductSizeText()));
        Assert.assertTrue("Verify product quantity", productQuantity.equalsIgnoreCase(cartPage.getProductQuantityText()));
        Assert.assertTrue("Verify product price", productPrice.equalsIgnoreCase(cartPage.getProductPriceText()));
        Assert.assertTrue("Verify product delivery text", productDelivery.equalsIgnoreCase(cartPage.getProductDeliveryText()));


    }
}
