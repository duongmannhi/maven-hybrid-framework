package com.jquery.table;

import commons.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

import java.util.ArrayList;
import java.util.List;


public class Level_13_Handle_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;
    List<String> allValueUI = new ArrayList<String>();

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);

        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void TC_01_Search() {
        // Search dữ liệu trong 1 Table (trên Header)
        homePage.inputToColumnTextboxByName("Females", "384187");
        homePage.sleepInSeconds(2);

        homePage.inputToColumnTextboxByName("Males", "407124");
        homePage.sleepInSeconds(2);

        homePage.inputToColumnTextboxByName("Country", "Afghanistan");
        homePage.sleepInSeconds(2);

        homePage.inputToColumnTextboxByName("Total", "791312");
        homePage.sleepInSeconds(2);
    }

    @Test
    public void TC_02_Paging() {
        // Click to any page
        homePage.clickToPageByNumber("10");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("10"));

        homePage.clickToPageByNumber("4");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("4"));

        homePage.clickToPageByNumber("16");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("16"));

        homePage.clickToPageByNumber("1");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("1"));
    }

    @Test
    public void TC_03_Displayed() {
        // Verify for any row
        Assert.assertTrue(homePage.isRowValuesDisplayed("384187", "Afghanistan", "407124", "791312"));

        Assert.assertTrue(homePage.isRowValuesDisplayed("276880", "Angola", "276472", "553353"));

        Assert.assertTrue(homePage.isRowValuesDisplayed("338282", "Argentina", "349238", "687522"));
    }

    @Test
    public void TC_04_Icon_Button_Checkbox() {
        // Click vào bất kì 1 cái icon/ button/ checkbox/... của 1 row nào đó
        // Tìm được 1 key là duy nhất của row đó so với các row khác
        homePage.clickToRowActionByCountryName("Afghanistan", "remove");
        homePage.clickToRowActionByCountryName("AFRICA", "remove");
        homePage.clickToRowActionByCountryName("Albania", "remove");
        homePage.clickToRowActionByCountryName("Algeria", "remove");
        homePage.clickToRowActionByCountryName("Angola", "remove");

        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Afghanistan", "edit");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("AFRICA", "edit");
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_05_Get_All_Row_Values() {
        allValueUI = homePage.getAllPageValuesByColumnName("Country");
        homePage.getAllPageValuesByColumnName("Total");
    }

    @Test
    public void TC_06_Action_By_Index() {
        homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");

        // Nhập vào textbox tại cột Contact Person dòng thứ 2
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Oliver Kahl");
        homePage.enterToTextboxByColumnNameAndRowIndex("Company", "1", "Bayer Munich");

        // Select dữ liệu tại cột Country dòng thứ 3
        homePage.selectDropdownByColumnNameAndRowIndex("Country", "3", "United Kingdom");
        homePage.selectDropdownByColumnNameAndRowIndex("Country", "1", "Japan");

        // Click vào checkbox tại cột NPO? dòng thứ 1
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "2");
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "1");
        homePage.clickToCheckboxByColumnNameAndRowIndex("NPO?", "3");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
