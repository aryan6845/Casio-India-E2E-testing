package com.pom.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductdetailsPage {

    WebDriver driver;

    public ProductdetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void expandAllSpecs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> plusButtons = driver.findElements(By.xpath("//span[@aria-label='accordion plus']"));
        for (WebElement item : plusButtons) {wait.until(ExpectedConditions.elementToBeClickable(item)).click();}
    }

    public void assertAllDetails() {
        List<WebElement> details = driver.findElements(By.xpath("//div[@class='p-product_detail-spec-accordion__panel-inner']"));
        for (WebElement item : details) {Assert.assertTrue(item.isDisplayed());}
    }

    public void assertAllImages() {
        List<WebElement> images = driver.findElements(By.xpath("//img[@fetchpriority='high']"));
        for (WebElement item : images) {Assert.assertTrue(item.isDisplayed());}
    }

    public void cartValidation() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        driver.findElement(By.xpath("//a[@href='/in/cart/']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'cart-item')]")).isDisplayed());
    }

    public void recommendationsPresence() {
        Assert.assertTrue(driver.findElements(By.xpath("//div[contains(@class,'related-products')]//div[contains(@class,'product-card')]")).size()>0);
    }

    public void stockStatus() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'In stock') or contains(text(),'Out of stock')]")).isDisplayed());
    }

}