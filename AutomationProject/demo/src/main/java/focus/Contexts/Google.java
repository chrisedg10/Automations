package focus.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google {
    private WebDriver driver;

    public Google(WebDriver driver){
        this.driver = driver;
    }

    public WebElement searchBar(){
        return driver.findElement(By.className("gLFyf"));
    }

    public WebElement searchButton(){
        return driver.findElement(By.className("gNO89b"));
    }
}
