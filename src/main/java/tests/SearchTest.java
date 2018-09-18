package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import selenium.SeleniumInitializer;

import java.util.ArrayList;

/**
 * Created by Gerardo
 */
public class SearchTest extends SeleniumInitializer {

   @Parameters({"itemToSearch", "itemsQuantity", "emailToLogin", "passwordToLogin"})
   @Test(groups = "Challenge_Search")

   public void searchSuccessfullyTest(String itemToSearch, String itemsQuantity, String emailToLogin, String passwordToLogin) throws InterruptedException {

        SearchPage searchPage = new SearchPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //search
        Assert.assertTrue(searchPage.isMyAccountLinkDisplayed(), "My Account link is not displayed");
        Thread.sleep(5000);

        String items[] = itemToSearch.split(",");
        ArrayList<String> ListItemsToSearch = new ArrayList<String>();

        for(int i=0; i<items.length; i++){

            ListItemsToSearch.add(items[i]);
        }

        for(int i =0; i<ListItemsToSearch.size(); i++){

            searchPage.SearchItem(ListItemsToSearch.get(i));
            Thread.sleep(1500);
            searchPage.clickOnSearchButton();
            Thread.sleep(1500);
            searchPage.clickOnAddToCartButton();
            Thread.sleep(1500);
        }

        searchPage.scrollDown();
        Thread.sleep(1500);
        searchPage.clickOnRemoveItemCheck();
        Thread.sleep(1500);
        searchPage.scrollUp();
        Thread.sleep(1500);
        searchPage.clickOnRemoveItemButton();
        Thread.sleep(1500);
        searchPage.scrollDown();
        Thread.sleep(1500);
        searchPage.scrollUp();
        Thread.sleep(1500);
        searchPage.updateQuantityItems(itemsQuantity);
        Thread.sleep(1500);
        searchPage.clickOnUpdateQuantityButton();
        Thread.sleep(1500);
        searchPage.scrollDownBottom();
        Thread.sleep(1500);
        searchPage.clickOnSecureCheckoutButton();
        Thread.sleep(2500);

        //login
        Assert.assertTrue(loginPage.isReturningUserDisplayed(), "Returning user Title not displayed");
        Thread.sleep(1500);
        loginPage.insertEmail(emailToLogin);
        Thread.sleep(1500);
        loginPage.insertPassword(passwordToLogin);
        Thread.sleep(110000);
        Assert.assertTrue(loginPage.isSignInButtonEnabled(),"Login button is not enabled");
        loginPage.clickOnSignInButton();
        Thread.sleep(1500);

        //checkout
        Assert.assertTrue(searchPage.isShippingAddressDisplayed(), "Shipping Address Title not displayed");
        Thread.sleep(1500);
        searchPage.clickOnBillingButton();
        Thread.sleep(1500);
        searchPage.clickOnLogo();
        Thread.sleep(1500);
        searchPage.clickOnMyAccountLink();
        Thread.sleep(1500);
        searchPage.clickOnLogoutButton();
        Thread.sleep(1500);

        //logout
        Assert.assertTrue(searchPage.isThankyouPageDisplayed(), "Thank You Title not displayed");
        Thread.sleep(1500);

        //password reset
        Assert.assertTrue(loginPage.waitForElementVisible(5), "can not access to newegg.com");
        Thread.sleep(1500);
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(), "Home page Title not displayed");
        Thread.sleep(1500);
        loginPage.clickOnLoginLink();
        Thread.sleep(1500);
        Assert.assertTrue(loginPage.waitForReturningUserVisible(5), "can not access to returning user page");
        Thread.sleep(1500);
        Assert.assertTrue(loginPage.isReturningUserDisplayed(), "Returning user Title not displayed");
        Thread.sleep(1500);
        searchPage.scrollDown();
        Thread.sleep(1500);
        searchPage.clickOnForgotPasswordLink();
        Thread.sleep(1500);
        Assert.assertTrue(searchPage.isAssistancePageDisplayed(), "Assistance Title not displayed");
        Thread.sleep(1500);
        searchPage.emailForgot(emailToLogin);
        Thread.sleep(110000);
        Assert.assertTrue(searchPage.isSubmitButtonEnabled(),"Submit button is not enabled");
        Thread.sleep(1500);
        searchPage.clickOnSubmitButton();
        Thread.sleep(1500);
    }

}
