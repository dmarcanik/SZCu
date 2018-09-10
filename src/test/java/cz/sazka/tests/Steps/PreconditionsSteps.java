package cz.sazka.tests.Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        loginUser(username,password);





    }




    /**
     * Finds the input element by name attribute and send the value to it
     *
     * @param name  Input name
     * @param value Value to send
     */
    private void writeToInput(String name, String value) {
        ElementHandler.getidXElement(name).clear();
        ElementHandler.getidXElement(name).sendKeys(value);
    }

    private void waitToBeClickable(By by) {
        new WebDriverWait(webDriver, 10)
                .until((ExpectedConditions.elementToBeClickable(by)));
    }

    private void acceptConsent (){
        WebElement element = ElementHandler.getConsentElement();
        if (element.isDisplayed()){
            element.findElement(By.cssSelector("[class=agree]")).click();

        }
    }

    @Then("^Login user \"([^\"]*)\" with password \"([^\"]*)\" $")
    public void loginUser(String username, String password)throws Throwable{
        ElementHandler.waitPageToBeLoaded();
        this.waitToBeClickable(By.xpath(Helpers.getIdPath("neo-login")));
        ElementHandler.getidXElement("neo-login").click();
        this.waitToBeClickable(By.xpath(Helpers.getIdPath("user")));
        this.writeToInput("user", username);
        this.writeToInput("password", password);
        ElementHandler.getidXElement("submit").click();
        ElementHandler.waitPageToBeLoaded();
        if (ElementHandler.consentPresented()){
            acceptConsent();
        }

    }


    @Then("^Logout user$")
    public void logoutUser() throws Throwable {
        ElementHandler.waitElementLoadedEl(ElementHandler.getidXElement("myProfile"));
        ElementHandler.getidXElement("myProfile").click();
        ElementHandler.waitElementLoadedEl(ElementHandler.getClassXElement("btn-logout"));
        ElementHandler.getClassXElement("btn-logout").click();
        ElementHandler.waitPageToBeLoaded();
    }
}
