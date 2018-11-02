package cz.sazka.tests.Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.LotteryUtils.WagerChecker;
import cz.sazka.tests.LotteryUtils.WagerCreator;
import cz.sazka.tests.LotteryUtils.WagerGenerator;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class WagerSteps {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();


    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     * @param columnCount number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     */
    @And(("^I generate \"([^\"]*)\" column sportka wager with \"([^\"]*)\" winning numbers$"))
    public void iCreateSportkaWager(int columnCount, int winningNumbrs) {
        WagerCreator.cleanAllColumns();
        WagerGenerator.generateWager(columnCount, 6, winningNumbrs, "sportka", 0, "none", 0, false);

    }
    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     * @param columnCount number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     * @param addFeature keyword which defines which aditional numbers should be generated.
     */
    @And(("^I generate \"([^\"]*)\" column eurojackpot wager with \"([^\"]*)\" winning numbers and extra numbers set to \"(win|lose|none)\"$"))
    public void iCreateEurojackpotWager(int columnCount, int winningNumbrs, String addFeature) {
        WagerCreator.cleanAllColumns();
        WagerStorage.enableAddNumbers();
        WagerGenerator.generateWager(columnCount, 5, winningNumbrs, "eurojackpot", 2, addFeature, 0, false);
    }
    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     * @param columnCount number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     * @param addFeature keyword which defines which aditional numbers should be generated.
     */
    @And(("^I generate \"([^\"]*)\" column euromilliony wager with \"([^\"]*)\" winning numbers and extra number set to \"(win|lose|none)\"$"))
    public void iCreateEuroMilionyWager(int columnCount, int winningNumbrs, String addFeature) {
        WagerCreator.cleanAllColumns();
        WagerStorage.enableAddNumbers();
        WagerGenerator.generateWager(columnCount, 7, winningNumbrs, "euromilliony", 1, addFeature, 0, false);
    }
    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     * @param columnCount number of columns.
     * @param numberCount how many numbers should be in column.
     * @param winningNumbrs number of winning numbers, that should be generated for every column.
     * @param deposit value of deposit in each column.
     * @param kralovskaHra keyword which defines if should be kralovska hra activated or not in each column.
     */
    @And(("^I generate \"([^\"]*)\" column stastnych 10 wager with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and vklad set to \"([^\"]*)\" královska hra \"(ano|ne)\"$"))
    public void iCreateStastnych10Wager(int columnCount, int numberCount, int winningNumbrs, int deposit, String kralovskaHra) {
        WagerCreator.cleanAllColumns();
        boolean kingsGame = false;
        if (kralovskaHra.equals("ano")) {
            kingsGame = true;
        }
        WagerGenerator.generateWager(columnCount, numberCount, winningNumbrs, "stastnych10", 0, "none", deposit, kingsGame);
    }

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Wait until wager is saved.
     */
    @Then("^wager is saved$")
    public void wagerIsSaved() throws Throwable {
        PreconditionsSteps.waitForPresence(ElementHandler.getIdBy(Helpers.locatorMap("wagerSaved")));
    }

    /**
     *Navigates to Moje sazky of currently logged user.
     *Waits until currently active bets are displayed.
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
     * @param draw keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create sportka wager with draw set to \"(streda|nedele|streda,nedele|patek)\"$")
    public void iCreateSportkaWager(String draw, DataTable dataTable){
        WagerCreator.createWager("sportka",dataTable);
        WagerCreator.selectDrawDate(draw, "sportka");

    }
    /**
     * Creates wager according data table defined in keywords.
     * @param draw keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Eurojackpot wager with draw set to \"(patek)\"$")
    public void iCreateEurojackpotWager(String draw, DataTable dataTable){
        WagerCreator.createWager("eurojackpot",dataTable);
        WagerCreator.selectDrawDate(draw, "eurojackpot");

    }
    /**
     * Creates wager according data table defined in keywords.
     * @param draw keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Euromiliony wager with draw set to \"(sobota)\"$")
    public void iCreateEuroMilionyWager(String draw, DataTable dataTable){
        WagerCreator.createWager("euromilliony",dataTable);
        WagerCreator.selectDrawDate(draw, "euromiliony");

    }
    /**
     * Creates wager according data table defined in keywords.
     * @param draw keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Stastnych 10 wager with vklad set to \"([^\"]*)\" královska hra \"(ano|ne)\" draw set to \"(poledne|vecer|poledne,vecer)\"$")
    public void iCreateStastnych10Wager(String draw, DataTable dataTable){
        WagerCreator.createWager("stastnych10",dataTable);
        WagerCreator.selectDrawDate(draw, "stastnych10");

    }/**
     * Creates wager according data table defined in keywords.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Keno wager$")
    public void iCreateKenoWager( DataTable dataTable){
        WagerCreator.createWager("keno",dataTable);


    }

}
