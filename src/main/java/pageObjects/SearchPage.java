package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Created by Gerardo
 */
public class SearchPage extends PageObjects {

    private final By MYACCOUNT_LINK = By.linkText("Log in or Register");
    private final By SEARCH_FIELD = By.id("haQuickSearchBox");
    private final By SEARCH_BUTTON = By.xpath("//button[contains(text(),'Search')]");
    private final By ADD_TO_CART = By.xpath("//div[contains(@class,'call-to-action call-to-action-main-product')]//button[@type='button']");
    private final By REMOVE_ITEM_CHECK = By.id("96-113-285.1.0.0");
    private final By REMOVE_ITEM_BUTTON = By.linkText("Remove Selected");
    private final By QUANTITY_FIELD = By.id("ITEM.20-173-374.1.0.0");
    private final By QUANTITY_BUTTON = By.linkText("Update Qtys");
    private final By SECURE_CHECKOUT_BUTTON = By.xpath("//a[@title='Secure Checkout']");
    private final By SHIPPING_TITLE = By.xpath("//li[@class='current']//span[contains(text(),'Shipping')]");
    private final By BILLING_BUTTON = By.xpath("//div[@class='call-to-action call-to-action-checkout']//a[@title='Icon button']");
    private final By LOGO = By.xpath("//img[@src='//c1.neweggimages.com/WebResource/Themes/2005/Nest/logo_424x210.png']");
    private final By ACCOUNT_LINK = By.xpath("//ins[contains(text(),'My Account')]");
    private final By LOGOUT_BUTTON = By.xpath("//a[contains(text(),'Logout')]");
    private final By THANKYOU_TITLE = By.xpath("//h1[contains(text(),'Thank You')]");
    private final By FORGOT_PASSWORD = By.xpath("//span[contains(text(),'Forgot your password?')]");
    private final By ASSISTANCE_TITLE = By.xpath("//h2[@class='page-title-second-text']");
    private final By EMAIL_OR_PHONE_FIELD = By.xpath("//input[@title='Email or Phone Number']");
    private final By SUBMIT_BUTTON = By.id("btn_forgot_pwd");

    public SearchPage(WebDriver driver){super(driver);}

    public boolean isMyAccountLinkDisplayed(){return webDriverCommands.waitForElementPresent(MYACCOUNT_LINK, 5);}

    public void SearchItem(String item){
        webDriverCommands.sendKeys(SEARCH_FIELD, item);
    }

    public void SearchItem2(String item2){
        webDriverCommands.sendKeys(SEARCH_FIELD, item2);
    }

    public void SearchItem3(String item3){
        webDriverCommands.sendKeys(SEARCH_FIELD, item3);
    }
    public void clickOnSearchButton(){
        webDriverCommands.click(SEARCH_BUTTON);
    }

    public void clickOnAddToCartButton(){
        webDriverCommands.click(ADD_TO_CART);
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");
    }

    public void scrollDownBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickOnRemoveItemCheck(){
        webDriverCommands.click(REMOVE_ITEM_CHECK);
    }

    public void clickOnRemoveItemButton(){
        webDriverCommands.click(REMOVE_ITEM_BUTTON);
    }

    public void updateQuantityItems(String itemsQuantity){
        webDriverCommands.sendKeys(QUANTITY_FIELD, itemsQuantity);
    }

    public void clickOnUpdateQuantityButton(){
        webDriverCommands.click(QUANTITY_BUTTON);
    }

    public void clickOnSecureCheckoutButton(){
        webDriverCommands.click(SECURE_CHECKOUT_BUTTON);
    }

    public boolean isShippingAddressDisplayed(){return webDriverCommands.waitForElementPresent(SHIPPING_TITLE, 5);}

    public void clickOnBillingButton(){
        webDriverCommands.click(BILLING_BUTTON);
    }

    public void clickOnLogo(){
        webDriverCommands.click(LOGO);
    }

    public void clickOnMyAccountLink(){
        webDriverCommands.click(ACCOUNT_LINK);
    }

    public void clickOnLogoutButton(){
        webDriverCommands.click(LOGOUT_BUTTON);
    }

    public boolean isThankyouPageDisplayed(){return webDriverCommands.waitForElementPresent(THANKYOU_TITLE, 5);}

    public void clickOnForgotPasswordLink(){
        webDriverCommands.click(FORGOT_PASSWORD);
    }

    public boolean isAssistancePageDisplayed(){return webDriverCommands.waitForElementPresent(ASSISTANCE_TITLE, 5);}

    public void emailForgot(String forgot){
        webDriverCommands.sendKeys(EMAIL_OR_PHONE_FIELD, forgot);
    }

    public boolean isSubmitButtonEnabled(){return webDriverCommands.waitForElementPresent(SUBMIT_BUTTON, 5);}

    public void clickOnSubmitButton(){
        webDriverCommands.click(SUBMIT_BUTTON);
    }

}
