package com.focus.Contexts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Focus {
    private WebDriver driver;

    public Focus(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement applyButton(){
        WebElement apply = driver.findElement(By.linkText("Now Hiring!"));

        return apply;
    }
}
