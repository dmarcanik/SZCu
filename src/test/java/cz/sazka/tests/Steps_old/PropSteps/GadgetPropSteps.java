package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.GadgetHandler;
import cz.sazka.tests.Steps.Hook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class GadgetPropSteps {
    private static WebDriver webDriver = Hook.getDriver();
    private static Logger log = LogManager.getRootLogger();

    @And("^delete gadgets \"([^\"]*)\"$")
    public void deleteGadgets(String target){
        ArrayList<String> ids = GadgetHandler.getGadgetIds(target);
        try {
            for (String id:ids) {
                new WebDriverWait(webDriver, 15)
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-gadget-id=\""+id+"\"]")));
                WebElement element = webDriver.findElement(By.xpath("//*[@data-gadget-id=\""+id+"\"]")).findElement(By.cssSelector("[class=wsfGadgetCtx]"));
                element.click();
                new WebDriverWait(webDriver, 15)
                        .until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//li[contains(@id,'Delete')]"))));
                webDriver.findElement(By.xpath("//li[contains(@id,'Delete')]")).click();

            }


        }catch (NoSuchElementException e){
            log.error(" Element containing " + target + " not found \\n :\"", e);
        }


    }
    @Then("^gadget \"([^\"]*)\" is in database$")
    public void gadgetIsInDatabase(String value) {
        Assert.assertTrue(GadgetHandler.isGadgetContained(value));

    }
    @Then("^gadget \"([^\"]*)\" is not in Web")
    public void gadgetIsNotInWeb(String target){
        ArrayList<String> ids = GadgetHandler.getGadgetIds(target);
        for (String id: ids) {
            Assert.assertFalse(webDriver.findElement(By.xpath("//*[@data-gadget-id=\""+id+"\"]")).isDisplayed());
        }


    }


    @Then("^gadget \"([^\"]*)\" is in Web$")
    public void gadgetIsInWeb(String target) {
        ArrayList<String> ids = GadgetHandler.getGadgetIds(target);
        for (String id: ids) {
            Assert.assertTrue(webDriver.findElement(By.xpath("//*[@data-gadget-id=\""+id+"\"]")).isDisplayed());
        }
    }
}
