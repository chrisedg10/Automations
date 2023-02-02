package focus.testing;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import focus.Constants.WebDriverBase;
import focus.Functions.Browser;

public class test extends WebDriverBase implements Browser {
    @Parameters({ "browser", "URL" })
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser, String URL) throws Exception {
        webDriverSetUp(browser);
        driver.get(URL);
        driver.manage().deleteAllCookies();
    }

    @Parameters({ "search" })
    @Test(priority = 0)
    public void searchInBrowser(String search) throws Exception {
        search(driver, search);
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
