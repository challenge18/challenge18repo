package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Gerardo
 */
public class SelenuimSetUp {
    protected WebDriver driver;
    protected String browserName = "";

    public void SetUp(String browser){

        this.browserName = browser;

        if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","C:/Program Files/Mozilla Firefox/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
            driver = new FirefoxDriver(options);
        }

            else if(browser.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1024,768");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver();
        }

            else if(browser.equals("IE")){
            System.setProperty("webdriver.ie.driver", "C:/Program Files (x86)/Internet Explorer/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();

    }

    public void tearDown(){driver.quit();}

    public WebDriver getDriverInstance(){return driver;}
}
