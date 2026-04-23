package order;

import Pages.CheckoutPage;
import Pages.OrderPage;
import Pages.ProductDetailsPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrderTests extends BaseTests {
    @Test
    public void testSuccessfulOrder(){
        ProductDetailsPage singleProductPage = homePage.clickSingleProduct();
        singleProductPage.clickAddToCartButton();
        CheckoutPage checkoutPage = singleProductPage.hoversOverCart();
        checkoutPage.enterBillingFirstName("NIYIGIRIMBABAZI");
        checkoutPage.enterBillingSecondName("Obed");
        checkoutPage.enterCountry("Rwanda");
        checkoutPage.enterStreetAddress("Kigali");
        checkoutPage.enterCity("Kampala");
        checkoutPage.enterState("Kigali");
        checkoutPage.enterPostalCode("11ZZ");
        checkoutPage.enterBillingEmail("iranzijeand20@gmail.com");
        checkoutPage.paymentMethod("Cash on delivery");
        OrderPage orderPage = checkoutPage.clickPlaceOrderButton();
        assertEquals(orderPage.getOrderAlertText(),"Thank you. Your order has been received.","Incorrect assertion");
    }
}
