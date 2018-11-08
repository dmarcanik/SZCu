package cz.sazka.tests.LotteryUtils;

import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

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
     * @param columnCount number of columns in particular ber.
     * @param numberCount count of numbers for each column.
     * @param winningNumberCount count of winning numbers for each column.
     * @param loteryKind name of lottery.
     * @param addNumberCount number of additional numbers.
     * @param addFeature param which defines if additional numbers should be set to win or lose.
     * @param deposit value of deposit.
     * @param kingsGame if kralovska hra should be enabled or not.
     * During wager creation are saved waged data.
     */

    public static void generateWager(int columnCount, int numberCount, int winningNumberCount, String loteryKind,
                                     int addNumberCount, String addFeature, int deposit, boolean kingsGame, String chance) {

        if (ElementHandler.getIdCssElement(Helpers.locatorMap("close")).isDisplayed()) {
            new ClickStep().click(Helpers.locatorMap("close"));
        }
        if (ElementHandler.getElementArray(Helpers.getDataColumnIndex()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }
        WagerCreator.setChance(loteryKind,chance);
        ArrayList<Integer> addNumCountList = new ArrayList<>();
        ArrayList<Integer> numCountList = new ArrayList<>();
        ArrayList<Integer> depositList = new ArrayList<>();


        for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
            ElementHandler.waitElementLoadedBy(ElementHandler.getIdBy(Helpers.locatorMap("add")));
            new ClickStep().click(Helpers.locatorMap("add"));
            ArrayList<Integer> numList = new ArrayList<>();
            ArrayList<Integer> addNumList = new ArrayList<>();
            numCountList.add(currentColumn, numberCount);
            addNumCountList.add(currentColumn, addNumberCount);
            if (loteryKind.equals("stastnych10")|| loteryKind.equals("keno")) {
                WagerCreator.setWagerFeatures(numberCount, deposit, kingsGame);
                depositList.add(currentColumn, deposit);
            }
            else {
                depositList.add(currentColumn,LotteryInfo.getLotteryColumnPrice(loteryKind));
            }
            for (int currentNumber = 0; currentNumber < numberCount; currentNumber++) {

                if (currentNumber < winningNumberCount) {
                    int winNumber = LotteryNumGenerator.getLotteryWinNum(loteryKind, winningNumberCount);
                    WebElement webElement;
                    webElement = ElementHandler.getDialogColumnEl(winNumber);
                    ElementHandler.waitElementLoadedEl(webElement);
                    webElement.click();
                    numList.add(currentNumber, winNumber);
                } else {
                    int losNumber = LotteryNumGenerator.getLotteryLosNum(loteryKind, winningNumberCount, numberCount);
                    WebElement webElement;
                    webElement = ElementHandler.getDialogColumnEl(losNumber);
                    webElement.click();
                    numList.add(currentNumber, losNumber);
                }
            }
            WagerStorage.storeNumbers(currentColumn, numList);
            if (extraWaged = addFeature.equals("win")) {
                for (int currentAddNumber = 0; currentAddNumber < addNumberCount; currentAddNumber++) {
                    int winAddNumber = LotteryNumGenerator.getLotteryAddWinNum(loteryKind);
                    WebElement webElement = ElementHandler.getAdditionalColumnEl(winAddNumber);
                    ElementHandler.waitElementLoadedEl(webElement);
                    webElement.click();
                    addNumList.add(currentAddNumber, winAddNumber);
                }
                extraWaged = true;


            } else if (extraWaged = addFeature.equals("lose")) {
                for (int currentAddNumber = 0; currentAddNumber < addNumberCount; currentAddNumber++) {
                    int losAddNumber = LotteryNumGenerator.getLotteryAddLosNum(loteryKind);
                    WebElement webElement = ElementHandler.getAdditionalColumnEl(losAddNumber);
                    ElementHandler.waitElementLoadedEl(webElement);
                    webElement.click();
                    addNumList.add(currentAddNumber, losAddNumber);
                }
                extraWaged = true;
            }
            WagerStorage.storeAddNumbers(currentColumn, addNumList);

            new ClickStep().click(Helpers.locatorMap("save"));

        }
        WagerStorage.storeNumCountList(numCountList);
        WagerStorage.storeAddNumCountList(addNumCountList);
        WagerStorage.storeColumnCount(columnCount);
        WagerStorage.storeAddNumberCount(addNumberCount);
        WagerStorage.storenumberCount(numberCount);
        WagerStorage.storeLotteryKind(loteryKind);
        WagerStorage.storeDeposit(depositList);

    }
}
