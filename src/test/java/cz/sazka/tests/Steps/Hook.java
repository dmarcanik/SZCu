package cz.sazka.tests.Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
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

    public static WebDriver getDriver() {

        return webdriver;
    }


    @Before
    public void initializeTest(Scenario scenario) throws IOException {
        log.info("Test " + scenario.getName() + " Started");
        if (!browseropened) {
            initBrowser();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        webdriver.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }

    @After
    public void tearDownTest(Scenario scenario) throws Throwable {

        if (scenario.isFailed()) {

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

        File pathToBinary = new File("C:\\Users\\Marcanik\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath());
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathToBinary);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        Proxy proxy = new Proxy();
        proxy.setProxyAutoconfigUrl("https://pac.sazka.cz/proxy.pac");
        desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,options.setProxy(proxy));
        webdriver = new FirefoxDriver(options);
        webdriver.manage().window().maximize();
        browseropened = true;
    }



    private String timesStamp() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }

}
