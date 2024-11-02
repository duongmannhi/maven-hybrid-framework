package com.jquery.upload;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;


public class Level_14_Upload_File extends BaseTest {
    WebDriver driver;
    UploadPageObject uploadPage;

    String food1 = "food1.jpg";
    String food2 = "food2.jpg";
    String food3 = "food3.jpg";
    String[] fileNames = {food1, food2, food3};

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        uploadPage = PageGeneratorManager.getUpLoadPage(driver);
    }

    @Test
    public void TC_01_Upload_Single_File() {
        uploadPage.uploadMultipleFiles(driver, food1);
        uploadPage.sleepInSeconds(2);

        uploadPage.uploadMultipleFiles(driver, food2);
        uploadPage.sleepInSeconds(2);

        uploadPage.uploadMultipleFiles(driver, food3);
        uploadPage.sleepInSeconds(2);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(food1));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(food2));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(food3));

        uploadPage.clickStartButtonOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(food1));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(food2));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(food3));
    }

    @Test
    public void TC_02_Upload_Multiple_File() {
        uploadPage.refreshCurrentPage(driver);
        uploadPage.uploadMultipleFiles(driver, fileNames);

        Assert.assertTrue(uploadPage.isFileLoadedSuccess(food1));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(food2));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(food3));

        uploadPage.clickStartButtonOnEachFile();

        Assert.assertTrue(uploadPage.isFileUploadedSuccess(food1));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(food2));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(food3));
    }

    @Test
    public void TC_03_Upload_GoFile() {
        uploadPage.openPageUrl(driver, "https://gofile.io/uploadFiles");

        Assert.assertTrue(uploadPage.isLoadingIconAtMainContentDisappear());

        uploadPage.uploadMultipleFiles(driver, fileNames);

        Assert.assertTrue(uploadPage.isLoadingIconAtMainUploadDisappear());

        Assert.assertTrue(uploadPage.isMultipleProgressBarIconDisappear());

        Assert.assertTrue(uploadPage.isSuccessMessageDisplayed("Your files have been successfully uploaded"));

        uploadPage.clickToSuccessLink();

        Assert.assertTrue(uploadPage.isContentTableDisplayed());

        Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(food1));
        Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(food2));
        Assert.assertTrue(uploadPage.isDownloadButtonDisplayed(food3));

        Assert.assertTrue(uploadPage.isPlayButtonDisplayed(food1));
        Assert.assertTrue(uploadPage.isPlayButtonDisplayed(food2));
        Assert.assertTrue(uploadPage.isPlayButtonDisplayed(food3));
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
