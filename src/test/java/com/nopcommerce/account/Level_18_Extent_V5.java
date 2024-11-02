package com.nopcommerce.account;//package com.nopcommerce.account;
//
//import com.aventstack.extentreports.Status;
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import pageObjects.user.HomePageObject;
//import pageObjects.user.RegisterPageObject;
//import reportConfig.ExtentManager;
//import reportConfig.ExtentTestManager;
//
//import java.lang.reflect.Method;
//
//public class Level_18_Extent_V5 extends BaseTest {
//    WebDriver driver;
//    private HomePageObject homePage;
//    private RegisterPageObject registerPage;
//    String emailAddress = getEmailRandom();
//    private String firstName, lastName, password;
//    private String browserName;
//
//    @Parameters("browser")
//    @BeforeClass
//    public void beforeClass(String browserName) {
//        this.browserName = browserName;
//        driver = getBrowserDriver(browserName);
//        homePage = PageGeneratorManager.getHomePage(driver);
//        registerPage = PageGeneratorManager.getRegisterPage(driver);
//
//        firstName = "John";
//        lastName = "Kennedy";
//        password = "123456";
//    }
//
//    @Test
//    public void User_01_Register_Validate(Method method) {
//        ExtentTestManager.startTest(method.getName() + " - Run on "  + browserName.toUpperCase(), "User_01_Register_Validate");
//        ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify Register link displayed");
//
//        Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: Click to Register link");
//        registerPage = homePage.clickToRegisterLink();
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: Click to Register button");
//        registerPage.clickToRegisterButton();
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: Verify error message at First Name textbox is 'First name is required.'");
//        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 05: Verify error message at Last Name textbox is 'Last name is required'");
//        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
//    }
//
//    @Test
//    public void User_02_Register_Success(Method method) {
//        ExtentTestManager.startTest(method.getName() + " - Run on "  + browserName.toUpperCase(), "User_02_Register_Success");
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 01: Enter to First Name textbox with value is " + firstName);
//        registerPage = homePage.clickToRegisterLink();
//        registerPage.enterToFirtNameTextbox(firstName);
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 02: Enter to Last Name textbox with value is " + lastName);
//        registerPage.enterToLastNameTextbox(lastName);
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 03: Enter to Email Address textboxwith value is " + emailAddress);
//        registerPage.enterToEmailTextbox(emailAddress);
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 04: Enter to Password textboxwith value is " + password);
//        registerPage.enterToPasswordTextbox(password);
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 05: Enter to Confirm Password textboxwith value is " + password);
//        registerPage.enterToConfirmPasswordTextbox(password);
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 06: Click to Register button");
//        registerPage.clickToRegisterButton();
//
//        ExtentTestManager.getTest().log(Status.INFO,"Register - Step 07: Verify success message is displayed");
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        closeBrowser();
//    }
//}
