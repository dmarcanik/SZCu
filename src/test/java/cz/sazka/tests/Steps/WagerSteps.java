package cz.sazka.tests.Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.LotteryUtils.*;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class WagerSteps {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();


    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     *
     * @param columnCount   number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     */
    @And(("^I generate \"([^\"]*)\" column sportka wager with \"([^\"]*)\" winning numbers and Šance set to " +
            "\"(Z,Y|X,Z|Z,0|none)\" with draw set to \"(streda|nedele|streda,nedele|patek)\", předpladné set to \"([^\"]*)\"$"))
    public void iCreateSportkaWager(int columnCount, int winningNumbrs, String chance, String draw, String duration) {
        WagerFeatures.cleanAllColumns();
        WagerGenerator.generateWager(columnCount, 6, winningNumbrs, "sportka", 0, "none", 0, false, chance);
        WagerFeatures.selectDrawDate(draw,"sportka");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"sportka");
        }
        WagerStorage.disableAddNumbers();


    }

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     *
     * @param columnCount   number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     * @param addFeature    keyword which defines which aditional numbers should be generated.
     */
    @And(("^I generate \"([^\"]*)\" column eurojackpot wager with \"([^\"]*)\" winning numbers and extra numbers set to " +
            "\"(win|lose|none)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\" with with draw set to \"(patek)\", předpladné set to \"([^\"]*)\"$"))
    public void iCreateEurojackpotWager(int columnCount, int winningNumbrs, String addFeature, String chance, String draw, String duration) {
        WagerFeatures.cleanAllColumns();
        WagerStorage.enableAddNumbers();
        WagerGenerator.generateWager(columnCount, 5, winningNumbrs, "eurojackpot", 2, addFeature, 0, false, chance);
        WagerFeatures.selectDrawDate(draw,"eurojackpot");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"eurojackpot");
        }
    }

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     *
     * @param columnCount   number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     * @param addFeature    keyword which defines which aditional numbers should be generated.
     */
    @And(("^I generate \"([^\"]*)\" column euromilliony wager with \"([^\"]*)\" winning numbers and extra number set to " +
            "\"(win|lose|none)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\" with draw set to \"(sobota|utery)\", předpladné set to \"([^\"]*)\"$"))
    public void iCreateEuroMilionyWager(int columnCount, int winningNumbrs, String addFeature, String chance, String draw, String duration) {
        WagerFeatures.cleanAllColumns();
        WagerStorage.enableAddNumbers();
        WagerGenerator.generateWager(columnCount, 7, winningNumbrs, "euromilliony", 1, addFeature, 0, false, chance);
        WagerFeatures.selectDrawDate(draw, "euromilliony");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"euromilliony");
        }
    }

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     *
     * @param columnCount   number of columns.
     * @param numberCount   how many numbers should be in column.
     * @param winningNumbrs number of winning numbers, that should be generated for every column.
     * @param deposit       value of deposit in each column.
     * @param kralovskaHra  keyword which defines if should be kralovska hra activated or not in each column.
     */
    @And(("^I generate \"([^\"]*)\" column stastnych 10 wager with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and vklad " +
            "set to \"([^\"]*)\" královska hra \"(ano|ne)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\" with draw set to \"(poledne|vecer|poledne,vecer)\", předpladné set to \"([^\"]*)\"$"))
    public void iCreateStastnych10Wager(int columnCount, int numberCount, int winningNumbrs, int deposit, String kralovskaHra, String chance, String draw, String duration) {
        WagerFeatures.cleanAllColumns();
        boolean kingsGame = false;
        if (kralovskaHra.equals("ano")) {
            kingsGame = true;
        }
        WagerGenerator.generateWager(columnCount, numberCount, winningNumbrs, "stastnych10", 0, "none", deposit, kingsGame, chance);
        WagerFeatures.selectDrawDate(draw, "stastnych10");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"euromilliony");
        }
        WagerStorage.disableAddNumbers();
    }

    @And(("^I generate \"([^\"]*)\" column Keno wager with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and vklad set to " +
            "\"([^\"]*)\"$"))
    public void icreateKenoWager(int columnCount, int numberCount, int winningNumbrs, int deposit) {
        WagerFeatures.cleanAllColumns();
        WagerGenerator.generateWager(columnCount, numberCount, winningNumbrs, "keno", 0, "none", deposit, false, "none");
        WagerStorage.storeDrawCount(1);
        WagerStorage.disableAddNumbers();
    }

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Wait until wager is saved.
     */
    @Then("^wager is saved with correct price$")
    public static void wagerIsSaved() throws Throwable {
        String currentLotery = WagerStorage.getLotteryKind();
        int priceForWager = LotteryNumGenerator.getLotteryPrice(currentLotery,WagerStorage.isChanceEnabled());
        PreconditionsSteps.waitForPresence(ElementHandler.getIdBy(Helpers.locatorMap("wagerSaved")));
        String realPriceString = ElementHandler.getIdCssElement(Helpers.locatorMap("wagerSaved")).getText();
        realPriceString = realPriceString.replaceAll("\\D+","");
        int truePrice = Integer.valueOf(realPriceString);
        System.out.println(truePrice);
        Assert.assertEquals(priceForWager, truePrice);
    }

    public static void main(String[] args) throws Throwable {
        wagerIsSaved();
    }

    /**
     * Navigates to Moje sazky of currently logged user.
     * Waits until currently active bets are displayed.
     * Calls checkgenerated wagers.
     */
    @Then("^wager is correctly displayed in Moje sázky$")
    public void wagerIsInMojeSazky() throws Throwable {
        new ClickStep().click(Helpers.locatorMap("myWagers"));
        ElementHandler.waitElementLoaded(Helpers.locatorMap("wagerList"));
        WagerChecker.checkGeneratedWagers();
    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create sportka wager with draw set to \"(streda|nedele|streda,nedele|patek)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateSportkaWager(String draw, String sance,String duration, DataTable dataTable) {
        WagerCreator.createWager("sportka", dataTable, sance);
        WagerFeatures.selectDrawDate(draw, "sportka");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"sportka");
        }


    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Eurojackpot wager with draw set to \"(patek)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateEurojackpotWager(String draw, String sance,String duration, DataTable dataTable) {
        WagerCreator.createWager("eurojackpot", dataTable, sance);
        WagerFeatures.selectDrawDate(draw, "eurojackpot");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"eurojackpot");
        }
    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Euromiliony wager with draw set to \"(sobota|utery)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateEuroMilionyWager(String draw, String sance,String duration, DataTable dataTable) {
        WagerCreator.createWager("euromilliony", dataTable, sance);
        WagerFeatures.selectDrawDate(draw, "euromiliony");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"euromiliony");
        }

    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Stastnych 10 wager with draw set to \"(poledne|vecer|poledne,vecer)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateStastnych10Wager(String draw, String sance,String duration, DataTable dataTable) {
        WagerCreator.createWager("stastnych10", dataTable, sance);
        WagerFeatures.selectDrawDate(draw, "stastnych10");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"stastnych10");
        }


    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Keno wager$")
    public void iCreateKenoWager(DataTable dataTable) {
        WagerCreator.createWager("keno", dataTable, "none");
        WagerStorage.storeDrawCount(1);



    }

}
