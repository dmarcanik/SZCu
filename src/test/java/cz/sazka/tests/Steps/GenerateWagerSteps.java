package cz.sazka.tests.Steps;

import cucumber.api.java.en.And;
import cz.sazka.tests.LotteryUtils.WagerFeatures;
import cz.sazka.tests.LotteryUtils.WagerGenerator;
import cz.sazka.tests.Storage.WagerStorage;

public class GenerateWagerSteps {


    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     * @param columnCount   number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     * @param draw which day of draw should be selected.
     * @param chance chance configuration.
     * @param duration for how many times should be wager activated.
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
        else {
            WagerStorage.setDurationCount(1);
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
     * @param draw which day of draw should be selected.
     * @param chance chance configuration.
     * @param duration for how many times should be wager activated.
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
        else {
            WagerStorage.setDurationCount(1);
        }
    }

    /**
     * Clean all pre-filled columns in currently opened wager.
     * Calls generateWager with predefined and variable params for this particular lottery.
     *
     * @param columnCount   number of columns.
     * @param winningNumbrs number of winning numbers, that should be generated.
     * @param addFeature    keyword which defines which aditional numbers should be generated.
     * @param draw which day of draw should be selected.
     * @param chance chance configuration.
     * @param duration for how many times should be wager activated.
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
        else {
            WagerStorage.setDurationCount(1);
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
     * @param draw which day of draw should be selected.
     * @param chance chance configuration.
     * @param duration for how many times should be wager activated.
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
        else {
            WagerStorage.setDurationCount(1);
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
}
