package com.nopcommerce.account;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;

import java.lang.reflect.Method;

public class Level_36_AWS extends BaseTest {
    private WebDriver driver;
    private EnvironmentConfig enviromentConfig;
    private String browserName, osName;

    @Parameters({"server", "os", "browser", "browser_version"})
    @BeforeClass
    public void beforeClass(String serverName, String osName, String browserName, String browserVersion) {
        ConfigFactory.setProperty("server", serverName);
        enviromentConfig = ConfigFactory.create(EnvironmentConfig.class);

        this.browserName = browserName;
        this.osName = osName;

        System.out.println(enviromentConfig.appUrl());
        System.out.println(enviromentConfig.appUser());
        System.out.println(enviromentConfig.appPassword());

        driver = getBrowserDriverAWSDeviceFarm(enviromentConfig.appUrl(), osName, browserName, browserVersion);
    }

    @Test
    public void Employee_01_Add_New(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run with "  + browserName.toUpperCase() + " on " + osName.toUpperCase(), "Employee_01_Add_New");
    }

    @Test
    public void Employee_02_Personal_Details(Method method) {
        ExtentTestManager.startTest(method.getName() + " - Run with "  + browserName.toUpperCase() + " on " + osName.toUpperCase(), "Employee_02_Personal_Details");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}