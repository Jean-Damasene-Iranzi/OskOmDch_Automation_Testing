package cart;

import Pages.CartPage;
import Pages.StorePage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UpdateCartQuantityTests extends BaseTests {
    @Test
    public void testUpdateCartQuantity(){
        StorePage storePage = homePage.clickStorePageLink();
        CartPage cartPage = storePage.clickAddToCartButton();
        cartPage.setNewQuantity(5);
        cartPage.clickCartUpdateButton();
        assertTrue(cartPage.getCartUpdateAlertText().contains("Cart updated."),"Incorrect assertion");
    }
}
