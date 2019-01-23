package cz.sazka.tests.Steps;

import cucumber.api.java.en.When;
import cz.sazka.tests.DataProviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import pageObjects.UpperMenuLoggedOut;

import java.io.IOException;
import java.net.URISyntaxException;

public class newSteps {
    private static WebDriver webDriver = Hook.getDriver();
    private UpperMenuLoggedOut upperMenuLoggedOut;


    @When("^I clik on login$")
    public void click() throws IOException, URISyntaxException, InterruptedException {
        ConfigFileReader configFileReader = new ConfigFileReader();
        webDriver.navigate().to(configFileReader.getUrl());
        upperMenuLoggedOut = new UpperMenuLoggedOut(webDriver);
        upperMenuLoggedOut.clickLoginBtn();
        Thread.sleep(4000);



    }

}
