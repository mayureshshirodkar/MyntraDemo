package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

import java.util.List;

public class LandingPage {
    private WebDriver driver;
    ElementUtil elementUtil = new ElementUtil(DriverFactory.getDriver());

    By profile = By.className("desktop-user");
    By bag = By.xpath("//a[@href='/checkout/cart']");
    By wishlist = By.xpath("//a[@href='/wishlist']");
    By login = By.xpath("//a[text() = 'login / Signup']");
    By searchQuery = By.xpath("//div[@class='desktop-query']/input");
    By suggestionDropdownOptions = By.xpath("//ul/li[contains(@class, 'desktop-suggestion')]");

    public LandingPage(WebDriver driver){ this.driver = driver; }

    public void hoverOverProfileTab(){
        elementUtil.hoverOverElement(profile);
    }

    public void clickLoginSignupButton(){
        elementUtil.clickElement(login);
    }

    public void clickOnBagButton(){elementUtil.clickElementByJavaScript(bag); }

    public void clickOnWishListButton(){elementUtil.clickElementByJavaScript(wishlist); }

    public String getTitle(){
        return elementUtil.getPageTitle();
    }

    public void enterSearchQuery(String searchText){
        elementUtil.sendKeysToElement(searchQuery, searchText);
    }

    public ProductPage selectSuggestionFromDropDown(String searchText){
        List<WebElement> suggestions = elementUtil.waitForVisibilityElements(suggestionDropdownOptions);
        for (WebElement suggestion:suggestions) {
            if (suggestion.getText().equalsIgnoreCase(searchText)) {
                suggestion.click();
                break;
            }
        }
        return new ProductPage(driver);
    }

}
