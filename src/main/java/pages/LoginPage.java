package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementUtil;

public class LoginPage {
    WebDriver driver;
    private final String mobileNumber = "9175388781";
    private final String password = "Test@123";
    ElementUtil elementUtil = new ElementUtil(DriverFactory.getDriver());

    By mobileTextBox = By.xpath("//div[@class='mobileInputContainer']//input");
    By submitButton = By.className("submitBottomOption");
    By enterPasswordLink = By.xpath("//div/span[contains(text(),'Password')]");
    By enterPasswordBox = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("//button[contains(@class,'submitButton')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterMobileNumber(){
        elementUtil.sendKeysToElement(mobileTextBox, mobileNumber);
        elementUtil.clickElement(submitButton);
    }

    public void clickEnterPassword(){
        elementUtil.clickElement(enterPasswordLink);
    }

    public void enterPasswordText(){
        elementUtil.sendKeysToElement(enterPasswordBox, password);
    }

    public void clickLoginButton(){
        elementUtil.clickElement(loginButton);
    }
}
