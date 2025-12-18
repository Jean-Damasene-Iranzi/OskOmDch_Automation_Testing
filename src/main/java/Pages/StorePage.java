package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StorePage {
    WebDriver driver;
    private By searchInputField = By.id("woocommerce-product-search-field-0");
    private By searchResults = By.xpath("//*[@id=\"main\"]/div/header/h1");
    private By leftSlider = By.xpath("//*[@id=\"woocommerce_price_filter-3\"]/form/div/div[1]/span[1]");
    private By rightSlider = By.xpath("//*[@id=\"woocommerce_price_filter-3\"]/form/div/div[1]/span[2]");
    private By filterButton = By.xpath("//*[@id=\"woocommerce_price_filter-3\"]/form/div/div[2]/button");
    private By viewCartLink = By.linkText("View cart");

    public StorePage(WebDriver driver){
        this.driver = driver;
    }

    public void enterSearchText(String searchText){
        driver.findElement(searchInputField).sendKeys(searchText);
    }

    public String getSearchResult(){
        return driver.findElement(searchResults).getText();
    }

    public void moveSliderButtons(){

        WebElement sliderBar = driver.findElement(By.className("price_slider"));
        int sliderWidth = sliderBar.getSize().width;

        int minValue = 10;
        int maxValue = 150;
        double pixelsPerUnit = (double)sliderWidth / (maxValue - minValue);

        int targetLeftValue = 50;
        int targetRightValue = 120;

        int leftOffset = (int)((targetLeftValue - minValue) * pixelsPerUnit);
        int rightOffset = (int)((maxValue - targetRightValue) * pixelsPerUnit);

        Actions actions = new Actions(driver);
        WebElement left = driver.findElement(leftSlider);
        WebElement right = driver.findElement(rightSlider);

        actions.dragAndDropBy(left, leftOffset, 0).perform();
        actions.dragAndDropBy(right, -rightOffset, 0).perform();
    }

    public void clickFilterButton(){
        driver.findElement(filterButton).click();
    }

    public String getSliderResultText(){
       return driver.findElement(By.xpath("//*[@id=\"main\"]/div/p")).getText();
    }

    public CartPage clickAddToCartButton(){
        List<WebElement>  addToCart = driver.findElements(By.linkText("ADD TO CART"));
        addToCart.getFirst().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

}
