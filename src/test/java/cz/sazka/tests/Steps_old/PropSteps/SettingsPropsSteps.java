package cz.sazka.tests.Steps_old.PropSteps;


import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.SettingsHandler;
import cz.sazka.tests.Steps.Hook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class SettingsPropsSteps {

    private static WebDriver webDriver = Hook.getDriver();
    private static Logger log = LogManager.getRootLogger();

    @Then("^previously entered data are saved saved in datastore")
    public void printerWithIpHasName(DataTable data) throws Throwable {
        for (Map<String, String> datatable : data.asMaps(String.class, String.class)) {
            String table = datatable.get("table");
            String value = datatable.get("value");
            Assert.assertTrue(value.equals(SettingsHandler.getSettingsValue(table)));


        }


    }

    @Then("^licenses are saved in database$")
    public void licensesAreSavedInDatabase() throws Throwable {
        List<WebElement> newlist = webDriver.findElements(By.xpath("//*[@data-data]"));
        for (WebElement elementlist : newlist) {
            if (elementlist.getAttribute("data-data").contains("\"canActivate\":false")) {
                String databaseId = elementlist.getAttribute("id").replaceAll(".*\\.(\\d+)", "$1");
                Assert.assertTrue(SettingsHandler.isLicenseContained(databaseId));

            }

        }

    }


}
