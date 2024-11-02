package pageObject.factory;

import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends BasePageFactory {
    WebDriver driver;

    @FindBy(id = "FirstName")
    private WebElement firstNameTextbox;

    @FindBy(id = "LastName")
    private WebElement lastNameTextbox;

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "Password")
    private WebElement passwordTextbox;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextbox;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@data-valmsg-for='FirstName']")
    private WebElement firstNameErrorMsg;

    @FindBy(xpath = "//span[@data-valmsg-for='LastName']")
    private WebElement lastNameErrorMsg;

    @FindBy(xpath = "//span[@data-valmsg-for='Email']")
    private WebElement emailErrorMsg;

    @FindBy(xpath = "//span[@data-valmsg-for='Password']")
    private WebElement passowrdErrorMsg;

    @FindBy(xpath = "//span[@data-valmsg-for='ConfirmPassword']")
    private WebElement confirmPasswordErrorMsg;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@class='header-logo']//img")
    private WebElement nopCommerceLogo;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementVisible(driver, firstNameErrorMsg);
        return getElementText(driver, firstNameErrorMsg);
    }

    public String getLastNameErrorMessageText() {
        waitForElementVisible(driver, lastNameErrorMsg);
        return getElementText(driver, lastNameErrorMsg);
    }

    public String getEmailErrorMessageText() {
        waitForElementVisible(driver, emailErrorMsg);
        return getElementText(driver, emailErrorMsg);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementVisible(driver, confirmPasswordErrorMsg);
        return getElementText(driver, confirmPasswordErrorMsg);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, nopCommerceLogo);
        clickToElement(driver, nopCommerceLogo);
    }

    public void enterToFirtNameTextbox(String firstNameValue) {
        waitForElementVisible(driver, firstNameTextbox);
        sendkeyToElement(driver, firstNameTextbox, firstNameValue);
    }

    public void enterToLastNameTextbox(String lastNameValue) {
        waitForElementVisible(driver, lastNameTextbox);
        sendkeyToElement(driver, lastNameTextbox, lastNameValue);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, emailTextbox);
        sendkeyToElement(driver, emailTextbox, emailAddress);
    }

    public void enterToPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver, passwordTextbox);
        sendkeyToElement(driver, passwordTextbox, passwordValue);
    }

    public void enterToConfirmPasswordTextbox(String passwordValue) {
        waitForElementVisible(driver, confirmPasswordTextbox);
        sendkeyToElement(driver, confirmPasswordTextbox, passwordValue);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementVisible(driver, successMessage);
        return getElementText(driver, successMessage);
    }
}
