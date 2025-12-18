package hovers;

import Pages.CheckoutPage;
import Pages.ProductDetailsPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckoutTests extends BaseTests {

    @Test
    public void testCheckoutAccess(){
        ProductDetailsPage singleProductPage = homePage.clickSingleProduct();
        singleProductPage.clickAddToCartButton();
        CheckoutPage checkoutPage = singleProductPage.hoversOverCart();
        assertTrue(checkoutPage.getCheckoutAlertText().contains("Your order"),"Incorrect assertion");
    }
}