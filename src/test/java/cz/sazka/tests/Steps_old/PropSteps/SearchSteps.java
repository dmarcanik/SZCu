package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;


public class SearchSteps {

    private static WebDriver webDriver = Hook.getDriver();


    @And("^select \"(ok|cancel)\" on alert window$")
    public void okCancelAlertWindow(String value) throws Throwable {
        Alert alert = webDriver.switchTo().alert();
        if (value.equals("ok")) {

            alert.accept();
            ElementHandler.waitAjaxComplete();


        } else alert.dismiss();
        ElementHandler.waitAjaxComplete();

    }
    @And("^select \"(Yes|No)\" on alert window$")
    public void yesNoAlertWindow(String value) throws Throwable {
        Alert alert = webDriver.switchTo().alert();
        if (value.equals("Yes")) {

            alert.accept();
            ElementHandler.waitAjaxComplete();


        } else alert.dismiss();
        ElementHandler.waitAjaxComplete();

    }

}
