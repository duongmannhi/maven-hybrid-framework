package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

@Epic("Account")
@Feature("Create Account")
public class Level_19_Allure_Report extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    String emailAddress = getEmailRandom();
    private String firstName, lastName, password;
    private String browserName;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        firstName = "John";
        lastName = "Kennedy";
        password = "123456";
    }

    @Description("User 01 - Validate register form")
    @Story("register")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register_Validate() {
        Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
    }

    @Description("User 02 - Register success")
    @Story("register")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void User_02_Register_Success() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.enterToFirstNameTextbox(firstName);

        registerPage.enterToLastNameTextbox(lastName);

        registerPage.enterToEmailTextbox(emailAddress);

        registerPage.enterToPasswordTextbox(password);

        registerPage.enterToConfirmPasswordTextbox(password);

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
