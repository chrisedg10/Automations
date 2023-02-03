package com.focus.Functions;

import org.testng.asserts.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.focus.Contexts.*;

public interface Browser extends Waits{
    default public void search(WebDriver driver, String searchText){
        
        System.out.println("\nBrowser Initialized");
        
        Google page = new Google(driver);
        page.searchBar().sendKeys(searchText);
        page.searchBar().sendKeys(Keys.ENTER);
        page.searchButton().click();
    }

    default public void evaluateResults(WebDriver driver, String searchText){
        System.out.println("\nReading results");

        Google links = new Google(driver);
        System.out.println("Elements found: " + links.results().size());

        for (WebElement e : links.results()) {
            if((e.getAttribute("href")!=null) && e.getAttribute("href").startsWith(searchText)){
                
                if(e.getAttribute("href").equals(searchText)){
                    e.click();
                    System.out.println("\tClicked on: " + e.getAttribute("href")); 
                }
            }
        }
    }

    default public void apply(WebDriver driver){
        System.out.println("\nFocus landing page");

        Focus focus = new Focus(driver);
        SoftAssert softAssert = new SoftAssert();

        waitUntilElementIsVisible(driver, focus.applyButton());

        softAssert.assertTrue(focus.applyButton().isDisplayed(), "Existing Now Hiring Button");
        softAssert.assertAll();

        Actions actions = new Actions(driver); 
        actions.moveToElement(focus.applyButton());
        actions.clickAndHold(focus.applyButton());
        actions.release().perform();
        
    }
}
