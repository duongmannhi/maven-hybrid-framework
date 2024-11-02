package pageUIs.orangehrm;

public class PersonalDetailsPageUI {
    public static final String FIRSTNAME_TEXTBOX = "css=input[name='firstName']";
    public static final String LASTNAME_TEXTBOX = "css=input[name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
    public static final String PERSONAL_DETAILS_PAGE_HEADER = "xpath=//h6[text()='Personal Details']";

    public static final String NICKNAME_TEXTBOX = "xpath=//label[text()='Nickname']/parent::div/following-sibling::div/input";
    public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String DRIVER_EXPIRY_DATE_PICKDER = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String SOCIAL_SECURITY_NUMBER_TEXTBOX = "xpath=//label[text()='SSN Number']/parent::div/following-sibling::div/input";
    public static final String SOCIAL_INSURANCE_NUMBER_TEXTBOX = "xpath=//label[text()='SIN Number']/parent::div/following-sibling::div/input";

    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_DROPDOWN_CHILD_ITEM = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String NATIONALITY_DROPDOWN_SELECTED_TEXT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";

    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD_ITEM = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
    public static final String MARITAL_STATUS_DROPDOWN_SELECTED_TEXT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String DATE_OF_BIRTH_PICKER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";

    public static final String SAVE_BUTTON_AT_PERSONAL_DETAILS = "xpath=//div[contains(@class,'orangehrm-horizontal-padding')]//button[contains(string(),'Save')]";
}
