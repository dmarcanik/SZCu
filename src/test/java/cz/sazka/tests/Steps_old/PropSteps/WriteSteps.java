package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteSteps {

    private static WebDriver webDriver = Hook.getDriver();


    @And("^I write to \"([^\"]*)\" text field \"([^\"]*)\"$")
    public void writeTo(String target, String value) throws Throwable {
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Helpers.getPropnamePath(target))));
        WebElement element = ElementHandler.getPropnameElement(target);
        WebElement finalElement = element.findElement(By.tagName("input"));
        finalElement.clear();
        finalElement.sendKeys(value);
    }


    @And("^I write to \"([^\"]*)\" text area \"([^\"]*)\"$")
    public void writeToTextArea(String target, String value) throws Throwable {
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(Helpers.getPropnamePath(target))));
        WebElement element = ElementHandler.getPropnameElement(target);
        element.clear();
        element.sendKeys(value);
    }
}
