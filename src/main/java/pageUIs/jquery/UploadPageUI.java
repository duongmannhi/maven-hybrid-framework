package pageUIs.jquery;

public class UploadPageUI {
    public static final String FILE_LOADED_BY_NAME = "xpath=//p[@class='name' and text()='%s']";
    public static final String MULTIPLE_START_BUTTON = "css=table button.start";
    public static final String FILE_UPLOADED_BY_NAME = "xpath=//p[@class='name']/a[text()='%s']";
    public static final String SPIN_BORDER_ICON_AT_MAIN_CONTENT = "css=div#mainContent>div>div>div.spinner-border";
    public static final String SPIN_BORDER_ICON_AT_MAIN_UPLOAD = "css=div.mainUploadInitInfo>div>div.spinner-border";
    public static final String MULTIPLE_PROGRESSBAR_ICON = "css=div.progress-bar";
    public static final String UPLOAD_SUCCESS_MESSAGE = "xpath=//div[contains(@class,'mainUploadSuccess')]//div[text()='%s']";
    public static final String UPLOAD_SUCCESS_LINK = "css=div.mainUploadSuccessLink a.ajaxLink";
    public static final String CONTENT_TABLE = "css=div#filesContentTable";
    public static final String DOWNLOAD_BUTTON_BY_FILE_NAME = "xpath=//span[text()='%s']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Download']";
    public static final String PLAY_BUTTON_BY_FILE_NAME = "xpath=//span[text()='%s']/ancestor::div[contains(@class,'text-md-start')]/following-sibling::div//span[text()='Play']";
}
