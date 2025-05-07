package com.pom.tests;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.Pages.ProductdetailsPage;

public class ProductdetailsTest {

    WebDriver driver;
    ProductdetailsPage prodDetPag;

    @BeforeMethod
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1.5");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.casio.com/in/");
        driver.findElement(By.xpath("(//img[@class='alternative-image'])[1]")).click();
        prodDetPag = new ProductdetailsPage(driver);
    }


    @Test
    public void detailsDisplay() {
        prodDetPag.expandAllSpecs();
        prodDetPag.assertAllDetails();
    }

    @Test
    public void imagesViewing() {
        prodDetPag.assertAllImages();
    }

    @Test
    public void addToCartChecking() {
        prodDetPag.cartValidation();
    }

    @Test
    public void relatedProducts() {
        prodDetPag.recommendationsPresence();
    }

    @Test
    public void stockAvailability() {
        prodDetPag.stockStatus();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

}