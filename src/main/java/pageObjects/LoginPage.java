package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Gerardo
 */
public class LoginPage extends PageObjects {

    private final By LOGIN_TITLE = By.xpath("//a[@class='top-nav-tab-name logout']");
    private final By LOGIN_LINK = By.linkText("Log in or Register");
    private final By RETURNING_USER = By.xpath("//h2[@class='page-title-second-text']");
    private final By EMAIL_FIELD = By.id("UserName");
    private final By PASSWORD_FIELD = By.id("UserPwd");
    private final By SIGNIN_BUTTON = By.id("submitLogin");

    public LoginPage(WebDriver driver){super(driver);}

    public boolean isLoginTitleDisplayed(){return webDriverCommands.waitForElementPresent(LOGIN_TITLE, 5);}

    public boolean waitForElementVisible(int timeToWait){
        return webDriverCommands.waitForElementVisible(LOGIN_TITLE, timeToWait);
    }

    public void clickOnLoginLink(){
        webDriverCommands.click(LOGIN_LINK);
    }

    public boolean isReturningUserDisplayed(){return webDriverCommands.waitForElementPresent(RETURNING_USER, 5);}

    public boolean waitForReturningUserVisible(int timeToWait){
        return webDriverCommands.waitForElementVisible(RETURNING_USER, timeToWait);
    }

    public void insertEmail(String email){
        webDriverCommands.sendKeys(EMAIL_FIELD, email);
    }

    public void insertPassword(String password){
        webDriverCommands.sendKeys(PASSWORD_FIELD, password);
    }

    public boolean isSignInButtonEnabled(){return webDriverCommands.waitForElementPresent(SIGNIN_BUTTON, 5);}

    public void clickOnSignInButton(){
        webDriverCommands.click(SIGNIN_BUTTON);
    }

}
