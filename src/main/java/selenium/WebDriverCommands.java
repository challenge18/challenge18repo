package selenium;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

/**
 * Created by Gerardo
 */
public class WebDriverCommands extends SelenuimSetUp {

    private WebDriver driver;

    public WebDriverCommands(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForElementPresent(final By element, int amountSecondsToWait) {

        boolean isElementPresent = true;

        try {

            Wait<WebDriver> wait = new FluentWait<>(this.driver)

                    .withTimeout(Duration.ofSeconds(amountSecondsToWait))
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {

                public WebElement apply(WebDriver d) {

                    d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    WebElement webElement = d.findElement(element);
                    return webElement;
                }
            });

        } catch (TimeoutException te) {

            isElementPresent = false;
        }
        return isElementPresent;

    }

    public boolean waitForElementPresent(final By element) {
        boolean isElementPresent = true;

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(5, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver d) {
                    d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    WebElement we = d.findElement(element);
                    return we;
                }

            });

        } catch (TimeoutException te) {

            isElementPresent = false;
        }

        return isElementPresent;
    }

    public boolean waitForElement(final By element) {
        boolean isElementPresent = true;

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(5, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {

                public WebElement apply(WebDriver d) {
                    d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    WebElement we = d.findElement(element);
                    return we;
                }
            });

        } catch (TimeoutException te) {

            isElementPresent = false;

        }
        return isElementPresent;
    }

    public boolean waitForElementVisible(final By element, int timeToWait) {
        boolean isElementPresent = true;

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));


        } catch (TimeoutException te) {

            isElementPresent = false;
        }


        return isElementPresent;
    }

    public void sendKeys(By element, String data) {
        if (waitForElement(element)) {
            driver.findElement(element).clear();
            driver.findElement(element).sendKeys(data);
        }

    }

    public void click(By element) {
        if (waitForElementPresent(element)) {
            driver.findElement(element).click();
        }

    }

}