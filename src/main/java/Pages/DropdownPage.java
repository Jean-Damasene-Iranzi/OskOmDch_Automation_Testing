package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.font.ShapeGraphicAttribute;
import java.text.ListFormat;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    WebDriver driver;
    private By categoryDropdown = By.id("product_cat");
    private By sortDropdown = By.xpath("//*[@id=\"main\"]/div/form/select");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromCategoryDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public Select findDropdownElement(){
        return new Select(driver.findElement(categoryDropdown));
    }

    public void selectFromSortDropdown(String option){
        findSortDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedSortOptions(){
        List<WebElement> selectedSortElements = findSortDropdownElement().getAllSelectedOptions();
        return selectedSortElements.stream().map(e ->e.getText()).collect(Collectors.toList());
    }

    public Select findSortDropdownElement(){
        return new Select(driver.findElement(sortDropdown));
    }
}
