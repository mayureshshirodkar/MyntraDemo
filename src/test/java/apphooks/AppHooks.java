package apphooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.util.Properties;

public class AppHooks {

    private WebDriver driver;
    private Properties prop;
    private DriverFactory driverFactory;
    private ConfigReader configReader;

    @Before(order = 0)
    public void initialiseBrowser(){
        configReader = new ConfigReader();
        driverFactory = new DriverFactory();

        prop = configReader.getConfig();
        driver = driverFactory.initDriver(prop.getProperty("browser"));
    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "-");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
