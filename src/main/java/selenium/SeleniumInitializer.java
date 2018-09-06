package selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by Gerardo
 */
public class SeleniumInitializer extends SelenuimSetUp {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","url"})

    public void setUp(String browserName, String url){
        super.SetUp(browserName);
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){super.tearDown();}

}
