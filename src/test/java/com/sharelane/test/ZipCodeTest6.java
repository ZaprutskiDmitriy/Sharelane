package com.sharelane.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZipCodeTest6 {
    @Test
    public void zipCodeNegative5(){
        System.setProperty("webdriver.chrome.driver", "D:/TeachMeSkills/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open "Sharelane" login page
        // Click on the "sign up" button
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        // Fill the form with the required ZIP code
        driver.findElement(By.name("zip_code"));
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys(".@#;*");
        WebElement continueButton = driver.findElement(By.cssSelector("[type='submit'][value='Continue']"));
        continueButton.click();

        WebElement errorMessageElement = driver.findElement(By.className("error_message"));
        String errrorMessage = errorMessageElement.getText();
        Assert.assertEquals(errrorMessage, "Oops, error on page. ZIP code should have 5 digits");
        //driver.quit();
    }
}
