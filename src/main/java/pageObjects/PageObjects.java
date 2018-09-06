package pageObjects;

import org.openqa.selenium.WebDriver;
import selenium.WebDriverCommands;

/**
 * Created by Gerardo
 */
public class PageObjects {

    protected WebDriver driver;
    protected WebDriverCommands webDriverCommands;

    public PageObjects(WebDriver driver){
        webDriverCommands = new WebDriverCommands(driver);
        this.driver = driver;
    }

    public WebDriver getDriver(){return this.driver;}
}
