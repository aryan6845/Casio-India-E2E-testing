package com.pom.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomepagePage {

    WebDriver driver;

    public HomepagePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateSupport() {
        driver.findElement(By.linkText("Support")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("support"));
    }

    public void validateCorporate() {
        driver.findElement(By.linkText("Corporate")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("world"));
    }

    public void assertElement(String xpathExp) {
        Assert.assertTrue(driver.findElement(By.xpath(xpathExp)).isDisplayed());
    }

    public void typeAndSearch(String text) {
        driver.findElement(By.xpath("(//input[@title='Search'])[1]")).sendKeys(text);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
    }

    public void assertSearchResults() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='mf_finder_organic_doc']"));
        for (WebElement el : elements) {Assert.assertTrue(el.isDisplayed());}
    }

    public void doubleSearch() {
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
    }

}