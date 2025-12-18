package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortDropdownTests extends BaseTests {
    @Test
    public void testSortDropdown(){
        var dropdownPage = homePage.clickDropdown();
        String option = "Sort by latest";
        dropdownPage.selectFromSortDropdown(option);
        var selectedSortOption = dropdownPage.getSelectedSortOptions();
        assertEquals(selectedSortOption.size(),1,"Incorrect option selected");
        assertTrue(selectedSortOption.contains(option),"Incorrect value selected");
    }
}
