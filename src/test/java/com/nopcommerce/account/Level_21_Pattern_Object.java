package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_21_Pattern_Object extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Empty_Data() {

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("FirstName"), "First name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("LastName"), "Last name is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Email is required.");
        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "Password is required.");
    }

    @Test
    public void User_02_Register_Invalid_Email() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email","john@kennedy@us");
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("Email"), "Please enter a valid email address.");
    }

//    @Test
//    public void User_03_Register_Invalid_Password() {
//        registerPage.clickToNopCommerceLogo();
//
//        homePage = new HomePageObject(driver);
//
//        homePage.clickToRegisterLink();
//
//        registerPage = new RegisterPageObject();
//
//        registerPage.enterToFirtNameTextbox("John");
//        registerPage.enterToLastNameTextbox("Kennedy");
//        registerPage.enterToEmailTextbox("john@kennedy@us");
//        registerPage.enterToPasswordTextbox("123");
//        registerPage.enterToConfirmPasswordTextbox("123");
//
//        registerPage.clickToRegisterButton();
//
//        Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password must meet the following rules: must have at least 6 characters");
//    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email","john@kennedy@us");
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","654321");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextboxErrorMessageByID("ConfirmPassword"), "The password and confirmation password do not match.");
    }

    @Test
    public void User_05_Register_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.enterToTextboxByID("FirstName","John");
        registerPage.enterToTextboxByID("LastName","Kennedy");
        registerPage.enterToTextboxByID("Email",emailAddress);
        registerPage.enterToTextboxByID("Password","123456");
        registerPage.enterToTextboxByID("ConfirmPassword","123456");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
    }

    @Test
    public void User_06_Login_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Log out");
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

        loginPage.enterToTextboxByID("Email", emailAddress);
        loginPage.enterToTextboxByID("Password","123456");

        loginPage.clickToButtonByText("Log in");
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        Assert.assertEquals(customerPage.getTextboxAttributeByID("FirstName"), "John");
        Assert.assertEquals(customerPage.getTextboxAttributeByID("LastName"), "Kennedy");
        Assert.assertEquals(customerPage.getTextboxAttributeByID("Email"), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
