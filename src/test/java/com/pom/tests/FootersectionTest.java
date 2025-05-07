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

import com.pom.Pages.FootersectionPage;

public class FootersectionTest {

    WebDriver driver;
    FootersectionPage footPag;

    @BeforeMethod
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1.5");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://casio.com/in");
        footPag = new FootersectionPage(driver);
    }


    @Test
    public void links() {
        footPag.validateLink("Privacy Policy");
        footPag.validateLink("Labour Compliance");
        footPag.validateLink("Secretarial (redirect)");
        footPag.validateLink("CSR Policy");
        footPag.validateLink("Cookie Policy");
        footPag.validateLink("Terms of Use");
        footPag.validateLink("Sitemap");
        footPag.validateLink("Contact Us");
        footPag.validateLink("India");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

}