package cz.sazka.tests.Steps_old.PropSteps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.PrinterGroupHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.UnsupportedEncodingException;

public class PrinterGroupPropSteps {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    @And("^I open printer group \"([^\"]*)\"$")
    public void iOpenGroup(String groupName) {
        try {
            String groupId = PrinterGroupHandler.getPrinterGroupId(groupName);
            String url = webDriver.getCurrentUrl();
            url = java.net.URLDecoder.decode(url, "UTF-8");
            String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + Helpers.getPrinterGroupHash(groupId));
            webDriver.navigate().to(newEndpoint);
            ElementHandler.waitAjaxComplete();
        }catch (NoSuchElementException |UnsupportedEncodingException e){
            log.error("ERROR: \n");
        }
    }

    @Then("^Printer Group \"([^\"]*)\" is inside \"([^\"]*)\"$")
    public void printerGroupIsInside(String subGroup, String mainGroup) throws Throwable {
        if (!mainGroup.equals("All printers")){
            String subgroupParent = PrinterGroupHandler.getPrinterGroupParentId(subGroup);
            String mainGroupId = PrinterGroupHandler.getPrinterGroupId(mainGroup);
            Assert.assertEquals(mainGroupId,subgroupParent);

        }


    }

    @Then("^Printer Group \"([^\"]*)\" is in database$")
    public void printerGroupIsInDatabase(String group) throws Throwable {
        Assert.assertTrue(PrinterGroupHandler.isPrinterGroupContained(group));

    }
}
