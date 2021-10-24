package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ElementUtil;

import java.util.List;

public class ProductSearchPage {
    WebDriver driver;
    ElementUtil elementUtil = new ElementUtil(driver);

    By productTitleOptions = By.xpath("//ul/li[contains(@class, 'product-base')]//picture/source");

    public ProductSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectProductByTitle(String title){
        List<WebElement> productList = elementUtil.waitForVisibilityElements(productTitleOptions);
        for (WebElement product:productList) {
            if (product.getAttribute("title").equalsIgnoreCase(title))
                product.click();
        }
        elementUtil.switchToWindowHandle(title);
    }

}
