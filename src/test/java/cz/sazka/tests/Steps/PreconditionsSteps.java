package cz.sazka.tests.Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import gherkin.lexer.El;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreconditionsSteps {

    //TODO If user was logged in previous test, redirect him only to dashboard (its safe space), In hook is already checked if browser is open.

    private static WebDriver webDriver = Hook.getDriver();
    private static ConfigFileReader configFileReader;

    @Given("^Im logged in as \"([^\"]*)\" with password \"([^\"]*)\" and situated on Dashboard$")
    public void imLoggedInAsWithPassword(String username, String password) throws Throwable {
        configFileReader = new ConfigFileReader();
        webDriver.navigate().to(configFileReader.getStandaloneUrl());
        ElementHandler.waitPageToBeLoaded();
        if (ElementHandler.userLoggedIn()) {
            logoutUser();
        }
        loginUser(username, password);

    }


    /**
     * Finds the input element by name attribute and send the value to it
     *
     * @param name  Input name
     * @param value Value to send
     */
    private void writeToInput(String name, String value) throws InterruptedException {
        ElementHandler.getidXElement(name).clear();
        ElementHandler.getidXElement(name).sendKeys(value);
    }

    public static void waitForPresence(By by) {
        ElementHandler.webDriverWait().until(ExpectedConditions.elementToBeClickable(by));
    }


    @And("^Login user \"([^\"]*)\" with password \"([^\"]*)\" $")
    public void loginUser(String username, String password) throws Throwable {
        ElementHandler.waitPageToBeLoaded();
        waitForPresence(ElementHandler.getIdXpathBy(Helpers.locatorMap("login")));
        new ClickStep().click(Helpers.locatorMap("login"));
        waitForPresence(ElementHandler.getIdXpathBy(Helpers.locatorMap("user")));
        new ClickStep().click(Helpers.locatorMap("user"));
        writeToInput(Helpers.locatorMap("user"), username);
        writeToInput(Helpers.locatorMap("password"), password);
        new ClickStep().click(Helpers.locatorMap("submit"));
        ElementHandler.waitToBeLoggedIn();
        if (ElementHandler.consentPresented()) {
            ElementHandler.acceptConsent();
        }

    }


    @Then("^Logout user$")
    public void logoutUser() throws Throwable {
        int count = 1;
        ElementHandler.waitPageToBeLoaded();
        waitForPresence(ElementHandler.getIdXpathBy(Helpers.locatorMap("myProfile")));
        new ClickStep().click(Helpers.locatorMap("myProfile"));
        while (!(ElementHandler.isLoggoutActive())&& count< 3) {
            System.out.println("myProfile not active retrying attempt " + count);
            new ClickStep().click(Helpers.locatorMap("myProfile"));
            count++;
            Thread.sleep(2000);
        }
        waitForPresence(ElementHandler.getclassBy(Helpers.locatorMap("logout")));
        ElementHandler.getClassXElement(Helpers.locatorMap("logout")).click();
        waitForPresence(ElementHandler.getclassBy(Helpers.locatorMap("ok")));
        ElementHandler.getClassXElement(Helpers.locatorMap("ok")).click();
        ElementHandler.waitToBeLoggedOut();
    }

    @Given("^Im not logged as any user and I am situated on Dashboard$")
    public void imNotLoggedAsAnyUserAndIAmSituatedOnDashboard() throws Throwable {
        configFileReader = new ConfigFileReader();
        webDriver.navigate().to(configFileReader.getStandaloneUrl());
        ElementHandler.waitPageToBeLoaded();
        if (ElementHandler.consentPresented()) {
            ElementHandler.acceptConsent();
        }
    }
}
