package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.PropertiesConfig;

import java.lang.reflect.Method;

public class Level_31_Environment_03_Java_Properties extends BaseTest {
    private WebDriver driver;
    private PropertiesConfig propertiesConfig;

    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        propertiesConfig = PropertiesConfig.getProperties(serverName);
        driver = getBrowserDriverV2(browserName, propertiesConfig.getApplicationUrl());
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