package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    WebDriver driver;
    private By orderAlertText = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public String getOrderAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement  placeOrder = wait.until(ExpectedConditions.elementToBeClickable(orderAlertText));
        return placeOrder.getText();
    }


}
