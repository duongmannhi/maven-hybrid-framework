package com.nopcommerce.account;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvironmentConfig;

import java.lang.reflect.Method;

public class Level_32_BrowserStack extends BaseTest {
    private WebDriver driver;
    private EnvironmentConfig enviromentConfig;

    @Parameters({"server", "browser"})
    @BeforeClass
    public void beforeClass(String serverName, String browserName) {
        ConfigFactory.setProperty("server", serverName);
        enviromentConfig = ConfigFactory.create(EnvironmentConfig.class);

//        System.out.println(enviromentConfig.appUrl());
//        System.out.println(enviromentConfig.appUser());
//        System.out.println(enviromentConfig.appPassword());

        driver = getBrowserDriver(browserName, enviromentConfig.appUrl());
    }

    @Test
    public void Employee_01_Add_New(Method method) {

    }

    @Test
    public void Employee_02_Personal_Details(Method method) {

    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }

}