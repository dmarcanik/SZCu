package cz.sazka.tests.Steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cz.sazka.tests.Db.*;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ClickStep {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    @And("^I click on button \"([^\"]*)\"$")
    public void click(String target) {
        try {
            new WebDriverWait(webDriver, 15)
                    .until(ExpectedConditions.elementToBeClickable(ElementHandler.getidXElement(target)));
            WebElement element = ElementHandler.findCmd(target);
            ElementHandler.clickCmd(element);

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }

    }




    @And("^I click on button \"([^\"]*)\" where \"([^\"]*)\" is \"([^\"]*)\"$")
    public void click(String type, String attr, String value) throws NoSuchElementException {
        List<WebElement> newlist = ElementHandler.findCmds(type);

        for (WebElement elementlist : newlist) {
            String params = elementlist.getAttribute("data-cmdparams");

            if (params == null) {
                continue;
            }

            JSONObject obj = new JSONObject(params);

            if (obj.has(attr) && obj.get(attr).equals(value)) {
                ElementHandler.clickCmd(elementlist);
                break;
            }
        }
    }

    @And("^I click on checkbox \"([^\"]*)\"$")
    public void clickCheckbox(String target) {
        try {
            ElementHandler.getPropnameElement(target).click();
        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }


    }


    @And("^I click on combo box \"([^\"]*)\" and select \"([^\"]*)\"$")
    public void clickComboBox(String target, String value) {
        try {
            List<String> tagSelectors = Helpers.getPaths(target);

            List<ExpectedCondition<WebElement>> expected = tagSelectors.stream().map(p -> ExpectedConditions.elementToBeClickable(By.xpath(p))).collect(Collectors.toList());
            ExpectedCondition[] args = expected.toArray(new ExpectedCondition[expected.size()]);

            new WebDriverWait(webDriver, 15)
                    .until(ExpectedConditions.or(args));
            ElementHandler.getCorrectElement(tagSelectors).click();
            Select select = new Select(ElementHandler.getCorrectElement(tagSelectors));
            select.selectByValue(value);

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }

    }


    @And("^I Open dropdown menu and click on \"([^\"]*)\"$")
    public void openDropdownMenuAndClickOn(String target) {
        try {
            List<WebElement> webElements = webDriver.findElements(By.xpath("//*[@data-ctrltype=\"Wsf_Forms_CtrlButtonDropDown\"]"));
            for (WebElement elementlist : webElements) {
                elementlist.click();
                if (webDriver.findElement(By.xpath(Helpers.getCmdIdPath(target))).isDisplayed()) {
                    break;

                }

            }

            ElementHandler.getCmdIdElement(target).click();
            ElementHandler.waitAjaxComplete();
        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;

        }
    }


    @And("^I click on rbutton \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void clickOnRbuttonIn(String target, String value) {

        try {
            new WebDriverWait(webDriver, 15)
                    .until(ExpectedConditions.elementToBeClickable(ElementHandler.getPropnameElement(target)));
            WebElement element = ElementHandler.getPropnameElement(target);

            List<WebElement> options = element.findElements(By.tagName("input"));

            for (WebElement option : options) {
                if (!option.getAttribute("value").equals(value)) {
                    continue;
                }


                option.click();
            }

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }

    }

    @And("^I click on switch \"([^\"]*)\"$")
    public void clickOnSwitch(String target) {
        try {
            WebElement element = ElementHandler.getPropnameElement(target);
            ElementHandler.clickCmd(element);

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }


    }


    @And("^I Open autocomplete box \"([^\"]*)\" and add new$")
    public void openAutocompleteBoxAndAdd(String target) {
        try {
            WebElement element = ElementHandler.getPropnameElement(target).findElement(By.cssSelector("[class=\"wsfACBtn\"]"));
            element.click();
            ElementHandler.waitLoadingComplete(element);
            webDriver.findElement(By.xpath("//*[@data-id=\"0\"]")).click();

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }

    }

    @And("^I Open autocomplete box \"([^\"]*)\" and select \"(user|usergroup|printer|printergroup|authserver)\" \"([^\"]*)\"$")
    public void openAutocompleteBoxAndSelect(String target, String type, String value) {
        try {

            WebElement element = ElementHandler.getPropnameElement(target).findElement(By.cssSelector("[class=\"wsfACBtn\"]"));
            element.click();
            ElementHandler.waitLoadingComplete(ElementHandler.getPropnameElement(target));
            switch (type) {
                case "user":
                    String userId = UserHandler.getUserID(value);
                    webDriver.findElement(By.xpath("//*[@data-id=\"" + userId + "\"]")).click();
                    break;
                case "usergroup":
                    String userGroupid = UserGroupHandler.getUserGroupId(value);
                    webDriver.findElement(By.xpath("//*[@data-id=\"" + userGroupid + "\"]")).click();
                    break;
                case "printer":
                    String printerId = PrinterHandler.getPrinterId(value);
                    webDriver.findElement(By.xpath("//*[@data-id=\"" + printerId + "\"]")).click();
                    break;
                case "printergroup":
                    String printerGroupId = PrinterGroupHandler.getPrinterGroupId(value);
                    webDriver.findElement(By.xpath("//*[@data-id=\"" + printerGroupId + "\"]")).click();
                    break;
                case "authserver":
                    String authServerId = SettingsHandler.getAuthServerId(value);
                    webDriver.findElement(By.xpath("//*[@data-id=\"" + authServerId + "\"]")).click();
                    break;

            }

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " or " + value + " not found \n :", e);
            throw e;
        }

    }

    @When("^I click on Dashboard link \"([^\"]*)\"$")
    public void clikOnLink(String value) {

        List<WebElement> newlist = webDriver.findElements(By.xpath("//*[@class=\"wsfCtrl wizardStep wizardStep\"]"));

        for (WebElement elementlist : newlist) {
            String params = elementlist.getAttribute("href");
            System.out.println(params);

            if (params == null) {
                continue;
            }

            JSONObject obj = new JSONObject(params);

            if (obj.has("r") && obj.get("r").equals(value)) {
                ElementHandler.clickCmd(elementlist);
                break;
            }
        }


    }

}
