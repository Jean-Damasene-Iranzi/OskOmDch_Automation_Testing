package keys;

import Pages.StorePage;
import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testSearchKeyPress(){
        var storePage = homePage.clickStorePageLink();
        storePage.enterSearchText("Jeans" + Keys.ENTER);
        assertEquals(storePage.getSearchResult(),"Search results: “Jeans”","Incorrect search result");
    }
}
