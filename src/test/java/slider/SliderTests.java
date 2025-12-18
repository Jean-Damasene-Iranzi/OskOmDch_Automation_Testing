package slider;

import Pages.StorePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SliderTests extends BaseTests {
    @Test
    public void testFilterByPriceSlider(){
        StorePage storePage = homePage.clickStorePageLink();
        storePage.moveSliderButtons();
        storePage.clickFilterButton();
        assertTrue(storePage.getSliderResultText().contains("Showing all 4 results"),"Incorrect assertion");
    }
}
