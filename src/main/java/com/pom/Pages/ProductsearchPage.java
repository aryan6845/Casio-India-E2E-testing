package com.pom.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsearchPage {

    WebDriver driver;

    public ProductsearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateCategory(String catName, String textLength) {
        if (textLength == "Partial") {
            Assert.assertTrue(driver.findElement(By.partialLinkText(catName)).isDisplayed());
        }
        else {Assert.assertTrue(driver.findElement(By.linkText(catName)).isDisplayed());}
    }

    public void validateSubCatogries() {
        driver.findElement(By.linkText("Watches")).click();
        List<WebElement> subCatagories = driver.findElements(By.xpath("//li[@class='cmp-header-vertical-menu__sub-item']"));
        for (WebElement items : subCatagories) {
            Assert.assertTrue(items.isDisplayed());
        }
    }

    public void applyFilter(String type, int value) {
        if (type == "numberOfResults") {
            WebElement dropDown = driver.findElement(By.xpath("(//select[@name='pagemax'])[3]"));
            Select select = new Select(dropDown);
            select.selectByIndex(1);
        }
        else {
            WebElement dropDown2 = driver.findElement(By.xpath("(//select[@name='imgsize'])[3]"));
            Select select2 = new Select(dropDown2);
            select2.selectByIndex(0);
        }
    }

    public void assertResults(int filtersApplied) {
        if (filtersApplied == 1) {
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='mf_finder_organic_range_to']")).getText().contains("20"));
        }
        else {
            Assert.assertTrue(driver.findElement(By.xpath("//span[@class='mf_finder_organic_range_to']")).getText().contains("20"));
            Assert.assertEquals(driver.findElement(By.xpath("(//img[@alt='capture image'])[1]")).isDisplayed(), false);
        }
    }

}