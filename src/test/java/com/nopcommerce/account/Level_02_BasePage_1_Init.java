package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_BasePage_1_Init {
    WebDriver driver;

    // Vi phạm nguyên tắc: Không khởi tạo trực tiếp đối tượng ở trên class Test
    // Nên che giấu/ ẩn giấu nó đi
    private BasePage basePage = new BasePage();

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void Register_01_Empty_Data() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");
        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
    }

    @Test
    public void Register_02_Invalid_Email() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", "john@kennedy@us");
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Please enter a valid email address.");
    }

//    @Test
//    public void Register_03_Invalid_Password() {
//        driver.get("https://demo.nopcommerce.com/");
//        driver.findElement(By.cssSelector("a.ico-register")).click();
//        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("John");
//        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Kennedy");
//        driver.findElement(By.cssSelector("input#Email")).sendKeys("john@kennedy.us");
//        driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
//        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
//        driver.findElement(By.cssSelector("button#register-button")).click();
//        Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules: must have at least 6 characters");
//    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", "john@kennedy.us");
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_05_Success() {
        basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");

        basePage.clickToElement(driver, "//a[@class='ico-register']");

        basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "John");
        basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Kennedy");
        basePage.sendkeyToElement(driver, "//input[@id='Email']", getEmailRandom());
        basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
        basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public String getEmailRandom() {
        return "john" + new Random().nextInt(99999) + "@kennedy.us";
    }
}
