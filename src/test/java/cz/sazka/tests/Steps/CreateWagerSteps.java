package cz.sazka.tests.Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cz.sazka.tests.LotteryUtils.*;
import cz.sazka.tests.Storage.WagerStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CreateWagerSteps {

    private static Logger log = LogManager.getRootLogger();
    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     * @param draw which day of draw should be selected.
     * @param duration for how many times should be wager activated.
     * @param chance chance configuration.
     */
    @And("^I create sportka wager with draw set to \"(streda|nedele|streda,nedele|patek)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateSportkaWager(String draw, String chance,String duration, DataTable dataTable) {
        WagerCreator.createBigLotteryWager("sportka", dataTable, chance);
        WagerFeatures.selectDrawDate(draw, "sportka");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"sportka");
        }
        else {
            WagerStorage.setDurationCount(1);
        }


    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     * @param duration for how many times should be wager activated.
     * @param chance chance configuration.
     */
    @And("^I create Eurojackpot wager with draw set to \"(patek)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateEurojackpotWager(String draw, String chance,String duration, DataTable dataTable) {
        WagerCreator.createBigLotteryWager("eurojackpot", dataTable, chance);
        WagerFeatures.selectDrawDate(draw, "eurojackpot");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"eurojackpot");
        }
        else {
            WagerStorage.setDurationCount(1);
        }
    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     * @param duration for how many times should be wager activated.
     * @param chance chance configuration.
     */
    @And("^I create Euromiliony wager with draw set to \"(sobota|utery)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateEuroMilionyWager(String draw, String chance,String duration, DataTable dataTable) {
        WagerCreator.createBigLotteryWager("euromilliony", dataTable, chance);
        WagerFeatures.selectDrawDate(draw, "euromiliony");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"euromiliony");
        }
        else {
            WagerStorage.setDurationCount(1);
        }

    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param draw      keyword of draw which should be selected during draw creation.
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     * @param duration for how many times should be wager activated.
     * @param chance chance configuration.
     */
    @And("^I create Stastnych 10 wager with draw set to \"(poledne|vecer|poledne,vecer)\" and Šance set to \"(Z,Y|X,Z|Z,0|none)\", předpladné set to \"([^\"]*)\"$")
    public void iCreateStastnych10Wager(String draw, String chance,String duration, DataTable dataTable) {
        WagerCreator.createBigLotteryWager("stastnych10", dataTable, chance);
        WagerFeatures.selectDrawDate(draw, "stastnych10");
        if (!duration.equals("1")){
            WagerFeatures.setDuration(duration,"stastnych10");
        }
        else {
            WagerStorage.setDurationCount(1);
        }


    }

    /**
     * Creates wager according data table defined in keywords.
     *
     * @param dataTable defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    @And("^I create Keno wager$")
    public void iCreateKenoWager(DataTable dataTable) {
        WagerCreator.createKenoWager( dataTable);
        WagerStorage.storeDrawCount(1);



    }

}
