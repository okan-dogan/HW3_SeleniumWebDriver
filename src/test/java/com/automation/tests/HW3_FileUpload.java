package com.automation.tests;

import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HW3_FileUpload extends AbstractTestBase{

    @Test(description = "Upload a file to the site")
    public void verifyFileUploaded(){

        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement fileUploadLink = driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
        fileUploadLink.click();

        String path = "C:\\Users\\eioka\\Desktop\\testtt.txt";
        WebElement chooseFileBut = driver.findElement(By.cssSelector("[id='file-upload']"));
        chooseFileBut.sendKeys(path);
        BrowserUtilities.wait(2);

        WebElement uploadFileBut = driver.findElement(By.cssSelector("[id='file-submit']"));
        uploadFileBut.click();

        BrowserUtilities.wait(1);
        WebElement fileUploadedMess = driver.findElement(By.xpath("//h3"));
        String actualMess = fileUploadedMess.getText();
        String expectedMess = "File Uploaded!";
        assertEquals(actualMess, expectedMess);

        WebElement uploadedFileName = driver.findElement(By.cssSelector("[id='uploaded-files']"));
        String actualFileName = uploadedFileName.getText();
        String expectedFileName = "testtt.txt";
        assertEquals(actualFileName, expectedFileName);

    }


}
