package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    ElementUtil elementUtil = new ElementUtil(DriverFactory.getDriver());

    By productTitleOptions = By.xpath("//ul/li[contains(@class, 'product-base')]/a");
    By productBrand = By.xpath("//div[contains(@class,'description')]//h1[contains(@class,'title')]");
    By productName = By.xpath("//div[contains(@class,'description')]//h1[contains(@class,'name')]");
    By sizeButtons = By.xpath("//div[@class='size-buttons-tipAndBtnContainer']//p");
    By addToBagButton = By.xpath("//div[text()='ADD TO BAG']");
    By pinCodeBox = By.xpath("//div[contains(@class, 'Address-address-box')]/input");
    By pinCodeChangeButton = By.xpath("//span[contains(@class, 'Address-address-button')]");
    By pinCodeCheckButton = By.xpath("//div[contains(@class, 'Address-address-box')]/button");
    By pinCodeDeliveryDate = By.xpath("(//ul/li//h4)[1]");
    By pinCodeDeliveryPayment = By.xpath("(//ul/li//h4)[2]");
    By pinCodeDeliveryReturn = By.xpath("(//ul/li//h4)[3]");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectProductByTitle(String title){
        String hrefTitle = title.toLowerCase().replaceAll(" ", "-");
        List<WebElement> productList = elementUtil.waitForPresenceElements(productTitleOptions, 3);
        for (WebElement product:productList) {
            if (product.getAttribute("href").contains(hrefTitle))
                product.click();
                break;
        }
        elementUtil.switchToWindowHandle(title);
    }

    public void selectProductSize(String sizeValue){
        List<WebElement> sizes = elementUtil.waitForVisibilityElements(sizeButtons);
        for (WebElement size: sizes) {
            if (size.getText().equalsIgnoreCase(sizeValue))
                size.click();
        }
    }

    public void clickAddToBag(){
        elementUtil.clickElement(addToBagButton);
    }

    public void checkPinCodeAvailable(String pincode){
        if(elementUtil.waitForVisibilityElement(pinCodeChangeButton) != null)
            elementUtil.waitForVisibilityElement(pinCodeChangeButton).click();

        elementUtil.sendKeysToElement(pinCodeBox, pincode);
        elementUtil.clickElement(pinCodeCheckButton);
    }

    public String getProductBrandText(){return elementUtil.waitForVisibilityElement(productBrand).getText(); }

    public String getProductNameText(){ return elementUtil.waitForVisibilityElement(productName).getText(); }

    public String getPinCodeDeliveryDateText(){return elementUtil.waitForVisibilityElement(pinCodeDeliveryDate).getText();}

    public String getPinCodeDeliveryPaymentText(){return elementUtil.waitForVisibilityElement(pinCodeDeliveryPayment).getText();}

    public String getPinCodeDeliveryReturnText(){return elementUtil.waitForVisibilityElement(pinCodeDeliveryReturn).getText();}


}
