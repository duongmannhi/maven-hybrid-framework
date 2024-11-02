package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.user.HomePageObject;
import pageUIs.user.BaseElementUI;

public class BaseElement extends BasePage {
    WebDriver driver;
    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
        return PageGeneratorManager.getHomePage(driver);
    }

    public void clickToHeaderLinkByName(String pageName) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
        clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
    }

    public void clickToButtonByText(String text) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, text);
        clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, text);
    }

    public String getTextboxErrorMessageByID(String errorMessageID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERR_MSG_BY_ID, errorMessageID);
        return getElementText(driver, BaseElementUI.DYNAMIC_TEXTBOX_ERR_MSG_BY_ID, errorMessageID);
    }

    public void enterToTextboxByID(String textboxID, String valueToSendkey) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSendkey, textboxID);
    }

    public String getTextboxAttributeByID(String textboxID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
    }
}
