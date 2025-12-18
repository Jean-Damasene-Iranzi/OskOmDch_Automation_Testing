package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
 private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public AccountPages clickAccountNavigation(){
        clickLink("Account");
        return new AccountPages(driver);
    }

    public DropdownPage clickDropdown(){
        clickLink("Store");
        return new DropdownPage(driver);
    }

    public ProductDetailsPage clickSingleProduct(){
        clickLink("Blue Shoes");
        return new ProductDetailsPage(driver);
    }

    public StorePage clickStorePageLink(){
        clickLink("Store");
        return new StorePage(driver);
    }

    private void clickLink(String linkText){

        driver.findElement(By.linkText(linkText)).click();
    }
}
