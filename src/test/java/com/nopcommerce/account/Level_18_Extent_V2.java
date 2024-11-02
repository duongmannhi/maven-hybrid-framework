package com.nopcommerce.account;//package com.nopcommerce.account;
//
//import com.relevantcodes.extentreports.LogStatus;
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
//
//import java.lang.reflect.Method;
//
//public class Level_18_Extent_V2 extends BaseTest {
//    WebDriver driver;
//    private HomePageObject homePage;
//    private RegisterPageObject registerPage;
//    String emailAddress = getEmailRandom();
//    private String firstName, lastName, password;
//
//    @Parameters("browser")
//    @BeforeClass
//    public void beforeClass(String browserName) {
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
//        ExtentManager.startTest(method.getName(), "User_01_Register_Validate");
//
//        ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Verify Register link displayed");
//        Assert.assertFalse(homePage.isRegisterLinkDisplayed());
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 02: Click to Register link");
//        registerPage = homePage.clickToRegisterLink();
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 03: Click to Register button");
//        registerPage.clickToRegisterButton();
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 04: Verify error message at First Name textbox is 'First name is required.'");
//        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 05: Verify error message at Last Name textbox is 'Last name is required'");
//        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
//    }
//
//    @Test
//    public void User_02_Register_Success(Method method) {
//        ExtentManager.startTest(method.getName(), "User_02_Register_Success");
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 01: Enter to First Name textbox with value is " + firstName);
//        registerPage = homePage.clickToRegisterLink();
//        registerPage.enterToFirtNameTextbox(firstName);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 02: Enter to Last Name textbox with value is " + lastName);
//        registerPage.enterToLastNameTextbox(lastName);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 03: Enter to Email Address textboxwith value is " + emailAddress);
//        registerPage.enterToEmailTextbox(emailAddress);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 04: Enter to Password textboxwith value is " + password);
//        registerPage.enterToPasswordTextbox(password);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 05: Enter to Confirm Password textboxwith value is " + password);
//        registerPage.enterToConfirmPasswordTextbox(password);
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 06: Click to Register button");
//        registerPage.clickToRegisterButton();
//
//        ExtentManager.getTest().log(LogStatus.INFO,"Register - Step 07: Verify success message is displayed");
//        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        closeBrowser();
//    }
//}
