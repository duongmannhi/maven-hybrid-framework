package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static UploadPageObject getUpLoadPage(WebDriver driver) {
        return new UploadPageObject(driver);
    }
}
