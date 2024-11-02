package com.nopcommerce.share;

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

public class Payment extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextbox(Common_Register.emailAddress);
        loginPage.enterToPasswordTextbox(Common_Register.password);

        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
        Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);

        System.out.println("Email at Payment = " + Common_Register.emailAddress);
        System.out.println("Password at Payment = " + Common_Register.password);
    }

    @Test
    public void Payment_01_Visa() {

    }

    @Test
    public void Payment_02_Cheque() {

    }

    @Test
    public void Payment_03_Paypal() {

    }

    @Test
    public void Payment_04_Bitcoin() {

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
