package com.automation.tests;

import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class HW3_SignUpMailingList extends AbstractTestBase{

    @Test(description = "Test for getting new mail address and verifying the signing up mailing list with this email address")
    public void verifySignUpMailingList(){

        driver.get("https://www.tempmailaddress.com/");

        List<WebElement> frame = driver.findElements(By.cssSelector("[tabindex='2']"));
        if(frame.size()>0){
            frame.get(0).click();
        }

        WebElement emailTemp = driver.findElement(By.cssSelector("[id='email']"));
        String emailStr = emailTemp.getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement signUpForMailingList = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
        signUpForMailingList.click();

        WebElement fullNameInput = driver.findElement(By.xpath("//*[@name='full_name']"));
        fullNameInput.sendKeys("Bekci Murtaza");

        WebElement emailInput = driver.findElement(By.xpath("//*[@name='email']"));
        emailInput.sendKeys(emailStr);

        BrowserUtilities.wait(1);
        WebElement signUpBut = driver.findElement(By.xpath("//*[@name='wooden_spoon']"));
        signUpBut.click();

        BrowserUtilities.wait(1);
        WebElement signUpMess = driver.findElement(By.xpath("//*[@name='signup_message']"));
        String actualMess = signUpMess.getText();
        String expectedMess = "Thank you for signing up. Click the button below to return to the home page.";
        assertEquals(actualMess, expectedMess);

        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtilities.wait(1);
        WebElement mailReceived = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
        String actualMailFrom = mailReceived.getText();
        String expectedMailFrom = " do-not-reply@practice.cybertekschool.com";
        assertEquals(actualMailFrom, expectedMailFrom);
        mailReceived.click();

        WebElement mailFromAfterClickIn = driver.findElement(By.cssSelector("[id='odesilatel']"));
        String actualMailFromAfterClick = mailFromAfterClickIn.getText();
        String expectedMailFromAfterClick = "do-not-reply@practice.cybertekschool.com";
        assertEquals(actualMailFromAfterClick, expectedMailFromAfterClick);

        WebElement mailSubject = driver.findElement(By.cssSelector("[id='predmet']"));
        String actualSubject = mailSubject.getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        assertEquals(actualSubject, expectedSubject);
    }


}
