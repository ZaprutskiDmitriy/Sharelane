package com.sharelane.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SigningTest {



    @Test
    public void signInPositive(){
        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open "Sharelane" login page
        // Click on the "sign up" button
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // Fill the form with the required ZIP code
        driver.findElement(By.name("zip_code"));
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit'][value='Continue']"));
        continueButton.click();

        // Fill in the fields
        WebElement firstNameInput = driver.findElement(By.cssSelector("[type='text'][name='first_name']"));
        firstNameInput.sendKeys("first name");
        WebElement lastNameInput = driver.findElement(By.cssSelector("[type='text'][name='last_name']"));
        lastNameInput.sendKeys("last name");
        WebElement emailInput = driver.findElement(By.cssSelector("[type='text'][name='email']"));
        emailInput.sendKeys("test@test.com");
        WebElement passwordInput1 = driver.findElement(By.cssSelector("[type='text'][name='password1']"));
        passwordInput1.sendKeys("12345");
        WebElement passwordInput2 = driver.findElement(By.cssSelector("[type='password'][name='password2']"));
        passwordInput2.sendKeys("12345");
        WebElement registerButton = driver.findElement(By.cssSelector("[type='submit'][value='Register']"));
        registerButton.click();

        // Assert that we are signed in
        WebElement confirmationMessageElement = driver.findElement(By.className("confirmation_message"));
        String confirmationMessage = confirmationMessageElement.getText();
        Assert.assertEquals(confirmationMessage, "Account is created!");
        //driver.quit();
    }
}
