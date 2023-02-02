package focus.Constants;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBase {
    public static WebDriver driver;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected WebDriverWait wait;

    @Parameters({ "browser" })
    public void webDriverSetUp(String browser) throws Exception{
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if(browser.equals("Edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if(browser.equals("Chrome")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }
}
