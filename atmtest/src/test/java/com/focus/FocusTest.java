package com.focus;

import static org.junit.Assert.fail;

import org.testng.annotations.*;

import com.focus.Constants.WebDriverBase;
import com.focus.Functions.Browser;
import com.focus.Functions.FocusPage;

public class FocusTest extends WebDriverBase implements Browser, FocusPage {
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

    @Parameters({ "tab" })
    @Test(priority = 3)
    public void selectTabOption(String tab){
        selectTab(driver, tab);
    }

    @Parameters({ "location", "locationTwo", "locationThree", "title", "titleTwo" })
    @Test(priority = 4)
    public void selectTabLocation(String location, String locationTwo, String locationThree, String title, String titleTwo) throws InterruptedException{
        selectLocation(driver, location, locationTwo, locationThree, title, titleTwo);
        Thread.sleep(10000);
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
