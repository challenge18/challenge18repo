package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import selenium.SeleniumInitializer;

/**
 * Created by Gerardo
 */
public class LoginTest extends SeleniumInitializer {

    @Parameters({"emailToLogin", "passwordToLogin"})
    @Test(groups = "Challenge_Login")

    public void loginSuccessfullyTest(String emailToLogin, String passwordToLogin) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.waitForElementVisible(5), "can not access to newegg.com");
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(), "Home page Title not displayed");
        loginPage.clickOnLoginLink();
        Assert.assertTrue(loginPage.waitForReturningUserVisible(5), "can not access to returning user page");
        Assert.assertTrue(loginPage.isReturningUserDisplayed(), "Returning user Title not displayed");
        Thread.sleep(5000);
        loginPage.insertEmail(emailToLogin);
        Thread.sleep(5000);
        loginPage.insertPassword(passwordToLogin);
        Thread.sleep(150000);
        Assert.assertTrue(loginPage.isSignInButtonEnabled(),"Login button is not enabled");
        loginPage.clickOnSignInButton();
    }

}

