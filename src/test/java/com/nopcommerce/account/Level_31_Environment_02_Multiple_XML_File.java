package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Level_31_Environment_02_Multiple_XML_File extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
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