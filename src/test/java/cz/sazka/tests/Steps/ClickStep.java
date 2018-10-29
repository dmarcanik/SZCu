package cz.sazka.tests.Steps;


import cucumber.api.java.en.And;
import cz.sazka.tests.Utils.ElementHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;


public class ClickStep {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    @And("^I click on button \"([^\"]*)\"$")
    public void click(String target) {
        try {

            log.info("Clicking on button " + target);
            ElementHandler.webDriverWait().until(ExpectedConditions.elementToBeClickable(ElementHandler.getIdBy(target)));
            WebElement element = ElementHandler.findCmd(target);
            ElementHandler.clickCmd(element);
            log.info(target + " button clicked");

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }

    }




   /* @And("^I click on button \"([^\"]*)\" where \"([^\"]*)\" is \"([^\"]*)\"$")
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
    }*/

    @And("^I click on checkbox \"([^\"]*)\"$")
    public void clickCheckbox(String target) {
        try {
            log.info("Clicking on checkbox " + target);
            ElementHandler.waitElementLoadedBy(ElementHandler.getForCssBy(target));
            WebElement element = ElementHandler.getForCssElement(target);

            if (!element.isSelected()) {
                element.click();
                log.info(target + " checkbox clicked");
            }

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }


    }


    @And("^I click on combo box \"([^\"]*)\" and select \"([^\"]*)\"$")
    public void clickComboBox(String target, String value) {
        try {
            click(target);
            WebElement correctElement = null;
            WebElement element = ElementHandler.getCssElement("[aria-hidden=\"false\"]");

            List<WebElement> elementList = element.findElements(By.cssSelector("[data-val]"));
            for (WebElement elem : elementList) {
                if (elem.getAttribute("data-val").equals(value)) {
                    correctElement = elem;
                }

            }
            assert correctElement != null;
            log.info("Choosing element " + target);
            correctElement.click();
            log.info(target + " element chosen");


        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        } catch (NullPointerException ex) {
            log.error("CorrectElement " + value + " not found");
        }

    }

     /* //List<String> tagSelectors = Helpers.getPaths(target);

            List<ExpectedCondition<WebElement>> expected = tagSelectors.stream().map(p -> ExpectedConditions.elementToBeClickable(By.xpath(p))).collect(Collectors.toList());
            ExpectedCondition[] args = expected.toArray(new ExpectedCondition[expected.size()]);*/


    /*@And("^I Open dropdown menu and click on \"([^\"]*)\"$")
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
            ElementHandler.waitPageToBeLoaded();
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
*/



   /* @When("^I click on Dashboard link \"([^\"]*)\"$")
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


    }*/

}
