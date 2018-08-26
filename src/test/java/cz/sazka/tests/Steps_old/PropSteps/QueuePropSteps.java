package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.QueueHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.UnsupportedEncodingException;

public class QueuePropSteps {
    private static WebDriver webDriver = Hook.getDriver();
    private static Logger log = LogManager.getRootLogger();

    @And("^I Open tab \"([^\"]*)\" of queue \"([^\"]*)\"$")
    public void iOpenQueue(String tab, String target) throws Throwable {
        try {
            String queueId = QueueHandler.getQueueId(target);
            String url = webDriver.getCurrentUrl();
            url = java.net.URLDecoder.decode(url, "UTF-8");
            String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + Helpers.getQueueHash(queueId, tab));
            webDriver.navigate().to(newEndpoint);
            ElementHandler.waitAjaxComplete();
        } catch (NoSuchElementException | UnsupportedEncodingException e) {
            log.error("ERROR: \n ", e);
        }
    }

    @And("^select \"([^\"]*)\" in the queues grid$")
    public void selectQueueInGrid(String target) throws Throwable {
        WebElement gridElemenet = webDriver.findElement(By.xpath("//*[@class=\"wsfCtrl Wsf_Ctrls_DataGrid_CtrlDataGrid wsfControlBorderBottom\"]"));
        String bodyName = gridElemenet.getAttribute("id");
        String queueId = QueueHandler.getQueueId(target);
        WebElement newelement = webDriver.findElement(By.cssSelector("[id=\"" + bodyName + "." + queueId + "\"]")).findElement(By.cssSelector("[data-value]"));
        newelement.click();
        ElementHandler.waitAjaxComplete();
    }

    @Then("^queue \"([^\"]*)\" is in database$")
    public void queueIsInDatabase(String queueName) {
        Assert.assertTrue(QueueHandler.isQueueContained(queueName));

    }

    @Then("^queue \"([^\"]*)\" is \"(offline|online)\"")
    public void queueIsOffline(String queueName, String state){
        if (state.equals("offline")) {
            Assert.assertFalse(QueueHandler.isQueueOnline(queueName));
        } else {
            Assert.assertTrue(QueueHandler.isQueueOnline(queueName));
        }
    }

    @Then("^queue \"([^\"]*)\" is deleted$")
    public void queueIsDeleted(String queueName){
        Assert.assertFalse(QueueHandler.isQueueContained(queueName));
    }
}
