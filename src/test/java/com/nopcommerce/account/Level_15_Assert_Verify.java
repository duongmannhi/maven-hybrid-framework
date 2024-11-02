package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

public class Level_15_Assert_Verify extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    String emailAddress = getEmailRandom();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        // Verify Register link displayed -> FAILED
        verifyFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        // Verify error message at Firstname textbox -> PASSED
        verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

        // Verify error message at Firstname textbox -> FAILED
        verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");

        registerPage.enterToFirstNameTextbox("John");
        registerPage.enterToLastNameTextbox("Kennedy");
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToPasswordTextbox("123456");
        registerPage.enterToConfirmPasswordTextbox("123456");

        registerPage.clickToRegisterButton();

        // Verify success message -> FAILED
        verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
