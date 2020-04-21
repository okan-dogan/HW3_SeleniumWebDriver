package com.automation.tests;

import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HW3_AutoComplete extends AbstractTestBase{

    @Test(description = "Autocomplete")
    public void verifyAutocompleteMessage(){

        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement autocompleteLink = driver.findElement(By.xpath("//a[contains(text(),'Autocomplete')]"));
        autocompleteLink.click();

        WebElement countryInput = driver.findElement(By.cssSelector("[id='myCountry']"));
        countryInput.sendKeys("United States of America");
        BrowserUtilities.wait(1);

        WebElement countrySubmitBut = driver.findElement(By.xpath("//*[@value='Submit']"));
        countrySubmitBut.click();
        BrowserUtilities.wait(1);

        WebElement countrySelectionResult = driver.findElement(By.cssSelector("[id='result']"));
        String actualMess = countrySelectionResult.getText();
        String expectedMess = "You selected: United States of America";
        assertEquals(actualMess, expectedMess);
        BrowserUtilities.wait(1);


    }


}
