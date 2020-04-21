package com.automation.tests;

import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HW3_StatusCodes extends AbstractTestBase{

    @Test(dataProvider = "linksAndMessages", description = "Status Codes Messages")
    public void verifyStatusCodesMessages(String codeName, String expectedMessage){

        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement statusCodesLink = driver.findElement(By.xpath("//a[contains(text(),'Status Codes')]"));
        statusCodesLink.click();

        WebElement codeLink = driver.findElement(By.xpath("//*[text()='"+codeName+"']"));
        codeLink.click();
        BrowserUtilities.wait(1);

        WebElement codeMess = driver.findElement(By.xpath("//p"));
        String actualMessage = codeMess.getText();

        BrowserUtilities.wait(1);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @DataProvider
    public Object[][] linksAndMessages(){
        return new Object[][] {
                {"200", "This page returned a 200 status code."},
                {"301", "This page returned a 301 status code."},
                {"404", "This page returned a 404 status code."},
                {"500", "This page returned a 500 status code."}
        };
    }


}
