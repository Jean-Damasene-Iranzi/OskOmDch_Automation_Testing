package account;

import Pages.AccountPages;
import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests{
    @Test
    public void testSuccessFulLogin(){
        AccountPages accountPages = homePage.clickAccountNavigation();
        accountPages.setUsernameField("iranzijeand20@gmail.com");
        accountPages.setPasswordField("Iranzi");
       LoginPage loginPage = accountPages.clickLoginButton();
       assertEquals(loginPage.getAccountAlertText(),"Log out","Incorrect Assertion");
    }
}
