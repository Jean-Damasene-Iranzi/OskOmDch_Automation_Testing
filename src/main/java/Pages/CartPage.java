package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By product = By.linkText("Anchor Bracelet");
    private By quantityField = By.name("cart[c54e7837e0cd0ced286cb5995327d1ab][qty]");
    private By updateButton = By.name("update_cart");
    private By cartUpdateAlert = By.cssSelector("div.woocommerce-message");
    private By removeProductButton = By.linkText("×");
    private By removedProductAlert = By.xpath("//*[@id=\"post-1220\"]/div/div/div/div/div[1]/div");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAddedCartText(){
        return driver.findElement(product).getText();
    }

    public void clickProductRemoveButton(){
        List<WebElement> removeButton = driver.findElements(removeProductButton);
        removeButton.getFirst().click();
    }

    public String getProductRemovalText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(removedProductAlert));
        return driver.findElement(removedProductAlert).getText();
    }

    public void setNewQuantity(int  quantity) {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(String.valueOf(quantity));
    }

    public void clickCartUpdateButton(){
        driver.findElement(updateButton).click();
    }

    public String getCartUpdateAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartUpdateAlert));
        return driver.findElement(cartUpdateAlert).getText();
    }
}
