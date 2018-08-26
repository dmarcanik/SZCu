package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.PrinterHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrinterPropSteps {

    private static final int CARD = 512;
    private static final int PIN = 256;
    private static final int USERNAMEANDPASSWORD = 1024;
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    @And("^search for printer with IP \"([^\"]*)\" in printer search$")
    public void searchForPrinterWithIPInPrinterSearch(String target) throws Throwable {
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-ctrltype=\"Web_Printers_PrintersGrid\"]")));
        WebElement getGridElement = webDriver.findElement(By.xpath("//*[@data-ctrltype=\"Web_Printers_PrintersGrid\"]"));
        WebElement searchElement = getGridElement.findElement(By.cssSelector("[data-ctrltype=\"Wsf_Forms_CtrlSearchBox\"]")).findElement(By.cssSelector("[type=\"text\"]"));
        searchElement.sendKeys(target);
        searchElement.sendKeys(Keys.ENTER);
        ElementHandler.waitAjaxComplete();

    }
    @And("^select printer with IP \"([^\"]*)\" in the printers grid$")
    public void selectPrinterWithZipInThePrintersGrid(String target) throws Throwable {
        WebElement gridElemenet = webDriver.findElement(By.xpath("//*[@class=\"wsfCtrl Wsf_Ctrls_DataGrid_CtrlDataGrid wsfControlBorderBottom\"]"));
        String bodyName = gridElemenet.getAttribute("id");
        String printerId = PrinterHandler.getPrinterId(target);
        WebElement newelement = webDriver.findElement(By.cssSelector("[id=\"" + bodyName + "." + printerId + "\"]")).findElement(By.cssSelector("[class]"));
        newelement.click();

    }

    @And("^Open tab \"([^\"]*)\" of printer with IP \"([^\"]*)\"$")
    public void openTabOfPrinterWithIP(String tab, String printer) throws Throwable {
        String printerId = PrinterHandler.getPrinterId(printer);
        String url = webDriver.getCurrentUrl();
        url = java.net.URLDecoder.decode(url, "UTF-8");
        String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + Helpers.getPrinterHash(printerId, tab));
        webDriver.navigate().to(newEndpoint);
        ElementHandler.waitAjaxComplete();


    }
    @And("^open \"(allprinters|active|usersession|withissue|local|unclassified|deleted)\" printer search filter$")
    public void printerSearchFilter(String filter) throws Throwable {
        String url = webDriver.getCurrentUrl();
        String filterHash = "";

        switch (filter) {
            case "allprinters":
                filterHash = Helpers.getPrinterFilterHash("-16");
                break;
            case "active":
                filterHash = Helpers.getPrinterFilterHash("-4");
                break;
            case "usersession":
                filterHash = Helpers.getPrinterFilterHash("-6");
                break;
            case "withissue":
                filterHash = Helpers.getPrinterFilterHash("-2");
                break;
            case "local":
                filterHash = Helpers.getPrinterFilterHash("-5");
                break;
            case "unclassified":
                filterHash = Helpers.getPrinterFilterHash("17");
                break;
            case "deleted":
                filterHash = Helpers.getPrinterFilterHash("-3");
                break;


        }
        url = java.net.URLDecoder.decode(url, "UTF-8");
        String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + filterHash);
        webDriver.navigate().to(newEndpoint);
        ElementHandler.waitAjaxComplete();
    }


    @Then("^printer with IP \"([^\"]*)\" has name \"([^\"]*)\"$")
    public void printerWithIpHasName(String printerIp, String name) throws Throwable {
        Assert.assertEquals(name,PrinterHandler.getPrinterName(printerIp));

    }

    @Then("^printer with IP \"([^\"]*)\" has fax module \"(activated|deactivated)\"$")
    public void printerWithIPHasFaxModule(String printer, String status) throws Throwable {
        Boolean expected;
        expected = status.equals("activated");
        Assert.assertEquals(expected, PrinterHandler.isPrinterFaxActive(printer));

    }

    @Then("^printer with IP \"([^\"]*)\" has coveradge accounting \"(activated|deactivated)\"$")
    public void printerWithIPHasCoveradgeAccounting(String printer, String status) throws Throwable {
        Boolean expected;
        expected = status.equals("activated");
        Assert.assertEquals(expected, PrinterHandler.isPrinterCoveradgeActive(printer));

    }

    @Then("^printer with IP \"([^\"]*)\" is \"(activated|deactivated|monitoring|usersession|deleted)\"$")
    public void printerWithIPIs(String printer, String status) throws Throwable {
        switch (status) {

            case "activated":
                Assert.assertEquals(2, PrinterHandler.isPrinterActive(printer));
                break;
            case "deactivated":
                Assert.assertEquals(1, PrinterHandler.isPrinterActive(printer));
                break;
            case "monitoring":
                Assert.assertEquals(4, PrinterHandler.isPrinterActive(printer));
                break;
            case "usersession":
                Assert.assertEquals(5, PrinterHandler.isPrinterActive(printer));
                break;
            case "deleted":
                Assert.assertEquals(255, PrinterHandler.isPrinterActive(printer));
                break;

        }


    }

    @Then("^printer with IP \"([^\"]*)\" has terminal type \"(none|android|embedded|embeddedlite|felica|hw11|terminalpro)\"$")
    public void printerWithIPHasTerminalType(String printer, String status) throws Throwable {
        switch (status) {
            case "none":
                Assert.assertEquals(1, PrinterHandler.getTerminalType(printer));
                break;
            case "android":
                Assert.assertEquals(128, PrinterHandler.getTerminalType(printer));
                break;
            case "embedded":
                Assert.assertEquals(2, PrinterHandler.getTerminalType(printer));
                break;
            case "embeddedlite":
                Assert.assertEquals(16, PrinterHandler.getTerminalType(printer));
                break;
            case "felica":
                Assert.assertEquals(64, PrinterHandler.getTerminalType(printer));
                break;
            case "hw11":
                Assert.assertEquals(32, PrinterHandler.getTerminalType(printer));
                break;
            case "terminalpro":
                Assert.assertEquals(256, PrinterHandler.getTerminalType(printer));
                break;
        }


    }

    @Then("^printer with IP \"([^\"]*)\" has set username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void HasSetUsernameAndPassword(String printer, String username, String password) throws Throwable {
        Assert.assertEquals(username,PrinterHandler.getPrinterAdminUsername(printer));
        Assert.assertEquals(password, PrinterHandler.getPrinterAdminPass(printer));


    }

    @Then("^printer with IP \"([^\"]*)\" has notes \"([^\"]*)\"$")
    public void printerWithIPHasNotes(String printer, String notes) throws Throwable {
        Assert.assertEquals(notes,PrinterHandler.getPrinterNotes(printer));
    }

    @Then("^printer with IP \"([^\"]*)\" has SNMP set to \"([^\"]*)\"$")
    public void printerWithIPHasSNMPSetTo(String printer, String snmp) throws Throwable {


        Assert.assertEquals(snmp, PrinterHandler.getPrinterSnmp(printer));

    }

    @Then("^printer with IP \"([^\"]*)\" has activated simple login method \"(card|pin|usernameandpassword)\"$")
    public void printerWithIPHasSetLoginethod(String printer, String method) throws Throwable {
        int currentLogin = PrinterHandler.getSimpleLoginMethod(printer);
        switch (method) {
            case "card":
                Assert.assertTrue((currentLogin & CARD) == CARD);
                break;
            case "pin":
                Assert.assertTrue((currentLogin & PIN) == PIN);
                break;
            case "usernameandpassword":
                Assert.assertTrue((currentLogin & USERNAMEANDPASSWORD) == USERNAMEANDPASSWORD);
                break;
        }
    }

    @Then("^printer with IP \"([^\"]*)\" has activated Two Step login method \"(cardandpin|cardandpassword)\"$")
    public void printerWithIPHasActivatedTwoStepLoginMethod(String printer, String value) throws Throwable {
        if (value.equals("cardandpin")){
            Assert.assertEquals(2,PrinterHandler.getTwoStepLoginMethod(printer));
        }
        else Assert.assertEquals(3,PrinterHandler.getTwoStepLoginMethod(printer));
    }

}
