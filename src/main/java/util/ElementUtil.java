package util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class ElementUtil {

   private WebDriver driver;
   private WebDriverWait webDriverWait;
   private Actions actions;

    public ElementUtil(WebDriver driver){
        this.driver = driver;
    }


    public WebElement waitForVisibilityElement(By locator){
        WebElement webElement = null;
        try{
         webDriverWait = new WebDriverWait(driver, 5);
         webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return webElement;
    }

    public WebElement waitForClickableElement(By locator){
        webDriverWait = new WebDriverWait(driver, 5);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> waitForVisibilityElements(By locator){
        webDriverWait = new WebDriverWait(driver, 5);
        return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> waitForPresenceElements(By locator, int time){
        webDriverWait = new WebDriverWait(driver, time);
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }


    public void clickElement(By locator){
        waitForClickableElement(locator).click();
    }

    public void clickElementByJavaScript(By locator){
         JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
         WebElement element = driver.findElement(locator);
         javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    public void sendKeysToElement(By locator, String text){
        waitForVisibilityElement(locator).sendKeys(text);
    }

    public void hoverOverElement(By locator){
        actions = new Actions(driver);
        actions.moveToElement(waitForVisibilityElement(locator)).perform();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void switchToWindowHandle(String windowTitle){
        Set<String> windows = driver.getWindowHandles();
        for (String window:windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equalsIgnoreCase(windowTitle))
                break;
        }
    }

}
