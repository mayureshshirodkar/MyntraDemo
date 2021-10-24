package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementUtil;

public class CartPage {
    WebDriver driver;
    ElementUtil elementUtil = new ElementUtil(DriverFactory.getDriver());

    By productBrandDetails = By.xpath("//div[contains(@class,'base-brand')]");
    By productNameDetails = By.xpath("//a[contains(@class,'base-itemLink')]");
    By productSizeDetails = By.xpath("//div[contains(@class,'base-size')]/span");
    By productQuantityDetails = By.xpath("//div[contains(@class,'base-quantity')]/span");
    By productPriceDetails = By.xpath("//div[contains(@class,'base-price')]/div");
    By productDeliveryDetails = By.xpath("//div[contains(@class,'base-messageText')]");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductBrandText(){return elementUtil.waitForVisibilityElement(productBrandDetails).getText(); }

    public String getProductNameText(){ return elementUtil.waitForVisibilityElement(productNameDetails).getText(); }

    public String getProductSizeText(){return elementUtil.waitForVisibilityElement(productSizeDetails).getText();}

    public String getProductQuantityText(){return elementUtil.waitForVisibilityElement(productQuantityDetails).getText();}

    public String getProductPriceText(){return elementUtil.waitForVisibilityElement(productPriceDetails).getText();}

    public String getProductDeliveryText(){return elementUtil.waitForVisibilityElement(productDeliveryDetails).getText();}
}
