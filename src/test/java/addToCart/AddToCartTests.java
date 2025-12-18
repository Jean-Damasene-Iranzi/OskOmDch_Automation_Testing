package addToCart;

import Pages.CartPage;
import Pages.StorePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCartTests extends BaseTests {
    @Test
    public void testAddToCart(){
        StorePage storePage = homePage.clickStorePageLink();
        CartPage cartPage = storePage.clickAddToCartButton();
        assertEquals(cartPage.getAddedCartText(),"Anchor Bracelet","Incorrect product added");

    }
}
