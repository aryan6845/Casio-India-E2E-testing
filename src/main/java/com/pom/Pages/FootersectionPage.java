package com.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FootersectionPage {

    WebDriver driver;

    public FootersectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateLink(String text) {
        driver.findElement(By.linkText(text)).click();
        Assert.assertTrue(!driver.getCurrentUrl().endsWith("casio.in/"));
        driver.navigate().back();
    }

}