package com.focus.Contexts;

import java.util.List;

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

    public List<WebElement> tabs(){
        List<WebElement> results = driver.findElements(By.className("menu-item-top-level"));
        return results;
    }

    public List<WebElement> locations(){
        List<WebElement> results = driver.findElements(By.className("av-tab-with-image"));
        return results;
    }

    public List<WebElement> titles(){
        List<WebElement> results = driver.findElements(By.tagName("h2"));
        return results;
    }

    public List<WebElement> subTitles(){
        List<WebElement> results = driver.findElements(By.tagName("h3"));
        return results;
    }

}
