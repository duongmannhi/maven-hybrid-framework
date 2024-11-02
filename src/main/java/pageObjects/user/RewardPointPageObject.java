package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends MyAccountSidebarPageObject {
    WebDriver driver;

    public RewardPointPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
