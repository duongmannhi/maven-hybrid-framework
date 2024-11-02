package pageObjects.orangehrm;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.BaseActionsPageUI;

public class BaseActions extends BasePage {
    private WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSpinnerIconInvisible() {
        waitForListElementInvisible(driver, BaseActionsPageUI.SPINNER_ICON);
    }

    public boolean isSuccessMessageDisplayed(String messageContent) {
        waitForElementVisible(driver, BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, messageContent);
        return isElementDisplayed(driver, BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, messageContent);
    }

    public boolean isValueDisplayedAtColumnName(String columnName, String rowIndex, String rowValue) {
        int columnIndex = getListElementSize(driver, BaseActionsPageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName) + 1;
        return isElementDisplayed(driver, BaseActionsPageUI.DYNAMIC_ROW_VALUE_BY_COLUMN_INDEX_ROW_INDEX, rowIndex, String.valueOf(columnIndex), rowValue);
    }

    public void clickToMaleRadioButtonByLabelName(String radioLabelName) {
        clickToElementByJS(driver, BaseActionsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, radioLabelName);
    }

    public void clickToSmokerCheckboxByLabelName(String checkboxLabelName) {
        if(!isElementSelected(driver, BaseActionsPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName)) {
            clickToElementByJS(driver, BaseActionsPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, checkboxLabelName);
        }
    }

    public boolean isRadioButtonSelectedByLabelName(String genderStatus) {
        return isElementSelected(driver, BaseActionsPageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_NAME, genderStatus);
    }

    public boolean isCheckboxSelectedByLabelName(String smokerStatus) {
        return isElementSelected(driver, BaseActionsPageUI.DYNAMIC_CHECKBOX_BY_LABEL_NAME, smokerStatus);
    }
}
