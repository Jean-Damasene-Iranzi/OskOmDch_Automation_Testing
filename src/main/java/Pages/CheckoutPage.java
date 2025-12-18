package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {
    WebDriver driver;
    private By yourOrder = By.id("order_review_heading");
    private By billingFirstName = By.id("billing_first_name");
    private By billingSecondName = By.id("billing_last_name");
    private By billingCountry = By.id("billing_country");
    private By billingStreetAddress = By.id("billing_address_1");
    private By billingCity = By.id("billing_city");
    private By billingState = By.id("billing_state");
    private By billingPostalCode = By.id("billing_postcode");
    private By billingEmail = By.id("billing_email");
    private By placeOrderButton = By.xpath("//*[@id=\"place_order\"]");
    private By paymentField = By.id("payment_method_cod");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public String getCheckoutAlertText(){
        return driver.findElement(yourOrder).getText();
    }

    public void enterBillingFirstName(String firstName){
        driver.findElement(billingFirstName).sendKeys(firstName);
    }

    public void enterBillingSecondName(String secondName){
        driver.findElement(billingSecondName).sendKeys(secondName);
    }

    public void enterCountry(String country){
        new Select(driver.findElement(billingCountry)).selectByVisibleText(country);
    }

    public void enterStreetAddress(String address){
        driver.findElement(billingStreetAddress).sendKeys(address);
    }

    public void enterCity(String city){
        driver.findElement(billingCity).sendKeys(city);
    }

    public void enterState(String state){
        driver.findElement(billingState).sendKeys(state);
    }

    public void enterPostalCode(String postCode){
        driver.findElement(billingPostalCode).sendKeys(postCode);
    }

    public void enterBillingEmail(String email){
        driver.findElement(billingEmail).sendKeys(email);
    }

    public void paymentMethod(String paymentMethod) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> methods = driver.findElements(paymentField);

        for (WebElement method : methods) {
            if (method.getText().contains(paymentMethod)) {
                String txt = method.getAttribute("for");
                if (txt != null) {
                    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id(txt)));
                    input.click();
                    break;
                }
            }
        }
    }



    public OrderPage clickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
            button.click();
        } catch (StaleElementReferenceException e) {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
            button.click();
        }
        return new OrderPage(driver);
    }

}
