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

import com.pom.Pages.ContactusPage;

public class ContactusTest {

    WebDriver driver;
    ContactusPage contactPag;

    @BeforeMethod
    public void setUp() {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=1.5");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://support.casio.in/");
        contactPag = new ContactusPage(driver);
    }


    @Test
    public void emailUs() {
        contactPag.emailWorking();
    }

    @Test
    public void phoneNumber() {
        contactPag.telephoneCheck();
    }

    @Test
    public void helpline() {
        contactPag.assertElement(1);
        contactPag.assertElement(2);
    }

    @Test
    public void getInTouch() {
        contactPag.getInTouchFunction();
    }

    @Test
    public void contactForm() {
        contactPag.formAbsence();
    }

    @Test
    public void responsiveness() {
        contactPag.changeResolution(375, 667);
        contactPag.assertElementVisibility("Left Most");
        contactPag.assertElementVisibility("Right Most");
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

}