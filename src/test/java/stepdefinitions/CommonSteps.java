package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import util.Utils;

import java.util.Properties;

public class CommonSteps {
    private WebDriver driver;
    private Properties prop;
    private DriverFactory driverFactory;
    private ConfigReader configReader;

    @Given("browser loads the web app")
    public void browserLoadsTheWebApp() {
        configReader = new ConfigReader();
        driverFactory = new DriverFactory();

        prop = configReader.getConfig();
        Utils.deleteFolder("report");
        driver = driverFactory.initDriver(prop.getProperty("browser"));
    }

    @Given("application teardown")
    public void applicationTeardown() {
        DriverFactory.getDriver().quit();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            String screenshotName = scenario.getName().toLowerCase().replaceAll(" ", "-");
            byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

}
