package com.focus;

import static org.junit.Assert.fail;

import org.testng.annotations.*;

import com.focus.Constants.WebDriverBase;
import com.focus.Functions.Browser;

public class FocusTest extends WebDriverBase implements Browser {
    @Parameters({ "browser", "URL" })
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String URL) throws Exception {
        webDriverSetUp(browser);
        driver.get(URL);
        driver.manage().deleteAllCookies();
    }

    @Parameters({ "searchText" })
    @Test(priority = 0)
    public void newSearch(String searchText){
        search(driver, searchText);
    }

    @Parameters({ "searchText" })
    @Test(priority = 1)
    public void seeResults(String searchText){
        evaluateResults(driver, searchText);
    }

    @Test(priority = 2)
    public void focusLandingPage(){
        apply(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
