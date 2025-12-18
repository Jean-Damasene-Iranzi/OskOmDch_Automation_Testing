package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By logOutButton = By.linkText("Log out");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAccountAlertText(){
       return driver.findElement(logOutButton).getText();
    }

    public AccountPages clickLogoutButton(){
         driver.findElement(logOutButton).click();
         return new AccountPages(driver);
    }
}
