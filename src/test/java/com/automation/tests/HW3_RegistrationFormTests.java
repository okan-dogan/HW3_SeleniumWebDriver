package com.automation.tests;

import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class HW3_RegistrationFormTests extends AbstractTestBase{


    @Test(description = "Test 1 out of 5")
    public void verifyInvalidDOB(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
        registrationLink.click();

        WebElement dateOfBirthInput = driver.findElement(By.xpath("//*[@name='birthday']"));
        wait.until(ExpectedConditions.visibilityOf(dateOfBirthInput));
        dateOfBirthInput.sendKeys("wrong_dob");
        WebElement dobInvalid = driver.findElement(By.xpath("//*[@data-bv-result='INVALID']"));
        String actual = dobInvalid.getText();
        String expected = "The date of birth is not valid";
        assertEquals(actual, expected);

    }


    @Test(description = "Test 2 out of 5")
    public void verifyLanguageOptions(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
        registrationLink.click();

        WebElement option1 = driver.findElement(By.xpath("//*[@id='inlineCheckbox1']//following-sibling::label"));
        String str_option1 = option1.getText();
        String expected1 = "C++";
        assertEquals(expected1, str_option1);
        assertEquals(option1.isDisplayed(),true);

        WebElement option2 = driver.findElement(By.xpath("//*[@id='inlineCheckbox2']//following-sibling::label"));
        String str_option2 = option2.getText();
        String expected2 = "Java";
        assertEquals(expected2, str_option2);
        assertEquals(option2.isDisplayed(),true);

        WebElement option3 = driver.findElement(By.xpath("//*[@id='inlineCheckbox3']//following-sibling::label"));
        String str_option3 = option3.getText();
        String expected3 = "JavaScript";
        Assert.assertEquals(expected3, str_option3);
        assertEquals(option3.isDisplayed(),true);

    }


    @Test(description = "Test 3 out of 5")
    public void verifyInvalidFirstName(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
        registrationLink.click();

        WebElement firstNameInput = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstNameInput.sendKeys("a");
        WebElement firstNameInvalid = driver.findElement(By.xpath("//*[@data-bv-result='INVALID']"));
        String actual = firstNameInvalid.getText();
        String expected = "first name must be more than 2 and less than 64 characters long";
        assertEquals(actual, expected);

    }


    @Test(description = "Test 4 out of 5")
    public void verifyInvalidLastName(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
        registrationLink.click();

        WebElement lastNameInput = driver.findElement(By.xpath("//*[@name='lastname']"));
        lastNameInput.sendKeys("a");
        WebElement lastNameInvalid = driver.findElement(By.xpath("//*[@data-bv-result='INVALID']"));
        String actual = lastNameInvalid.getText();
        String expected = "The last name must be more than 2 and less than 64 characters long";
        assertEquals(actual, expected);

    }


    @Test(description = "Test 5 out of 5")
    public void completeRegistration(){
        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationLink = driver.findElement(By.xpath("//a[contains(text(),'Registration')]"));
        registrationLink.click();

        WebElement firstNameInput = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstNameInput.sendKeys("bekci");

        WebElement lastNameInput = driver.findElement(By.xpath("//*[@name='lastname']"));
        lastNameInput.sendKeys("murtaza");

        WebElement userNameInput = driver.findElement(By.xpath("//*[@name='username']"));
        userNameInput.sendKeys("bekcimurtaza");

        WebElement emailInput = driver.findElement(By.xpath("//*[@name='email']"));
        emailInput.sendKeys("abc@abc.com");

        WebElement passwordInput = driver.findElement(By.xpath("//*[@name='password']"));
        passwordInput.sendKeys("abcdefgh");

        WebElement phoneInput = driver.findElement(By.xpath("//*[@name='phone']"));
        phoneInput.sendKeys("123-456-7890");

        WebElement genderInput = driver.findElement(By.xpath("(//*[@name='gender'])[1]"));
        genderInput.click();

        WebElement birthdayInput = driver.findElement(By.xpath("//*[@name='birthday']"));
        birthdayInput.sendKeys("01/31/2000");

        WebElement departmentInput = driver.findElement(By.xpath("//*[@name='department']"));
        Select select1 = new Select(departmentInput);
        select1.selectByVisibleText("Department of Engineering");

        WebElement jobTitleInput = driver.findElement(By.xpath("//*[@name='job_title']"));
        Select select2 = new Select(jobTitleInput);
        select2.selectByVisibleText("SDET");

        WebElement option2 = driver.findElement(By.xpath("//*[@id='inlineCheckbox2']//following-sibling::label"));
        option2.click();

        BrowserUtilities.wait(2);
        WebElement signUpBut = driver.findElement(By.xpath("//*[@id='wooden_spoon']"));
        signUpBut.click();

        WebElement successfulRegistrationMess = driver.findElement(By.xpath("//p"));
        String actual = successfulRegistrationMess.getText();
        String expected = "You've successfully completed registration!";
        assertEquals(actual, expected);

    }




}
