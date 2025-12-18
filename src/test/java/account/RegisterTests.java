package account;

import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTests {
    @Test
    public void testSuccessfulRegister(){
       var registrationPage = homePage.clickAccountNavigation();
       registrationPage.enterRegisterUsername("Sinzi");
       registrationPage.enterRegisterEmail("sinze@gmail.com");
       registrationPage.enterRegisterPassword("Sinzi123@");
       var accountPage = registrationPage.clickRegisterButton();
       assertEquals(accountPage.getAccountAlertText(),"Log out","Incorrect Assertion");
    }
}
