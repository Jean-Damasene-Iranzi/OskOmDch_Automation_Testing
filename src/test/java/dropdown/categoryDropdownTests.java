package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class categoryDropdownTests extends BaseTests {
    @Test
    public void TestSelectedOption(){
        var dropdownPage = homePage.clickDropdown();
        String option = "Men’s Jeans  (4)";
        dropdownPage.selectFromCategoryDropdown(option);
        var selectedOption = dropdownPage.getSelectedOptions();
        assertEquals(selectedOption.size(),1,"Incorrect option selected");
        assertTrue(selectedOption.contains(option),"Incorrect value selected");
    }
}
