package cz.sazka.tests.Steps;

import cucumber.api.java.en.Then;
import cz.sazka.tests.LotteryUtils.LotteryNumGenerator;
import cz.sazka.tests.LotteryUtils.WagerChecker;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.junit.Assert;

public class CheckWagerSteps {

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Wait until wager is saved.
     */
    @Then("^wager is saved with correct price$")
    public static void wagerIsSaved() throws Throwable {
        String currentLotery = WagerStorage.getLotteryKind();
        int priceForWager = LotteryNumGenerator.getLotteryPrice(currentLotery, WagerStorage.isChanceEnabled());
        PreconditionsSteps.waitForPresence(ElementHandler.getIdBy(Helpers.locatorMap("wagerSaved")));
        String realPriceString = ElementHandler.getIdCssElement(Helpers.locatorMap("wagerSaved")).getText();
        realPriceString = realPriceString.replaceAll("\\D+", "");
        int truePrice = Integer.valueOf(realPriceString);
        System.out.println(truePrice);
        Assert.assertEquals(priceForWager, truePrice);
    }

    /**
     * Navigates to Moje sazky of currently logged user.
     * Waits until currently active bets are displayed.
     * Calls checkgenerated wagers.
     */
    @Then("^wager is correctly displayed in Moje sázky$")
    public void wagerIsInMojeSazky() throws Throwable {
        NavigateSteps.navigateToMojeSazky();
        WagerChecker.checkGeneratedWagers();
        WagerStorage.cleanStorage();
    }

    @Then("^Quick Sportka wager for \"(10 sloupcu|5 sloupcu|1 sloupec)\" is correctly saved in Moje sázky$")
    public void quickSporkaWagerSaved(String wagerType) throws Throwable {
        NavigateSteps.navigateToMojeSazky();
        switch (wagerType) {
            case "10 sloupcu":
                WagerChecker.checkQuickWager("sportka", 10, true, false, 220);
                break;
            case "5 sloupcu":
                WagerChecker.checkQuickWager("sportka", 5, false, false, 100);
                break;
            case "1 sloupec":
                WagerChecker.checkQuickWager("sportka", 1, true, false, 40);
                break;
        }


    }
}
