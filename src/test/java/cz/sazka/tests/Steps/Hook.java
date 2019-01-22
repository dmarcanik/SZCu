package cz.sazka.tests.Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hook {


    private static boolean browseropened;
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webdriver;
    private static ConfigFileReader configFileReader;
    private static boolean dev = false;


    public static WebDriver getDriver() {
        return webdriver;
    }

    /**
     * This method run before every test and open or not open browser.
     * @param scenario is passed from cucumber to be able to work with particular scenario.
     * @throws IOException when is not possible to read browser path from configuration file.
     */
    @Before
    public void initializeTest(Scenario scenario) throws IOException {
        log.info("Test " + scenario.getName() + " Started");

        if (!browseropened) {
            initBrowser();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        webdriver.close();
                        killBrowserProcess();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    /**
     * Method tearDownTest is performed after ever test, taking screenshot and saving with log to Logs file.
     * @param scenario is passed to be able to read scenarion name for logging purposes.
     */
    @After
    public void tearDownTest(Scenario scenario) throws Throwable {

        if (scenario.isFailed()){

            File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

            try {
                String pathname = "logs/screenshots/" + scenario.getName() + "_" + timesStamp() + ".png";
                FileUtils.copyFile(scrFile, new File(pathname));
                log.error("TEST " + scenario.getName() + " FAILED, screenshot taken to " + pathname);

                //When scenarion failed it takes screenshot, logs an error and close browser.

            } catch (IOException e) {
                log.error("ERROR", e);

            }


        } else {
            log.info("Test " + scenario.getName() + " PASSED");
        }

    }

    private void initBrowser() throws IOException {
        configFileReader = new ConfigFileReader();
        String driver = configFileReader.getDriver();
        String os = configFileReader.getOS();
        String driverPath = "driver/geckodriver";


        switch (driver) {

            case "firefox":
                if (os.equals("mac")) {
                    driverPath = "driver/geckodriver";
                } else if(os.equals("windows")) {
                    driverPath = "driver/geckodriver.exe";
                }
                System.setProperty("webdriver.gecko.driver", driverPath);
                webdriver = new FirefoxDriver();
                break;
            case "chrome":
                if (os.equals("mac")) {
                    driverPath = "driver/chromedriver";
                } else if(os.equals("windows")) {
                    driverPath = "driver/chromedriver.exe";
                }
                System.setProperty("webdriver.chrome.driver", driverPath);
                webdriver = new ChromeDriver();
                break;
        }

//        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
/*

        if (dev) {
            FirefoxOptions options = new FirefoxOptions();
            desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxBinPath(options));
            Proxy proxy = new Proxy();
            proxy.setProxyAutoconfigUrl("https://pac.sazka.cz/proxy.pac");
            desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setProxy(proxy));
            webdriver = new FirefoxDriver(options);
        } else {
            webdriver = new FirefoxDriver();
*/

        //      }

        webdriver.manage().window().maximize();
        browseropened = true;
    }

    private void killBrowserProcess() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
    }

    private FirefoxOptions getFirefoxBinPath(FirefoxOptions options) {
        File pathToBinary = new File("C:\\Users\\Marcanik\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathToBinary);
        return options.setBinary(firefoxBinary);

    }


    private String timesStamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }

}
