package cz.sazka.tests.Steps;


import cucumber.api.java.en.And;
import cz.sazka.tests.Utils.ElementHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ClickStep {

    private static Logger log = LogManager.getRootLogger();

    /**
     * Waiting to id element to be clickable
     * Clicking on element with id.
     * @param target passed from testcase.
     * @throws NoSuchElementException when element is not found and make test fail.
     */
    @And("^I click on button \"([^\"]*)\"$")
    public void click(String target) {
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Clicking on button " + target);
            By targetBy = ElementHandler.getIdBy(target);
            ElementHandler.clickOn(targetBy);
            log.info(target + " button clicked");

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }

    }



    /**
     * Waiting to id element to be clickable
     * Clicking on checkbox with id parameter.
     * @param target passed from testcase.
     * @throws NoSuchElementException when element is not found and make test fail.
     */
    @And("^I click on checkbox \"([^\"]*)\"$")
    public void clickCheckbox(String target) {
        try {
            log.info("Clicking on checkbox " + target);
            By targetBy = ElementHandler.getForCssBy(target);
            ElementHandler.waitElementLoadedBy(targetBy);
            WebElement element = ElementHandler.getElement(targetBy);

            if (!element.isSelected()) {
                element.click();
                log.info(target + " checkbox clicked");
            }

        } catch (NoSuchElementException e) {
            log.error("Element containing " + target + " not found \n :", e);
            throw e;
        }


    }

    /**
     * Waiting to id element to be clickable
     * Clicking on combo box with id parameter and selecting desired value.
     * @param target passed from testcase.
     * @throws NoSuchElementException when element is not found and make test fail.
     */
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

}
