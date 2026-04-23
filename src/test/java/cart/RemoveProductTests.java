package cart;

import Pages.CartPage;
import Pages.StorePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoveProductTests extends BaseTests {
    @Test
    public void testRemoveProduct(){
        var storePage = homePage.clickStorePageLink();
        var cartPage = storePage.clickAddToCartButton();
        cartPage.clickProductRemoveButton();
        assertTrue(cartPage.getProductRemovalText().contains("Anchor Bracelet” removed."),"Incorrect assertion");
    }

}
