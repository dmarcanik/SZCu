package cz.sazka.tests.LotteryUtils;

import com.google.common.collect.Lists;
import cucumber.api.DataTable;
import cz.sazka.tests.SessionStorage.SessionStorageReader;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WagerCreator {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();
    private static String lastNum;
    private static String beforeLastNum;
    private static String[] lasTwoNums;
    private static String lastNumKey;
    private static String lastbeforeNumKey;
    private static boolean missmatched = false;


    /**
     * Set features bellow in opened wager according delivered params.
     *
     * @param numberCount count of numbers in current column.
     * @param deposit     value of deposit in current column.
     * @param kingsGame   keyword which defines if should be kralovska hra activated or not in each column.
     */
    static void setWagerFeatures(int numberCount, int deposit, boolean kingsGame) {
        String numCountString = String.valueOf(numberCount);
        String depositString = String.valueOf(deposit);
        new ClickStep().clickComboBox("drpInputsCountSelectBoxItArrow", numCountString);
        new ClickStep().clickComboBox("drpDepositSelectBoxItArrow", depositString);
        if (kingsGame) {
            new ClickStep().clickCheckbox("dialog-check-king-game");
        }
    }

    /**
     * Creates wager for desired lottery from datatable passed from keyword.
     *
     * @param lottery lottery name
     * @param data    defines numbers, additional numbers and other valid parameters for particular lottery.
     */
    public static void createWager(String lottery, DataTable data, String sance) {
        new ClickStep().click(Helpers.locatorMap("close"));
        if (!lottery.equals("keno")) {
            setChance(lottery, sance);
        }

        WagerCreator.cleanAllColumns();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> addNumList = new ArrayList<>();
        ArrayList<Integer> addNumCountList = new ArrayList<>();
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
                        setWagerFeatures(splittedNumbers.length, deposit, true);
                        depositList.add(currentColumn, deposit * 2);

                    } else {
                        setWagerFeatures(splittedNumbers.length, deposit, false);
                        depositList.add(currentColumn, deposit);
                    }

                } else {
                    setWagerFeatures(splittedNumbers.length, deposit, false);
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
                addNumCountList.add(currentColumn, currentAddNumber);

            }

            new ClickStep().click(Helpers.locatorMap("save"));
            WagerStorage.storeNumbers(currentColumn, numList);
            WagerStorage.storeAddNumbers(currentColumn, addNumList);
            WagerStorage.storeNumCountList(numCountList);
            WagerStorage.storeAddNumCountList(addNumCountList);
            WagerStorage.storeLotteryKind(lottery);
            WagerStorage.storeDeposit(depositList);
            currentColumn++;
        }
        WagerStorage.storeColumnCount(currentColumn);
    }

    /**
     * Checks which draw dates are selected and unselect them all.
     * Select desired draw dates according params:
     *
     * @param draws   draw name.
     * @param lottery lottery name.
     */
    public static void selectDrawDate(String draws, String lottery) {
        WebElement element = ElementHandler.getIdCssElement("date-picker-wrapper");
        List<WebElement> elementList = element.findElements(By.cssSelector("[for]"));
        for (WebElement button : elementList) {
            if (!button.getCssValue("background-color").contains("rgb(255, 255, 255)")) {
                button.click();
            }
        }
        int[] drawNums = DrawInfo.getAllDrawNums(draws);
        int drawCount = drawNums.length;
        WagerStorage.storeDrawCount(drawCount);
        for (int drawNum : drawNums) {
            if (lottery.equals("stastnych10")) {
                element.findElement(By.cssSelector("[data-hour=\"" + drawNum + "\"]")).click();
            } else {
                element.findElement(By.cssSelector("[data-dayofweek=\"" + drawNum + "\"]")).click();
            }

        }


    }

    public static void setChance(String lotteryKind, String sance) {
        if (sance.equals("none")) {
            enableChance(false);
            WagerStorage.chanceEnabled(false);
        } else {
            enableChance(true);
            WagerStorage.chanceEnabled(true);
            String[] keys = sance.split(",");
            lastNumKey = keys[1];
            lastbeforeNumKey = keys[0];
            lasTwoNums = new SessionStorageReader(webDriver).getLastTwoNums(lotteryKind);
            pairChanceKeys(lastNumKey, lastbeforeNumKey, lotteryKind);


            while ((!lasTwoNums[0].equals(lastNum) || !lasTwoNums[1].equals(beforeLastNum) || missmatched)) {
                new ClickStep().click("change-chance-number");
                pairChanceKeys(lastNumKey, lastbeforeNumKey, lotteryKind);

            }

        }

    }

    private static void pairChanceKeys(String lastNumKey, String beforeLastNumKey, String lotteryKind) {
        lasTwoNums = new SessionStorageReader(webDriver).getLastTwoNums(lotteryKind);
        lastNum = getChanceConf(lastNumKey, 0, lasTwoNums);
        beforeLastNum = getChanceConf(beforeLastNumKey, 1, lasTwoNums);


    }

    private static String getChanceConf(String key, int index, String[] lastTwoNums) {

        String correctKey = "0";
        if (!key.equals("0")) {
            correctKey = lastTwoNums[index];
            if (lastTwoNums[index].equals("0")) {
                missmatched = true;
            } else {
                missmatched = false;
            }

        }
        return correctKey;
    }

    private static void enableChance(boolean enable) {
        boolean chanceActivated = ElementHandler.getIdCssElement("chance-numbers").isDisplayed();
        WebElement element = ElementHandler.getClasCssElement("col-md-4 want-chance");
        if (!enable || !chanceActivated) {
            element.click();
        }
    }


    /**
     * Deletes every pre-filled column in opened wager.
     */
    public static void cleanAllColumns() {

        if (ElementHandler.getElementArray(Helpers.getDataColumnIndex()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }
        for (WebElement element : Lists.reverse(ElementHandler.getElementArray(Helpers.getDataColumnIndex()))) {
            if (element.getAttribute("class").contains("active")) {
                element.click();
                ElementHandler.waitElementLoaded(Helpers.locatorMap("delete"));
                ElementHandler.clickCmd(ElementHandler.getCssElement(Helpers.locatorMap("delete")));
            }

        }

    }
}
