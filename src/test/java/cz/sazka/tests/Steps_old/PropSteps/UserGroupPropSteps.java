package cz.sazka.tests.Steps_old.PropSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.Db.UserGroupHandler;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class UserGroupPropSteps {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    @And("^I open user group \"([^\"]*)\"$")
    public void iOpenGroup(String groupName) throws Throwable {
        String groupId = UserGroupHandler.getUserGroupId(groupName);
        String url = webDriver.getCurrentUrl();
        url = java.net.URLDecoder.decode(url, "UTF-8");
        String newEndpoint = url.replaceAll("^([^{]+)(.+)$", "$1" + Helpers.getUserGroupHash(groupId));
        webDriver.navigate().to(newEndpoint);
        ElementHandler.waitAjaxComplete();

    }

    @Then("^User Group \"([^\"]*)\" is inside \"([^\"]*)\"$")
    public void userGroupIsInside(String subGroup, String mainGroup) throws Throwable {
        if (!mainGroup.equals("All users")){
            String subgroupParent = UserGroupHandler.getUserGroupParentId(subGroup);
            String mainGroupId = UserGroupHandler.getUserGroupId(mainGroup);
            Assert.assertEquals(mainGroupId,subgroupParent);

        }


    }

    @Then("^User Group \"([^\"]*)\" is in database$")
    public void userGroupIsInDatabase(String group) throws Throwable {
        Assert.assertTrue(UserGroupHandler.isUserGroupContained(group));

    }
}
