package com.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactusPage {

    WebDriver driver;

    public ContactusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void emailWorking() {
        driver.findElement(By.partialLinkText("email")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("mail.google"));
    }

    public void telephoneCheck() {
        driver.findElement(By.xpath("((//div[@class='services-content'])[10]//*[2])[1]")).isDisplayed();
    }

    public void assertElement(int helpline) {
        WebElement helplineElement = driver.findElement(By.linkText("Helpline " + helpline));
        Assert.assertTrue(helplineElement.isDisplayed() && helplineElement.isEnabled());
    }

    public void getInTouchFunction() {
        driver.findElement(By.xpath("//a[@title='Get in touch']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("contact-info"));
    }

    public void formAbsence() {
        Assert.assertTrue(driver.findElements(By.xpath("//form[contains(@class,'contact') or contains(@id,'contact')]")).isEmpty());
    }

    public void changeResolution(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void assertElementVisibility(String position) {
        if (position == "Left Most") {driver.findElement(By.xpath("//img[@alt='Casio Customer Support']")).isDisplayed();}
        else {driver.findElement(By.xpath("//a[@title='Login']")).isDisplayed();}
    }

}