package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.UserHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPropSteps {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();


    @And("^I Open tab \"([^\"]*)\" of user \"([^\"]*)\"$")
    public void openUserTabOf(String tab, String user) throws Throwable {
        String userId = UserHandler.getUserID(user);
        String url = webDriver.getCurrentUrl();
        url = java.net.URLDecoder.decode(url, "UTF-8");
        String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + Helpers.getUserHash(userId, tab));
        webDriver.navigate().to(newEndpoint);
        ElementHandler.waitAjaxComplete();
    }
    @And("^search for \"([^\"]*)\" in user search$")
    public void searchForInUserSearch(String target) throws Throwable {
        new WebDriverWait(webDriver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-ctrltype=\"Web_Users_UsersGrid\"]")));
        WebElement getGridElement = webDriver.findElement(By.xpath("//*[@data-ctrltype=\"Web_Users_UsersGrid\"]"));
        WebElement searchElement = getGridElement.findElement(By.cssSelector("[data-ctrltype=\"Wsf_Forms_CtrlSearchBox\"]")).findElement(By.cssSelector("[type=\"text\"]"));
        searchElement.sendKeys(target);
        searchElement.sendKeys(Keys.ENTER);
    }


    @And("^select \"([^\"]*)\" in the users grid$")
    public void selectUserInGrid(String target) throws Throwable {
        WebElement gridElemenet = webDriver.findElement(By.xpath("//*[@class=\"wsfCtrl Wsf_Ctrls_DataGrid_CtrlDataGrid wsfControlBorderBottom\"]"));
        String bodyName = gridElemenet.getAttribute("id");
        String userId = UserHandler.getUserID(target);
        WebElement newelement = webDriver.findElement(By.cssSelector("[id=\"" + bodyName + "." + userId + "\"]")).findElement(By.cssSelector("[data-value]"));
        newelement.click();
    }



    @And("^I open \"(allusers|unclassified|managers|locked|deleted)\" user search filter$")
    public void openUserSearchFilter(String filter) throws Throwable {
        String url = webDriver.getCurrentUrl();
        String filterHash = "";

        switch (filter) {
            case "allusers":
                filterHash = Helpers.getUserFilterHash("3");
                break;
            case "unclassified":
                filterHash = Helpers.getUserFilterHash("7");
                break;
            case "managers":
                filterHash = Helpers.getUserFilterHash("15");
                break;
            case "locked":
                filterHash = Helpers.getUserFilterHash("25");
                break;
            case "deleted":
                filterHash = Helpers.getUserFilterHash("-1");
                break;


        }
        url = java.net.URLDecoder.decode(url, "UTF-8");
        String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + filterHash);
        webDriver.navigate().to(newEndpoint);
        ElementHandler.waitAjaxComplete();
    }

    @Then("^user \"([^\"]*)\" password is \"([^\"]*)\"$")
    public void passwordIs(String user, String password) throws Throwable {
        Assert.assertTrue(UserHandler.isPasswordContained(user, password));
    }

    @Then("^user \"([^\"]*)\" PIN is \"([^\"]*)\"$")
    public void pinIs(String user, String pin) throws Throwable {
        Assert.assertTrue(UserHandler.isPinContained(user, pin));

    }


    @Then("^user \"([^\"]*)\" card is \"([^\"]*)\"$")
    public void cardIs(String user, String card) throws Throwable {
        Assert.assertTrue(UserHandler.isCardContained(user, card));

    }

    @Then("^user \"([^\"]*)\" mail is \"([^\"]*)\"$")
    public void mailIs(String user, String mail) throws Throwable {
        Assert.assertEquals(mail, UserHandler.getUserEmail(user));
    }

    @Then("^user \"([^\"]*)\" fullname is \"([^\"]*)\"$")
    public void fullnameIs(String user, String fullname) throws Throwable {
        Assert.assertEquals(fullname, UserHandler.getUserFullname(user));
    }

    @Then("^user \"([^\"]*)\" language is \"([^\"]*)\"$")
    public void languageIs(String user, String language) throws Throwable {
        Assert.assertEquals(language, UserHandler.getUserLang(user));
    }

    @Then("^user \"([^\"]*)\" is active$")
    public void isActivated(String user) throws Throwable {
        Assert.assertTrue(UserHandler.isUserActive(user));

    }

    @Then("^user \"([^\"]*)\" credit is \"([^\"]*)\"$")
    public void creditIs(String user, double value) throws Throwable {

        Assert.assertEquals(value, UserHandler.getUserCredit(user), 0);

    }

    @Then("^user \"([^\"]*)\" note is \"([^\"]*)\"$")
    public void noteIs(String user, String note) throws Throwable {
        Assert.assertEquals(note, UserHandler.getUserNotes(user));
    }

    @Then("^user \"([^\"]*)\" auth server is \"(activated|deactivated)\"$")
    public void authServerIs(String user, String status) throws Throwable {
        Boolean expected;
        expected = status.equals("activated");
        Assert.assertEquals(expected, UserHandler.isUseAuthServerActive(user));

    }

    @Then("^user \"([^\"]*)\" quota is \"(activated|deactivated)\"$")
    public void quotaIs(String user, String status) throws Throwable {
        Boolean expected;
        expected = status.equals("activated");
        Assert.assertEquals(expected, UserHandler.isQuotaActive(user));

    }

    @Then("^user \"([^\"]*)\" code is \"([^\"]*)\"$")
    public void codeIs(String user, String code) throws Throwable {
        Assert.assertEquals(code, UserHandler.getUserCode(user));

    }

    @Then("^user \"([^\"]*)\" is in database$")
    public void userIsInDatabase(String user) throws Throwable {
        Assert.assertTrue(UserHandler.isUserContained(user));
    }

    @Then("^user \"([^\"]*)\" is deleted$")
    public void userIsDeleted(String user) throws Throwable {
        Assert.assertFalse(UserHandler.isUserActive(user));
    }

    @Then("^user \"([^\"]*)\" phone is \"([^\"]*)\"$")
    public void userPhoneIs(String user, String phone) throws Throwable {
        Assert.assertEquals(phone, UserHandler.getUserPhone(user));

    }

    @Then("^user \"([^\"]*)\" scan storage is \"([^\"]*)\"$")
    public void userScanStorageIs(String user, String storage) throws Throwable {
        Assert.assertEquals(storage,UserHandler.getUserStorage(user));

    }

    @Then("^user \"([^\"]*)\" has delegate \"([^\"]*)\"$")
    public void userHasDelegate(String user, String delegate) throws Throwable {
        String userId = UserHandler.getUserID(user);
        String delegateid = UserHandler.getUserDelegate(userId);
        String entityName = UserHandler.getEntiyName(delegateid);
        Assert.assertEquals(entityName,delegate);

    }
}
