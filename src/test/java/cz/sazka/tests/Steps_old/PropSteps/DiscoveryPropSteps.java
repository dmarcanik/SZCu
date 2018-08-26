package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.DiscoveryHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.UnsupportedEncodingException;

public class DiscoveryPropSteps {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    @And("^Open tab \"([^\"]*)\" of discovery with name \"([^\"]*)\"$")
    public void openPrinterDiscovery(String tab, String target) {
        try {
            String discoveryId = DiscoveryHandler.getDiscoveryId(target);
            String url = webDriver.getCurrentUrl();
            url = java.net.URLDecoder.decode(url, "UTF-8");
            String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + Helpers.getDiscoveryHAsh(discoveryId, tab));
            webDriver.navigate().to(newEndpoint);
            ElementHandler.waitAjaxComplete();
        } catch (NoSuchElementException | UnsupportedEncodingException e) {
            log.error("ERROR: \n ", e);
        }

    }

    @Then("^discovery with name \"([^\"]*)\" is not in database$")
    public void discoveryWithNameisNot(String target) {
        try {
            Assert.assertFalse(DiscoveryHandler.isDiscoveryContained(target));
        }catch (AssertionError e){
            log.error("ERROR: \n ", e);
        }

    }
}
