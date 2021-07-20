package com.sharelane.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest1 {


    @Test
    public void zipCodePositive(){
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

        WebElement signUpMessageElement = driver.findElement(By.className("grey_bg"));
        String signUpMessage = signUpMessageElement.getText();
        Assert.assertEquals(signUpMessage, "Sign Up");
        //driver.quit();
}
}
