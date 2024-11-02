package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class OrderPageObject extends MyAccountSidebarPageObject {
    WebDriver driver;

    public OrderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
