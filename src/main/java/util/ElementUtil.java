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

    /**
     * Will Wait for specified time for element to be visible on page
     * @param locator element locator
     * @return Web Element based on locator
     */
    public WebElement waitForVisibilityElement(By locator){
        WebElement webElement = null;
        try{
         webDriverWait = new WebDriverWait(driver, 5);
         webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch(Exception e){ e.printStackTrace(); }
        return webElement;
    }

    /**
     * Will Wait for specified time for elements to be visible on page
     * @param locator element locator
     * @return Web Elements based on locator
     */
    public List<WebElement> waitForVisibilityElements(By locator){
        List<WebElement> webElements = null;
        try {
            webDriverWait = new WebDriverWait(driver, 5);
            webElements = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return webElements;
    }

    /**
     * Will Wait for specified time for element to be clickable on page
     * @param locator element locator
     * @return Web Element based on locator
     */
    public WebElement waitForClickableElement(By locator){
        WebElement webElement = null;
        try{
        webDriverWait = new WebDriverWait(driver, 5);
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch(Exception e){ e.printStackTrace(); }
        return webElement;
    }


    /**
     * Will Wait for specified time for element to be present on page
     * @param locator element locator
     * @param time wait time in seconds
     * @return Web Element based on locator
     */
    public List<WebElement> waitForPresenceElements(By locator, int time){
        List<WebElement> webElement = null;
        try {
            webDriverWait = new WebDriverWait(driver, time);
            webElement = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }
        catch(Exception e){ e.printStackTrace(); }
        return webElement;
    }


    /**
     * Will Wait for specified time for element to be clickable and click on element
     * @param locator element locator
     */
    public void clickElement(By locator){
        waitForClickableElement(locator).click();
    }

    /**
     * Will find web element and click on element using javascript executor
     * @param locator element locator
     */
    public void clickElementByJavaScript(By locator){
         JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
         WebElement element = driver.findElement(locator);
         javascriptExecutor.executeScript("arguments[0].click()", element);
    }

    /**
     * Will Wait for specified time for element to be clickable and enter text to element
     * @param locator element locator
     * @param text text to be entered in text box
     */
    public void sendKeysToElement(By locator, String text){
        waitForVisibilityElement(locator).sendKeys(text);
    }

    /**
     * Will Wait for specified time for element to be visible and hover over element
     * @param locator element locator
     */
    public void hoverOverElement(By locator){
        actions = new Actions(driver);
        actions.moveToElement(waitForVisibilityElement(locator)).perform();
    }

    /**
     * Get Web page title
     * @return String text
     */
    public String getPageTitle(){
        return driver.getTitle();
    }

    /**
     * Will iterate through list of windows until it matched window title
     * @param windowTitle Title for the window
     */
    public void switchToWindowHandle(String windowTitle){
        Set<String> windows = driver.getWindowHandles();
        for (String window:windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equalsIgnoreCase(windowTitle))
                break;
        }
    }

}
