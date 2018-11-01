package cz.sazka.tests.Steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cz.sazka.tests.LotteryUtils.WagerChecker;
import cz.sazka.tests.LotteryUtils.WagerCreator;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;

import java.util.Map;


public class WagerSteps {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();


    @And("^I generate \"([^\"]*)\" column \"(sportka|euromilliony|stastnych10|eurojackpot)\" wager with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and \"([^\"]*)\" extra numbers set to \"(win|lose|none)\"$")
    public void iCreateColumnTicketWithNumbersAndWinning(int columnCount, String loteryKind, int numberCount, int winNumberCount, int exNumberCount, String addFeature) throws Throwable {
        WagerCreator.cleanAllColumns();
        WagerCreator.generateWager(columnCount, numberCount, winNumberCount, loteryKind, exNumberCount, addFeature, 0, false);

    }

    @And(("^I generate \"([^\"]*)\" column sportka wager with \"([^\"]*)\" winning numbers$"))
    public void iCreateSportkaWager(int columnCount, int winningNumbrs) {
        WagerCreator.cleanAllColumns();
        WagerCreator.generateWager(columnCount, 6, winningNumbrs, "sportka", 0, "none", 0, false);

    }

    @And(("^I generate \"([^\"]*)\" column eurojackpot wager with \"([^\"]*)\" winning numbers and extra numbers set to \"(win|lose|none)\"$"))
    public void iCreateEurojackpotWager(int columnCount, int winningNumbrs, String addFeature) {
        WagerCreator.cleanAllColumns();
        WagerStorage.enableAddNumbers();
        WagerCreator.generateWager(columnCount, 5, winningNumbrs, "eurojackpot", 2, addFeature, 0, false);
    }

    @And(("^I generate \"([^\"]*)\" column euromilliony wager with \"([^\"]*)\" winning numbers and extra number set to \"(win|lose|none)\"$"))
    public void iCreateEuroMilionyWager(int columnCount, int winningNumbrs, String addFeature) {
        WagerCreator.cleanAllColumns();
        WagerStorage.enableAddNumbers();
        WagerCreator.generateWager(columnCount, 7, winningNumbrs, "euromilliony", 1, addFeature, 0, false);
    }

    @And(("^I generate \"([^\"]*)\" column stastnych 10 wager with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and vklad set to \"([^\"]*)\" královska hra \"(ano|ne)\"$"))
    public void iCreateStastnych10Wager(int columnCount, int numberCount, int winningNumbrs, int deposit, String kralovskaHra) {
        WagerCreator.cleanAllColumns();
        boolean kingsGame = false;
        if (kralovskaHra.equals("ano")) {
            kingsGame = true;
        }
        WagerCreator.generateWager(columnCount, numberCount, winningNumbrs, "stastnych10", 0, "none", deposit, kingsGame);
    }


    @Then("^wager is saved$")
    public void wagerIsSaved() throws Throwable {
        PreconditionsSteps.waitForPresence(ElementHandler.getIdBy(Helpers.locatorMap("wagerSaved")));
    }

    @Then("^wager is correctly displayed in Moje sázky$")
    public void wagerIsInMojeSazky() throws Throwable {
        new ClickStep().click(Helpers.locatorMap("myWagers"));
        ElementHandler.waitElementLoaded(Helpers.locatorMap("wagerList"));
        WagerChecker.checkGeneratedWagers();
    }


    @And("^I create \"(sportka|euromilliony|stastnych10|eurojackpot)\" wager with declared numbers$")
    public void iCreateWagerWithNumbers(String lottery, DataTable data) throws Throwable {
        if (lottery.contains("euromilliony")||lottery.contains("eurojackpot")){
            WagerStorage.enableAddNumbers();
        }
        WagerCreator.createWager(lottery, data);

    }
    @And("^I create sportka wager with draw set to \"(streda|nedele|streda,nedele|patek)\"$")
    public void iCreateSportkaWager(String draw, DataTable dataTable){
        WagerCreator.createWager("sportka",dataTable);
        WagerCreator.selectDrawDate(draw, "sportka");

    }
    @And("^I create Eurojackpot wager with draw set to \"(patek)\"$")
    public void iCreateEurojackpotWager(String draw, DataTable dataTable){
        WagerCreator.createWager("eurojackpot",dataTable);
        WagerCreator.selectDrawDate(draw, "eurojackpot");

    }
    @And("^I create Euromiliony wager with draw set to \"(sobota)\"$")
    public void iCreateEuroMilionyWager(String draw, DataTable dataTable){
        WagerCreator.createWager("euromilliony",dataTable);
        WagerCreator.selectDrawDate(draw, "euromiliony");

    }
    @And("^I create Stastnych 10 wager with vklad set to \"([^\"]*)\" královska hra \"(ano|ne)\" draw set to \"(poledne|vecer|poledne,vecer)\"$")
    public void iCreateStastnych10Wager(int deposit, String kingsgame,String draw, DataTable dataTable){
        WagerCreator.createWager("stastnych10",dataTable);
        WagerCreator.selectDrawDate(draw, "stastnych10");

    }

}
