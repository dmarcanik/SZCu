package cz.sazka.tests.LotteryUtils;

import cucumber.api.DataTable;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Steps.GenerateWagerSteps;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLBRElement;

import java.util.ArrayList;
import java.util.Map;

public class WagerCreator {
    private static Logger log = LogManager.getRootLogger();
    private static String prvniHraciPole = Helpers.getDataColumn("0");
    private static String druheHraciPole = Helpers.getDataColumn("1");
    private static String pocetCisel = Helpers.getClassCssContains("keno-wager-count");
    private static String cisla = Helpers.getClassCssContains("keno-ticket");
    private static String vklad = Helpers.getClassCssContains("keno-bet-amount");

    public static void createKenoWager(DataTable data, int numberCount) {
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {
            String numbers = columnData.get("numbers");
            String[] splittedNumbers = numbers.split(",");
            int deposit = Integer.parseInt(columnData.get("vklad"));
            String numCountString = String.valueOf(numberCount);
            String depositString = String.valueOf(deposit);
            if (columnData.size() < 1) {
                String pocetCiselZPole = Helpers.getMergedCssChild(prvniHraciPole, pocetCisel);
                String cislo = ">label>[value=\"" + numCountString + "\"]";
                By aktualniCislo = ElementHandler.getBy(Helpers.getMergedCssChild(pocetCiselZPole,cislo));
                ElementHandler.clickOn(aktualniCislo);
            }

        }


    }


    /**
     * Creates wager for desired lottery from datatable passed from keyword.
     *
     * @param lottery lottery name
     * @param data    defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    public static void createWager(String lottery, DataTable data, String sance) {
        WagerFeatures.cleanAllColumns();
        if (!lottery.equals("keno")) {
            WagerFeatures.setChance(lottery, sance);
        }
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> addNumList = new ArrayList<>();
        ArrayList<Integer> numCountList = new ArrayList<>();
        ArrayList<Integer> depositList = new ArrayList<>();
        int currentColumn = 0;
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {
            String addButton = Helpers.locatorMap("add");
            new ClickStep().click(addButton);
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
                ElementHandler.clickCmd(ElementHandler.getDialogColumnEl(num));
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
                    ElementHandler.clickCmd(ElementHandler.getAdditionalColumnEl(addNum));

                }

            }
            String saveButton = Helpers.locatorMap("save");
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
