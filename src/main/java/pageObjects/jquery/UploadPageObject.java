package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUI;

import java.util.List;

public class UploadPageObject extends BasePage {
    WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
    }

    public void clickStartButtonOnEachFile() {
        List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.MULTIPLE_START_BUTTON);
        for (WebElement button : startButtons) {
            waitForElementClickable(driver, button);
            clickToElement(button);
            sleepInSeconds(2);
        }
    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
    }

    public boolean isLoadingIconAtMainContentDisappear() {
        return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_CONTENT);
    }

    public boolean isLoadingIconAtMainUploadDisappear() {
        return waitForElementInvisible(driver, UploadPageUI.SPIN_BORDER_ICON_AT_MAIN_UPLOAD);
    }

    public boolean isMultipleProgressBarIconDisappear() {
        return waitForListElementInvisible(driver, UploadPageUI.MULTIPLE_PROGRESSBAR_ICON);
    }

    public boolean isSuccessMessageDisplayed(String successMessage) {
        waitForElementVisible(driver, UploadPageUI.UPLOAD_SUCCESS_MESSAGE, successMessage);
        return isElementDisplayed(driver, UploadPageUI.UPLOAD_SUCCESS_MESSAGE, successMessage);
    }

    public void clickToSuccessLink() {
        waitForElementClickable(driver, UploadPageUI.UPLOAD_SUCCESS_LINK);
        clickToElement(driver, UploadPageUI.UPLOAD_SUCCESS_LINK);
    }

    public boolean isContentTableDisplayed() {
        waitForElementVisible(driver, UploadPageUI.CONTENT_TABLE);
        return isElementDisplayed(driver, UploadPageUI.CONTENT_TABLE);
    }

    public boolean isDownloadButtonDisplayed(String fileName) {
        waitForElementVisible(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.DOWNLOAD_BUTTON_BY_FILE_NAME, fileName);
    }

    public boolean isPlayButtonDisplayed(String fileName) {
        waitForElementVisible(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, UploadPageUI.PLAY_BUTTON_BY_FILE_NAME, fileName);
    }
}
