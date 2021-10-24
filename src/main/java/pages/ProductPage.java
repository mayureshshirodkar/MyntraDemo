package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    ElementUtil elementUtil = new ElementUtil(driver);

    By sizeButtons = By.xpath("//div[@class='size-buttons-tipAndBtnContainer']//p");
    By addToBagButton = By.xpath("//div[text()='ADD TO BAG']");
    By pinCodeBox = By.xpath("//div[contains(@class, 'Address-address-box')]/input");
    By pinCodeCheckButton = By.xpath("//div[contains(@class, 'Address-address-box')]/button");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectProductSize(String sizeValue){
        List<WebElement> sizes = elementUtil.waitForVisibilityElements(sizeButtons);
        for (WebElement size: sizes) {
            if (size.getText().equalsIgnoreCase(sizeValue))
                size.click();
        }
    }

    public void checkPinCodeAvailable(String pincode){
        elementUtil.sendKeysToElement(pinCodeBox, pincode);
        elementUtil.clickElement(pinCodeCheckButton);
    }

    public void clickAddToBag(){
        elementUtil.clickElement(addToBagButton);
    }

}
