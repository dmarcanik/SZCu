package cz.sazka.tests.LotteryUtils;

import cucumber.api.DataTable;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Map;

public class WagerCreator {
    private static Logger log = LogManager.getRootLogger();




    /**
     * Creates wager for desired lottery from datatable passed from keyword.
     *
     * @param lottery lottery name
     * @param data    defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    public static void createWager(String lottery, DataTable data, String sance) {
        new ClickStep().click(Helpers.locatorMap("close"));
        if (!lottery.equals("keno")) {
            WagerFeatures.setChance(lottery, sance);
        }

        WagerFeatures.cleanAllColumns();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> addNumList = new ArrayList<>();
        ArrayList<Integer> numCountList = new ArrayList<>();
        ArrayList<Integer> depositList = new ArrayList<>();
        int currentColumn = 0;
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {

            new ClickStep().click(Helpers.locatorMap("add"));
            String numbers = columnData.get("numbers");
            String[] splittedNumbers = numbers.split(",");
            if (columnData.get("vklad") != null) {
                boolean kingsGame;
                int deposit = Integer.parseInt(columnData.get("vklad"));
                if (columnData.get("kralovskahra") != null) {
                    kingsGame = columnData.get("kralovskahra").contains("ano");
                    if (kingsGame) {
                        WagerFeatures.setColumnFeatures(splittedNumbers.length, deposit, true);
                        depositList.add(currentColumn, deposit * 2);

                    } else {
                        WagerFeatures.setColumnFeatures(splittedNumbers.length, deposit, false);
                        depositList.add(currentColumn, deposit);
                    }

                } else {
                    WagerFeatures.setColumnFeatures(splittedNumbers.length, deposit, false);
                    depositList.add(currentColumn, deposit);
                }


            } else {
                depositList.add(currentColumn, LotteryInfo.getLotteryColumnPrice(lottery));
            }
            int currentNumber = 0;
            for (String splittedNumber : splittedNumbers) {
                int num = Integer.parseInt(splittedNumber);
                numList.add(currentNumber, num);
                log.info("waging " + lottery + "  number " + num);
                ElementHandler.waitElementLoadedEl(ElementHandler.getDialogColumnEl(num));
                ElementHandler.getDialogColumnEl(num).click();
                currentNumber++;

            }
            numCountList.add(currentColumn, currentNumber);


            if (columnData.get("additional") != null) {
                String additional = columnData.get("additional");
                String[] splittedAdditional = additional.split(",");
                int currentAddNumber = 0;
                for (String splittedAddNum : splittedAdditional) {
                    int addNum = Integer.parseInt(splittedAddNum);
                    addNumList.add(currentAddNumber, addNum);
                    log.info("waging " + lottery + " additional number " + addNum);
                    ElementHandler.waitElementLoadedEl(ElementHandler.getAdditionalColumnEl(addNum));
                    ElementHandler.getAdditionalColumnEl(addNum).click();

                }

            }

            new ClickStep().click(Helpers.locatorMap("save"));
            WagerStorage.storeNumbers(currentColumn, numList);
            WagerStorage.storeAddNumbers(currentColumn, addNumList);
            WagerStorage.storeNumCountList(numCountList);
            WagerStorage.storeLotteryKind(lottery);
            WagerStorage.storeDeposit(depositList);
            currentColumn++;
        }
        WagerStorage.storeColumnCount(currentColumn);
    }
}
