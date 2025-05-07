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

public class HomepageTest {

    WebDriver driver;
    HomepagePage homPag;

    @BeforeMethod
    public void setUp() {

        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1.5");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.casio.com/in/");
        homPag = new HomepagePage(driver);

    }


    @Test
    public void headerLinks() {
        homPag.validateSupport();
        driver.navigate().back();
        homPag.validateCorporate();
    }

    @Test
    public void brandLogo() {
        homPag.assertElement("(//span[@class='cmp-header-logo__brand'])[1]");
    }

    @Test
    public void validSearchBar() {
        homPag.typeAndSearch("watches");
        homPag.assertSearchResults();
    }

    @Test
    public void invalidSearchBar() {
        homPag.typeAndSearch("234j3i2$#@4");
        homPag.assertElement("//div[@class='mf_finder_organic_no_results']");
    }

    @Test
    public void emptySearchBar() {
        homPag.doubleSearch();
        // Conditional pass!
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

}