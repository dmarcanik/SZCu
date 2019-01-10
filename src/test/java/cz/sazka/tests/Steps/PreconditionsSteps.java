package cz.sazka.tests.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import cz.sazka.tests.Utils.ActiveElementChecker;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.html.HTMLBRElement;

public class PreconditionsSteps {

    //TODO If user was logged in previous test, redirect him only to dashboard (its safe space), In hook is already checked if browser is open.

    private static WebDriver webDriver = Hook.getDriver();
    private static ConfigFileReader configFileReader;
    private static By consentBy = ElementHandler.getBy(Helpers.getConsentPageCss());
    private static By toastBy = ElementHandler.getBy(Helpers.getClassCss("sazka-toast active"));

    /**
     *Checks whether user is loogged in is, then logs him out and then login user added in keywords.
     */
    @Given("^Im logged in as \"([^\"]*)\" with password \"([^\"]*)\" and situated on Dashboard$")
    public void imLoggedInAsWithPassword(String username, String password) throws Throwable {
        configFileReader = new ConfigFileReader();
        webDriver.navigate().to(configFileReader.getUrl());
        ElementHandler.waitPageToBeLoaded();
        By userLogin = ElementHandler.getBy(Helpers.getLoggedInCss());
        if (ActiveElementChecker.isActive(userLogin)) {
            logoutUser();
        }
        loginUser(username, password);

    }



    public static void waitForPresence(By by) {
        ElementHandler.webDriverWait().until(ExpectedConditions.elementToBeClickable(by));
    }


    @And("^Login user \"([^\"]*)\" with password \"([^\"]*)\" $")
    public void loginUser(String username, String password) throws Throwable {
        ElementHandler.waitPageToBeLoaded();
        new ClickStep().click(Helpers.locatorMap("login"));
        new WriteSteps().writeToInput(Helpers.locatorMap("user"), username);
        new WriteSteps().writeToInput(Helpers.locatorMap("password"), password);
        new ClickStep().click(Helpers.locatorMap("submit"));
        ElementHandler.waitToBeLoggedIn();
        if (ActiveElementChecker.isActive(toastBy)){
            ElementHandler.clickOn(ElementHandler.getclassCssBy("sazka-toast__close"));

        }
        if (ActiveElementChecker.isActive(consentBy)) {
            ElementHandler.acceptConsent();
        }


    }


    @Then("^Logout user$")
    public void logoutUser() throws Throwable {
        int count = 1;
        ElementHandler.waitPageToBeLoaded();
        By logout = ElementHandler.getBy(Helpers.getClassCssContains(Helpers.locatorMap("logout")));
        By ok = ElementHandler.getBy(Helpers.getClassCssContains(Helpers.locatorMap("ok")));
        new ClickStep().click(Helpers.locatorMap("myProfile"));
        while (!(ActiveElementChecker.isActive(logout))&& count< 3) {
            System.out.println("myProfile not active retrying attempt " + count);
            new ClickStep().click(Helpers.locatorMap("myProfile"));
            count++;
            Thread.sleep(2000);
        }
        ElementHandler.clickOn(logout);
        ElementHandler.clickOn(ok);
        ElementHandler.waitToBeLoggedOut();
    }

    /**
     *Just navigate to dashboard without logging user.
     */
    @Given("^Im not logged as any user and I am situated on Dashboard$")
    public void imNotLoggedAsAnyUserAndIAmSituatedOnDashboard() throws Throwable {
        configFileReader = new ConfigFileReader();
        webDriver.navigate().to(configFileReader.getUrl());
        ElementHandler.waitPageToBeLoaded();
        if (ActiveElementChecker.isActive(consentBy)) {
            ElementHandler.acceptConsent();
        }
    }
}
