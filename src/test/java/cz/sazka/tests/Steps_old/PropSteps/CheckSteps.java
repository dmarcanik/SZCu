package cz.sazka.tests.Steps_old.PropSteps;


import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.SettingsHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;


public class CheckSteps {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();


    @Then("^checkbox \"([^\"]*)\" is \"(activated|deactivated)\"$")
    public void isActivated(String target, String value) {
        WebElement element = ElementHandler.getCmdIdElement(target);
        try {
            Boolean expected;
            expected = value.equals("activated");
            Assert.assertEquals(expected, element.isSelected());


        } catch (AssertionError e) {
            log.error("ERROR: " + target + " is not " + value + " \n", e);
            throw e;
        } catch (NoSuchElementException e) {
            log.error("ERROR " + target + " not found \n", e);
            throw e;
        }
    }

    @Then("^checkbox \"([^\"]*)\" is \"([^\"]*)\" in database$")
    public void checkboxIsInDatabase(String target, String value) throws SQLException, AssertionError {
        String current = null;
        try {
            current = SettingsHandler.getSettingsValue(target);
        } catch (SQLException e) {
            log.error("ERROR: " + value + " not found in " + target + " \n", e);
            throw e;
        }
        try {
            Assert.assertEquals(value, current);
        } catch (AssertionError e) {
            log.error("ERROR: " + value + " is not same as " + SettingsHandler.getSettingsValue(target) + " \n", e);
            throw e;
        }
    }


    @Then("^in \"([^\"]*)\" is written \"([^\"]*)\"$")
    public void inIsWritten(String target, String value) throws ElementNotVisibleException, AssertionError {
        WebElement finalElement = null;
        try {
            WebElement element = ElementHandler.getPropnameElement(target);
            finalElement = element.findElement(By.tagName("input"));
            try {
                Assert.assertEquals(value, finalElement.getAttribute("value"));
            } catch (AssertionError error) {
                log.error("ERROR: " + value + " does not match " + finalElement.getAttribute("value"));
                throw error;
            }
        } catch (NoSuchElementException e) {
            log.error("ERROR: Element " + target + " not found \n", e);
            throw e;
        }

    }


    @Then("^in \"([^\"]*)\" is set in \"([^\"]*)\"$")
    public void isSetIn(String target, String value) throws AssertionError {
        try {
            Select select = new Select(ElementHandler.getPropnameElement(target));
            Assert.assertEquals(value, select.getFirstSelectedOption().getAttribute("value"));

        } catch (AssertionError e) {
            log.error("ERROR: " + value + "not equals to " + ElementHandler.getPropnameElement(target) + " \n", e);
            throw e;

        }


    }


    @Then("^in \"([^\"]*)\" is set in \"([^\"]*)\" in database$")
    public void inIsSetInInDatabase(String target, String value) throws SQLException, AssertionError {
        try {
            String current = SettingsHandler.getSettingsValue(target);
            Assert.assertEquals(value, current);
        } catch (AssertionError e) {
            log.error("ERROR: " + value + " not equals to " + SettingsHandler.getSettingsValue(target) + " \n", e);
            throw e;

        }

    }

    @Then("^switch \"([^\"]*)\" is \"([^\"]*)\"$")
    public void switchIs(String target, String value) throws NoSuchElementException, AssertionError {
        try {
            WebElement element = ElementHandler.getPropnameElement(target);
            String className = element.getAttribute("class");
            Boolean attribute = className.contains(value);
            if (value.equals("off")) {
                Assert.assertTrue(attribute);
            } else {
                // check if is ON
                Assert.assertFalse(className.contains("off"));
            }
        } catch (NoSuchElementException e) {
            log.error("ERROR " + ElementHandler.getPropnameElement(target).toString() + " not found \n", e);
            throw e;

        }
    }

    @Then("^switch \"([^\"]*)\" is \"([^\"]*)\" in database$")
    public void switchIsInDatabase(String target, String value) throws SQLException {
        try {
            String current = SettingsHandler.getSettingsValue(target);
            Assert.assertEquals(value, current);
        } catch (AssertionError e) {
            log.error("ERROR: " + value + " not equals to" + SettingsHandler.getSettingsValue(target) + " \n", e);
            throw e;

        }

    }

    @Then("^\"([^\"]*)\" is \"(hidden|displayed)\"$")
    public void isHidden(String target, String value) {
        try {
            if (value.equals("displayed")) {
                WebDriverWait wait = new WebDriverWait(webDriver, 5);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Helpers.getCmdIdPath(target))));

            } else {
                WebDriverWait wait = new WebDriverWait(webDriver, 5);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Helpers.getCmdIdPath(target))));
            }

        } catch (NoSuchElementException e) {
            log.error("ERROR: element" + target + "  not became " + value + " \n", e);

        }
    }

    @Then("^rbutton \"([^\"]*)\" is \"([^\"]*)\"$")
    public void rbuttonIs(String target, String value) {

        List<WebElement> options = null;
        try {
            WebElement element = ElementHandler.getPropnameElement(target);
            options = element.findElements(By.tagName("input"));
            for (WebElement option : options) {
                if (!option.getAttribute("value").equals(value)) {
                    continue;
                }

                try {
                    Assert.assertTrue(value, option.isSelected());
                } catch (AssertionError e) {
                    log.error("ERROR" + value + "is not same as" + option.isSelected());
                }
            }
        } catch (NoSuchElementException e) {
            log.error("ERROR: Element " + target + "not found " + " \n", e);

        }


    }


    @Then("^rbutton \"([^\"]*)\" is \"([^\"]*)\" in database$")
    public void rbuttonIsInDatabase(String target, String value) throws SQLException {
        String current = SettingsHandler.getSettingsValue(target);
        try {
            Assert.assertEquals(value, current);
        } catch (AssertionError e) {
            log.error("ERROR " + value + "not equals to " + SettingsHandler.getSettingsValue(target) + " \n", e);
        }
    }

    @Then("^Im in \"([^\"]*)\"$")
    public void imIn(String target) {

        try {
            new WebDriverWait(webDriver, 15)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-pageref=\"" + target + "\"]")));
        } catch (NoSuchElementException e) {
            log.error("ERROR: element " + target + " not became clickable \n", e);
        }
    }

    @Then("^Error message is displayed in top bar$")
    public void errorMessageIsDisplayedInTopBar() {
        try {
            new WebDriverWait(webDriver, 15)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"errorMsg\"]")));
        } catch (NoSuchElementException e) {
            log.error("ERROR was not displayed in bottom bar \n", e);
        }
    }
    @Then("^Info message is displayed in top bar$")
    public void infoMessageIsDisplayedInTopBar() {
        try {
            new WebDriverWait(webDriver, 15)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"infoMsg\"]")));
        } catch (NoSuchElementException e) {
            log.error("Info message was not displayed in bottom bar \n", e);
        }
    }



    @Then("^Enable button \"([^\"]*)\" is \"(enabled|disabled)\"$")
    public void enableButtonIs(String target, String value) {
        if (value.equals("enabled")) {
            WebElement element = ElementHandler.getCmdIdElement(target);

            try {
                new WebDriverWait(webDriver, 15)
                        .until(ExpectedConditions.attributeContains(element, "class", "checked"));
            } catch (TimeoutException e) {
                log.error("ERROR: button " + target + " is not probably " + value + " \n", e);
                throw e;
            }

        } else {
            WebElement element = ElementHandler.getCmdIdElement(target);
            try {
                new WebDriverWait(webDriver, 15)
                        .until(ExpectedConditions.not(ExpectedConditions.attributeContains(element, "class", "checked")));
            } catch (TimeoutException e) {
                log.error("ERROR: button " + target + " is not probably " + value + " \n", e);
                throw e;
            }


        }


    }
}
