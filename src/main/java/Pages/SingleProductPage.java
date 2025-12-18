package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SingleProductPage {
    private WebDriver driver;
    private By addToCartButton = By.name("add-to-cart");
    private By checkoutIcon = By.className("count");
    private By checkoutButton = By.xpath("//*[@id=\"ast-site-header-cart\"]/div[2]/div/div/p[2]/a[2]");


    public SingleProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }

    public CheckoutPage hoversOverCart(){
        WebElement cartIcon = driver.findElement(checkoutIcon);
        Actions actions = new Actions(driver);
        actions.moveToElement(cartIcon).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkout.click();

        return new CheckoutPage(driver);
    }


}
