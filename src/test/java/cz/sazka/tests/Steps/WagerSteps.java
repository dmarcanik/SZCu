package cz.sazka.tests.Steps;

import com.google.common.collect.Lists;
import cucumber.api.java.en.And;
import cz.sazka.tests.LotteryUtils.ColumnWorker;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import cz.sazka.tests.LotteryUtils.LotteryMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.security.InvalidParameterException;


public class WagerSteps {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();



    @And("^I create \"([^\"]*)\" column \"(sportka|euromiliony|stastnych10|eurojackpot)\" wager with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and \"([^\"]*)\" extra numbers set to \"(win|lose|none)\"$")
    public void iCreateColumnTicketWithNumbersAndWinning(int numberOfColumns, String loteryKind, int numberCount, int winningNumbers, int extraNumCount, String addFeature) throws Throwable {
        ColumnWorker.cleanAllColumns();
        ColumnWorker.fillColumns(numberOfColumns, numberCount, winningNumbers, loteryKind, extraNumCount, addFeature);

    }




}
