package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseActions {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, AddEmployeePageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePageUI.LASTNAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
    }
}
