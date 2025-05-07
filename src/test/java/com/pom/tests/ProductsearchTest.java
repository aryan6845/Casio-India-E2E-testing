package com.pom.tests;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.Pages.HomepagePage;
import com.pom.Pages.ProductsearchPage;

public class ProductsearchTest {

    WebDriver driver;
    HomepagePage homPag;
    ProductsearchPage prodPag;

    @BeforeMethod
    public void setUp() {

        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1.5");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.casio.com/in/");
        homPag.typeAndSearch("watches");
        prodPag = new ProductsearchPage(driver);

    }


    @Test
    public void productCategoryDisplay() {
        prodPag.validateCategory("Watches", "Full");
        prodPag.validateCategory("Electronic", "Partial");
        prodPag.validateCategory("Calculators", "Full");
        prodPag.validateCategory("Label", "Partial");
    }

    @Test
    public void productSubCategoryDisplay() {
        prodPag.validateSubCatogries();
    }

    @Test
    public void numberFilter() {
        prodPag.applyFilter("numberOfResults", 20);
        prodPag.assertResults(1);
    }

    @Test
    public void multipleFilters() {
        prodPag.applyFilter("numberOfResults", 20);
        prodPag.applyFilter("imageSize", 0);
        prodPag.assertResults(2);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

}