package cz.sazka.tests.Steps;

import cucumber.api.java.en.And;
import cz.sazka.tests.Utils.ElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WriteSteps {
    /**
     * Finds the input element by name attribute and send the value to it
     *
     * @param name  Input name
     * @param value Value to send
     */
    @And("^Write to text field \"([^\"]*)\" value \"([^\"]*)\"$")
    public void writeToInput(String name, String value) throws InterruptedException {
        By targetBy = ElementHandler.getIdBy(name);
        ElementHandler.waitElementLoadedBy(targetBy);
        WebElement element = ElementHandler.getElement(targetBy);
        element.clear();
        element.sendKeys(value);
    }
}
