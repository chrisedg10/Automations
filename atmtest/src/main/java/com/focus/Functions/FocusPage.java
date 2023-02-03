package com.focus.Functions;

import org.testng.asserts.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.focus.Contexts.*;

public interface FocusPage extends Waits{
    default public void apply(WebDriver driver){
        System.out.println("\nFocus landing page");

        Focus focus = new Focus(driver);
        SoftAssert softAssert = new SoftAssert();

        waitUntilElementIsVisible(driver, focus.applyButton());

        softAssert.assertTrue(focus.applyButton().isDisplayed(), "Existing Now Hiring Button");

        Actions actions = new Actions(driver); 
        actions.moveToElement(focus.applyButton());
        actions.clickAndHold(focus.applyButton());
        actions.release().perform();
        System.out.println("Clicked on: Now Hiring! ");         
    }

    default public void selectTab(WebDriver driver, String tab){
        System.out.println("\nReading tabs");

        Focus links = new Focus(driver);
        Actions actions = new Actions(driver); 

        System.out.println("\nTabs found: " + links.tabs().size());

        for (WebElement e : links.tabs()) {

            WebElement option = e.findElement(By.tagName("a"));

            if(option.getAttribute("href").contains(tab)){
                System.out.println("Clicking on: " + option.getAttribute("href"));
                actions.moveToElement(option);        
                actions.clickAndHold(option);
                actions.release().perform();
            }
        }
    }

    default public void selectLocation(WebDriver driver, String location, String locationTwo, String locationThree, String title, String titleTwo){
        System.out.println("\nReading locations");

        Focus links = new Focus(driver);
        Actions actions = new Actions(driver); 
        SoftAssert softAssert = new SoftAssert();

        System.out.println("\nLocations found: " + links.locations().size());

        for (WebElement e : links.locations()) {
            
            if((e.getAttribute("href")!=null) && e.getAttribute("href").contains(location)){
                softAssert.assertTrue(e.getAttribute("href").contains(location), "Existing Tab");
                if(e.getAttribute("href").contains(location)){
                    System.out.println("Clicking on: " + e.getAttribute("href")); 
                    actions.moveToElement(e);        
                    actions.clickAndHold(e);
                    actions.release().perform();
                }
            }

            if((e.getAttribute("href")!=null) && e.getAttribute("href").contains(locationTwo)){
                softAssert.assertTrue(e.getAttribute("href").contains(locationTwo), "Existing Tab");
                if(e.getAttribute("href").contains(locationTwo)){
                    System.out.println("Clicking on: " + e.getAttribute("href")); 
                    waitUntilElementIsClickable(driver, e);
                    actions.moveToElement(e);        
                    actions.clickAndHold(e);
                    actions.release().perform();

                    for(WebElement x: links.titles()){
                        if(x.getText().contains(title)){
                            System.out.println("Title found: " + x.getText());
                            actions.moveToElement(x); 
                        }
                    }
                }
            }

            if((e.getAttribute("href")!=null) && e.getAttribute("href").contains(locationThree)){
                softAssert.assertTrue(e.getAttribute("href").contains(locationThree), "Existing Tab");
                if(e.getAttribute("href").contains(locationThree)){
                    System.out.println("Clicking on: " + e.getAttribute("href")); 
                    waitUntilElementIsClickable(driver, e);
                    actions.moveToElement(e);        
                    actions.clickAndHold(e);
                    actions.release().perform();

                    for(WebElement x: links.subTitles()){
                        if(x.getText().contains(titleTwo)){
                            System.out.println("Title found: " + x.getText());
                            actions.moveToElement(x); 
                        }
                    }
                }
            }
        }
    }
}
