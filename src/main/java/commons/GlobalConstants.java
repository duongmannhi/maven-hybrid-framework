package commons;

import java.io.File;

public class GlobalConstants {
    public static final String DEV_USER_URL = "https://demo.nopcommerce.com";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASSWORD = "admin";

//    public static final String ADMIN_ORANGE_HRM_USERNAME = "automationfc";
//    public static final String ADMIN_ORANGE_HRM_PASSWORD = "T3st1ng285@%*";

    public static final String ADMIN_ORANGE_HRM_USERNAME = "Admin";
    public static final String ADMIN_ORANGE_HRM_PASSWORD = "admin123";

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String ULOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String BROWSER_EXTENSION = RELATIVE_PROJECT_PATH + File.separator + "browserExtension" + File.separator;
    public static final String BROWSER_LOG = RELATIVE_PROJECT_PATH + File.separator + "browserLogs" + File.separator;
    public static final String REPORTNG_IMAGE_PATH = RELATIVE_PROJECT_PATH + File.separator+ "reportNGImage" + File.separator;
}
