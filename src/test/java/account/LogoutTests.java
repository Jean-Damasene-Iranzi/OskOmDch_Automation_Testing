package account;

import Pages.AccountPages;
import Pages.LoginPage;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LogoutTests extends BaseTests {
    @Test
    public void testLogoutToAccount(){
        AccountPages accountPages = homePage.clickAccountNavigation();
        accountPages.setUsernameField("iranzijeand20@gmail.com");
        accountPages.setPasswordField("Iranzi");
        LoginPage loginPage = accountPages.clickLoginButton();
        AccountPages accountPages1 = loginPage.clickLogoutButton();

        assertTrue(accountPages1.getAccountPageAlertText().contains("Login"),"Incorrect Assertion");
    }
}
