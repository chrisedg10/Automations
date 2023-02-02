package focus.Functions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import focus.Contexts.Google;

public interface Browser {
    /* Browser Search */
    default public void search(WebDriver driver, String text) throws Exception{
        Google element = new Google(driver);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        Thread.sleep(5000);
        element.searchBar().sendKeys(text);
        Thread.sleep(5000);
        element.searchButton().click();
    }
}
