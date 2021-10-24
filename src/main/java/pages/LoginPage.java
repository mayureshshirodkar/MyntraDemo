package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By mobileTextBox = By.xpath("//div[@class='mobileInputContainer']//input");
    By submitButton = By.className("submitBottomOption");
    By enterPassword = By.xpath("//div/span[contains(text()='Password')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
}
