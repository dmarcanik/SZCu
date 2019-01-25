package cz.sazka.tests.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import pageObjects.Header;
import pageComponents.LoginForm;

import java.io.IOException;
import java.net.URISyntaxException;

public class newSteps {
    private static WebDriver webDriver = Hook.getDriver();
    private Header header;
    private LoginForm loginForm;


    @When("^I clik on login$")
    public void click() throws IOException, URISyntaxException{
        ConfigFileReader configFileReader = new ConfigFileReader();
        webDriver.navigate().to(configFileReader.getUrl());
        header = new Header(webDriver);
        loginForm = header.clickLoginBtn();

    }

    @And("I fill as username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void fillUsernameAndPassword(String username, String password) {
        try {
            loginForm.fillUser(username);
            loginForm.fillPassword(password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
