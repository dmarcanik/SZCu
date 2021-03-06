package cz.sazka.tests.LotteryUtils;

import cucumber.api.DataTable;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Map;

public class WagerCreator {
    private static Logger log = LogManager.getRootLogger();
    private static String hraciPole;
    private static String pocetCisel;
    private static String saveButton = Helpers.locatorMap("save");
    private static String addButton = Helpers.locatorMap("add");
    private static ArrayList<Integer> numList = new ArrayList<>();
    private static ArrayList<Integer> addNumList = new ArrayList<>();
    private static ArrayList<Integer> numCountList = new ArrayList<>();
    private static ArrayList<Integer> depositList = new ArrayList<>();

    public static void createKenoWager(DataTable data) {
        int gameField = 0;
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {
            String[] splittedNumbers = splitString(columnData.get("numbers"), ",");
            int numberCount = splittedNumbers.length;
            selectNumberCount(gameField, numberCount);
            numCountList.add(gameField,numberCount);
            int numCount = 0;
            for (String number: splittedNumbers){
                int desiredNumber = Integer.valueOf(number);
                selectNumber(gameField,desiredNumber);
                numList.add(numCount,desiredNumber);
            }
            int deposit = Integer.valueOf(columnData.get("vklad"));
            selectDeposit(gameField,deposit);
            depositList.add(gameField,deposit);

            WagerStorage.storeNumbers(gameField,numList);
            WagerStorage.storeDeposit(depositList);
            WagerStorage.storeNumCountList(numCountList);
            WagerStorage.storeLotteryKind("keno");
            WagerStorage.storeColumnCount(gameField);
            gameField++;
        }


    }

    public static void selectNumberCount(int gameField, int value) {
        ElementHandler.clickOn(ElementHandler.getKenoNumberCount(String.valueOf(gameField),String.valueOf(value)));
    }
    public static void selectNumber(int gameField, int value) {
        ElementHandler.clickOn(ElementHandler.getKenoNumbers(String.valueOf(gameField),String.valueOf(value)));
    }
    public static void selectDeposit(int gameField, int value) {
        ElementHandler.clickOn(ElementHandler.getKenoDeposit(String.valueOf(gameField),String.valueOf(value)));
    }


    public static String[] splitString(String values, String regex) {
        return values.split(regex);
    }

    /**
     * Creates wager for desired lottery from datatable passed from keyword.
     *
     * @param lottery lottery name
     * @param data    defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    public static void createBigLotteryWager(String lottery, DataTable data, String sance) {
        WagerFeatures.cleanAllColumns();
        if (!lottery.equals("keno")) {
            WagerFeatures.setChance(lottery, sance);
        }
        int currentColumn = 0;
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {
            new ClickStep().click(addButton);
            String[] splittedNumbers = splitString(columnData.get("numbers"), ",");
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
                ElementHandler.clickOn(ElementHandler.getColumnNumber(splittedNumber));
                currentNumber++;

            }
            numCountList.add(currentColumn, currentNumber);


            if (columnData.get("additional") != null) {
                String[] splittedAdditional = splitString(columnData.get("additional"), ",");
                int currentAddNumber = 0;
                for (String splittedAddNum : splittedAdditional) {
                    int addNum = Integer.parseInt(splittedAddNum);
                    addNumList.add(currentAddNumber, addNum);
                    log.info("waging " + lottery + " additional number " + addNum);
                    ElementHandler.clickOn(ElementHandler.getAddColumnNumber(splittedAddNum));

                }

            }

            new ClickStep().click(saveButton);
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
