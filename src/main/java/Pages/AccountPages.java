package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPages {
    private WebDriver driver;
    private By loginUsernameField = By.id("username");
    private By loginPasswordField = By.id("password");
    private By loginButton = By.name("login");
    private By registerUsernameField = By.id("reg_username");
    private By registerEmailField = By.id("reg_email");
    private By registerPasswordField = By.id("reg_password");
    private By registerButton = By.name("register");
    private By accoutPageAlert = By.xpath("//*[@id=\"customer_login\"]/div[1]/h2");

    public AccountPages(WebDriver driver){
        this.driver = driver;
    }

    public void setUsernameField(String username){
       driver.findElement(loginUsernameField).sendKeys(username);
    }

    public void setPasswordField(String password){
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public void enterRegisterUsername(String username){
        driver.findElement(registerUsernameField).sendKeys(username);
    }

    public void enterRegisterEmail(String email){
        driver.findElement(registerEmailField).sendKeys(email);
    }

    public void enterRegisterPassword(String password){
        driver.findElement(registerPasswordField).sendKeys(password);
    }
    public LoginPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new LoginPage(driver);
    }

    public String getAccountPageAlertText(){
        return driver.findElement(accoutPageAlert).getText();
    }
}
