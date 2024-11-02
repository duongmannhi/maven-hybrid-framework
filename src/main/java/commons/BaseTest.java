package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseTest {
    protected final Logger log;
    private WebDriver driver;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            case CHROME:
                driver = new ChromeDriver();
                break;

            case EDGE:
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        driver.get("https://demo.nopcommerce.com/");

        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;

            case CHROME:
                driver = new ChromeDriver();
                break;

            case EDGE:
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserDriverHeadlessOrExtension(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        Path path = null;
        File extensionFilePath = null;

        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSION + "wappalyzer.xpi");
                FirefoxDriver ffDriver = (FirefoxDriver) driver;
                ffDriver.installExtension(xpiPath);
                driver = ffDriver;
                break;

            case CHROME:
                ChromeOptions chOptions = new ChromeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSION + "Wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                chOptions.addExtensions(extensionFilePath);
                driver = new ChromeDriver(chOptions);
                break;

            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSION + "wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                edgeOptions.addExtensions(extensionFilePath);
                driver = new EdgeDriver(edgeOptions);
                break;

            case CHROME_HEADLESS:
                ChromeOptions chOption = new ChromeOptions();
                chOption.addArguments("--headless");
                chOption.addArguments("window-size=1920x1080");
                driver = new ChromeDriver(chOption);
                break;

            case FIREFOX_HEADLESS:
                FirefoxOptions ffOption = new FirefoxOptions();
                ffOption.addArguments("--headless");
                ffOption.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(ffOption);
                break;

            case EDGE_HEADLESS:
                EdgeOptions egOption = new EdgeOptions();
                egOption.addArguments("--headless");
                egOption.addArguments("window-size=1920x1080");
                driver = new EdgeDriver(egOption);
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserDriverLog(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case FIREFOX:
                // Log to Console
//                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogOutput(System.out).build();
//                driver = new FirefoxDriver(ffService);

                // Log Level
                System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOG + "FirefoxLevel.log");
                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogLevel(FirefoxDriverLogLevel.DEBUG).build();
                driver = new FirefoxDriver(ffService);

//                // Log to File
//                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOG + "FirefoxDriver.log")).build();
//                driver = new FirefoxDriver(ffService);
                break;

            case CHROME:
                // Log to Console
//                ChromeDriverService chService = new ChromeDriverService.Builder().withLogOutput(System.out).build();
//                driver = new ChromeDriver(chService);

                // Log Level
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOG + "ChromeLevel.log");
                ChromeDriverService chService = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();
                driver = new ChromeDriver(chService);

//                // Log to File
//                ChromeDriverService chService = new ChromeDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOG + "ChromeDriver.log")).build();
//                driver = new ChromeDriver(chService);
                break;

            case EDGE:
                // Log to Console
//                EdgeDriverService edgeService = new EdgeDriverService.Builder().withLogOutput(System.out).build();
//                driver = new EdgeDriver(edgeService);

                // Log Level
                System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOG + "EdgeLevel.log");
                EdgeDriverService edgeService = new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();
                driver = new EdgeDriver(edgeService);

//                // Log to File
//                EdgeDriverService egService = new EdgeDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOG + "EdgeDriver.log")).build();
//                driver = new EdgeDriver(egService);
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserDriverCapabilities(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        switch (browser) {
            case FIREFOX:
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--private");
                ffOptions.addPreference("intl.accept_languages", "vi-vn,vi");
                ffOptions.addPreference("browser.download.folderList", 2);
                ffOptions.addPreference("browser.download.dir", GlobalConstants.DOWNLOAD_PATH);
                ffOptions.addPreference("browser.download.useDownloadDir", true);
                ffOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
                        "multipart/x-zip,application/zip,application/x-zip-compressed," +
                        "application/x-compressed,application/msword,application/csv," +
                        "text/csv,image/png,image/jpeg,application/pdf,text/html,text/plain," +
                        "application/excel,application/vnd.ms-excel,application/x-excel," +
                        "application/x-msexcel,application/octet-stream");
                ffOptions.addPreference("pdfjs.disabled", true);
                driver = new FirefoxDriver(ffOptions);
                break;

            case CHROME:
                Map<String, Object> chPrefs = new HashMap<String, Object>();
                chPrefs.put("profile.default_content_setting_values.notifications", 2);
                chPrefs.put("credentials_enable_service", false);
                chPrefs.put("profile.password_manager_enabled", false);
                chPrefs.put("autofill.profile_enabled", false);
                chPrefs.put("autofill.credit_card_enable", false);

                chPrefs.put("profile.default_content_settings.popups", 0);
                chPrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

                ChromeOptions chOptions = new ChromeOptions();
                //chOptions.addArguments("--incognito");
                chOptions.addArguments("user-data-dir= C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome\\User Data");
                chOptions.addArguments("profile-directory=Profile 6");
                chOptions.addArguments("--lang=vi");
                chOptions.addArguments("--disable-notifications");
                chOptions.addArguments("--disable-geolocation");

                chOptions.setExperimentalOption("useAutomationExtension", false);
                chOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

                chOptions.setExperimentalOption("prefs", chPrefs);
                driver = new ChromeDriver(chOptions);
                break;

            case EDGE:
                Map<String, Object> egPrefs = new HashMap<String, Object>();
                egPrefs.put("profile.default_content_setting_values.notifications", 2);
                egPrefs.put("credentials_enable_service", false);
                egPrefs.put("profile.password_manager_enabled", false);
                egPrefs.put("autofill.profile_enabled", false);
                egPrefs.put("autofill.credit_card_enable", false);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                edgeOptions.addArguments("--lang=vi");
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-geolocation");

                edgeOptions.setExperimentalOption("useAutomationExtension", false);
                edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

                edgeOptions.setExperimentalOption("prefs", egPrefs);
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));

        driver.get(url);

        return driver;
    }

    protected String getEmailRandom() {
        return "john" + new Random().nextInt(99999) + "@kennedy.us";
    }

    protected void closeBrowser() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME;
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("-------------------- PASSED --------------------");
        } catch (Throwable e) {
            log.info("-------------------- FAILED --------------------");
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("-------------------- PASSED --------------------");
        } catch (Throwable e) {
            log.info("-------------------- FAILED --------------------");
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("-------------------- PASSED --------------------");
        } catch (Throwable e) {
            log.info("-------------------- FAILED --------------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
    }
    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
