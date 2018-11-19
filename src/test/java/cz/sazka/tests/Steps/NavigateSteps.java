package cz.sazka.tests.Steps;


import cucumber.api.java.en.When;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NavigateSteps {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    /**
     * This method navigates to certain part of web.
     * @param section defines section which should be navigated to.
     * @param game section game (e.g. Eurojacktpot, Sportka) section which should be navigated to.
     */
    @When("^I Navigate to section \"([^\"]*)\"(?:and game \"([^\"]*)\")$")
    public static void navigateTo(String section, String game) throws Throwable {

        try {
            String url = webDriver.getCurrentUrl();
            url = java.net.URLDecoder.decode(url, "UTF-8");
            String newEndpoint = url.replaceAll("(?<=cz).*$", "/" + section + "/" + game);
            webDriver.navigate().to(newEndpoint);
            ElementHandler.waitPageToBeLoaded();
        } catch (NoSuchElementException e) {
            log.error("ERROR: \n", e);
            throw e;
        }
    }
    @When("^I Navigate to Moje sázky$")
    public static void navigateToMojeSazky() throws Throwable {
        new ClickStep().click(Helpers.locatorMap("myWagers"));
        ElementHandler.waitElementLoaded(Helpers.locatorMap("wagerList"));
    }



}
