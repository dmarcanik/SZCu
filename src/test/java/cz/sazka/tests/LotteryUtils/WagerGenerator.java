package cz.sazka.tests.LotteryUtils;

import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class WagerGenerator {
    private static Logger log = LogManager.getRootLogger();
    private static boolean extraWaged;

    public WagerGenerator() {
        extraWaged = false;
    }

    /**
     * Automatically generates wager according delivered parameteres. This method is usable for all currently implemeted lotteries.
     *
     * @param columnCount        number of columns in particular ber.
     * @param numberCount        count of numbers for each column.
     * @param winningNumberCount count of winning numbers for each column.
     * @param loteryKind         name of lottery.
     * @param addNumberCount     number of additional numbers.
     * @param addFeature         param which defines if additional numbers should be set to win or lose.
     * @param deposit            value of deposit.
     * @param kingsGame          if kralovska hra should be enabled or not.
     *                           During wager creation are saved waged data.
     */

    public static void generateWager(int columnCount, int numberCount, int winningNumberCount, String loteryKind,
                                     int addNumberCount, String addFeature, int deposit, boolean kingsGame, String chance) {
        String close = Helpers.locatorMap("close");
        if (ElementHandler.getIdCssElement(close).isDisplayed()) {
            new ClickStep().click(close);
        }
        if (ElementHandler.getElementArray(Helpers.getAllColumns()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }
        WagerFeatures.setChance(loteryKind, chance);
        ArrayList<Integer> numCountList = new ArrayList<>();
        ArrayList<Integer> depositList = new ArrayList<>();


        for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
            String addButton = Helpers.locatorMap("add");
            ElementHandler.waitElementLoadedBy(ElementHandler.getIdBy(addButton));
            new ClickStep().click(addButton);
            ArrayList<Integer> numList = new ArrayList<>();
            ArrayList<Integer> addNumList = new ArrayList<>();
            numCountList.add(currentColumn, numberCount);
            if (loteryKind.equals("stastnych10") || loteryKind.equals("keno")) {
                WagerFeatures.setColumnFeatures(numberCount, deposit, kingsGame);
                if (kingsGame) {
                    depositList.add(currentColumn, deposit * 2);

                } else {
                    depositList.add(currentColumn, deposit);
                }

            } else {
                depositList.add(currentColumn, LotteryInfo.getLotteryColumnPrice(loteryKind));
            }
            for (int currentNumber = 0; currentNumber < numberCount; currentNumber++) {

                if (currentNumber < winningNumberCount) {
                    int winNumber = LotteryNumGenerator.getLotteryWinNum(loteryKind, winningNumberCount);
                    ElementHandler.clickOn(ElementHandler.getColumnNumber(String.valueOf(winNumber)));
                    numList.add(currentNumber, winNumber);
                } else {
                    int losNumber = LotteryNumGenerator.getLotteryLosNum(loteryKind, winningNumberCount, numberCount);
                    ElementHandler.clickOn(ElementHandler.getColumnNumber(String.valueOf(losNumber)));
                    numList.add(currentNumber, losNumber);
                }
            }
            WagerStorage.storeNumbers(currentColumn, numList);
            if (extraWaged = addFeature.equals("win")) {
                for (int currentAddNumber = 0; currentAddNumber < addNumberCount; currentAddNumber++) {
                    int winAddNumber = LotteryNumGenerator.getLotteryAddWinNum(loteryKind);
                    ElementHandler.clickOn(ElementHandler.getAddColumnNumber(String.valueOf(winAddNumber)));
                    addNumList.add(currentAddNumber, winAddNumber);
                }
                extraWaged = true;


            } else if (extraWaged = addFeature.equals("lose")) {
                for (int currentAddNumber = 0; currentAddNumber < addNumberCount; currentAddNumber++) {
                    int losAddNumber = LotteryNumGenerator.getLotteryAddLosNum(loteryKind);
                    ElementHandler.clickOn(ElementHandler.getAddColumnNumber(String.valueOf(losAddNumber)));
                    addNumList.add(currentAddNumber, losAddNumber);
                }
                extraWaged = true;
            }
            WagerStorage.storeAddNumbers(currentColumn, addNumList);
            String saveButton = Helpers.locatorMap("save");
            new ClickStep().click(saveButton);

        }
        WagerStorage.storeNumCountList(numCountList);
        WagerStorage.storeColumnCount(columnCount);
        WagerStorage.storeLotteryKind(loteryKind);
        WagerStorage.storeDeposit(depositList);

    }
}
