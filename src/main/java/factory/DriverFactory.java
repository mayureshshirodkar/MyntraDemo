package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tdriver.set(new ChromeDriver());
        }

        else if(browser.equalsIgnoreCase("safari")){
            tdriver.set(new SafariDriver());
        }

        else{
            System.out.println("Incorrect browser passed");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tdriver.get();
    }

}
