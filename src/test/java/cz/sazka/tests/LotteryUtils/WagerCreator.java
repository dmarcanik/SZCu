package cz.sazka.tests.LotteryUtils;

import com.google.common.collect.Lists;
import cucumber.api.DataTable;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.html.HTMLBRElement;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Map;

public class WagerCreator {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();
    private static boolean extraWaged;

    public WagerCreator() {
        extraWaged = false;
    }


    public static void generateWager(int columnCount, int numberCount, int winningNumberCount, String loteryKind, int exNumberCount, String addFeature, int deposit, boolean kingsGame) {
        WagerStorage.cleanStorage();
        if (ElementHandler.getIdCssElement(Helpers.locatorMap("close")).isDisplayed()){
            new ClickStep().click(Helpers.locatorMap("close"));
        }
        if (ElementHandler.getElementArray(Helpers.getDataColumnIndex()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }

        for (int currentColumn = 0; currentColumn < columnCount; currentColumn++) {
            ElementHandler.waitElementLoadedBy(ElementHandler.getIdXpathBy(Helpers.locatorMap("add")));
            new ClickStep().click(Helpers.locatorMap("add"));
            ArrayList<Integer> numList = new ArrayList<>();
            ArrayList<Integer> addNumList = new ArrayList<>();
            if (loteryKind.equals("stastnych10")) {
                setS10Features(numberCount, deposit, kingsGame);
            }
            for (int currentNumber = 0; currentNumber < numberCount; currentNumber++) {

                if (currentNumber < winningNumberCount) {
                    int winNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "sportka":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getSportkaWinNumbers(), winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            numList.add(currentNumber, winNumber);
                            break;
                        case "eurojackpot":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJWinNumbers(), winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            numList.add(currentNumber, winNumber);
                            break;
                        case "euromiliony":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMWinNumbers(), winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            numList.add(currentNumber, winNumber);
                            break;

                        case "stastnych10":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getS10WinNumbers(), winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            numList.add(currentNumber,winNumber);


                    }
                }
                if (currentNumber >= winningNumberCount) {
                    int losNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "sportka":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[49], LotteryMatrix
                                    .getSportkaWinNumbers(), numberCount - winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(losNumber);
                            webElement.click();
                            numList.add(currentNumber, losNumber);
                            break;
                        case "eurojackpot":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[50], LotteryMatrix
                                    .getEuroJWinNumbers(), numberCount - winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(losNumber);
                            webElement.click();
                            numList.add(currentNumber, losNumber);
                            break;

                        case "euromiliony":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[35], LotteryMatrix
                                    .getEuroMWinNumbers(), numberCount - winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(losNumber);
                            webElement.click();
                            numList.add(currentNumber, losNumber);
                            break;

                        case "stastnych10":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[80], LotteryMatrix.getS10WinNumbers(),numberCount - winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(losNumber);
                            webElement.click();
                            numList.add(currentNumber,losNumber);
                    }

                }


            }
            WagerStorage.storeNumbers(currentColumn, numList);
            if (extraWaged = addFeature.equals("win")) {
                for (int currentExNumber = 0; currentExNumber < exNumberCount; currentExNumber++) {
                    int winExNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "eurojackpot":
                            winExNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJExWinNumbers(), 2);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            addNumList.add(currentExNumber, winExNumber);
                            break;
                        case "euromiliony":
                            winExNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMExWinNumber(), 1);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            addNumList.add(currentExNumber, winExNumber);
                            break;
                    }


                }
                extraWaged = true;


            } else if (extraWaged = addFeature.equals("lose")) {
                for (int currentExNumber = 0; currentExNumber < exNumberCount; currentExNumber++) {
                    int winExNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "eurojackpot":
                            winExNumber = LotteryMatrix.getRandomLosNumber(new int[10], LotteryMatrix.getEuroJExWinNumbers(), 2);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            addNumList.add(currentExNumber, winExNumber);
                            break;
                        case "euromiliony":
                            winExNumber = LotteryMatrix.getRandomLosNumber(new int[5], LotteryMatrix.getEuroMExWinNumber(), 1);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            addNumList.add(currentExNumber, winExNumber);
                            break;

                    }
                }
                extraWaged = true;
            }
            WagerStorage.storeExColNumber(currentColumn, addNumList);

            new ClickStep().click(Helpers.locatorMap("save"));

        }
        WagerStorage.storeColumnCount(columnCount);
        WagerStorage.storeExNumberCount(exNumberCount);
        WagerStorage.storenumberCount(numberCount);
        WagerStorage.storeLotteryKind(loteryKind);

    }

    public static void setS10Features(int numberCount, int deposit, boolean kingsGame) {
        String numCountString = String.valueOf(numberCount);
        String depositString = String.valueOf(deposit);
        new ClickStep().clickComboBox("drpInputsCountSelectBoxItArrow", numCountString);
        new ClickStep().clickComboBox("drpDepositSelectBoxItArrow", depositString);
        if (kingsGame) {
            new ClickStep().clickCheckbox("dialog-check-king-game");
        }
    }

    public static void createWager(String lottery, DataTable data) {
        new ClickStep().click("dialog-column-close");
        WagerCreator.cleanAllColumns();
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {

            new ClickStep().click("btn-game-column-add");
            String numbers = columnData.get("numbers");
            String[] splittedNumbers = numbers.split(",");
            for (String splittedNumber : splittedNumbers) {
                int num = Integer.parseInt(splittedNumber);
                log.info("waging" + lottery + "  number " + num);
                ElementHandler.waitElementLoadedEl(ElementHandler.getDialogColumnEl(num));
                ElementHandler.getDialogColumnEl(num).click();


            }

            if (columnData.get("additional") != null) {
                String additional = columnData.get("additional");
                String[] splittedAdditional = additional.split(",");
                for (String splittedAddNum : splittedAdditional) {
                    int addNum = Integer.parseInt(splittedAddNum);
                    log.info("waging" + lottery + " additional number " + addNum);
                    ElementHandler.waitElementLoadedEl(ElementHandler.getAdditionalColumnEl(addNum));
                    ElementHandler.getAdditionalColumnEl(addNum).click();

                }

            }
            new ClickStep().click("dialog-column-save");
        }
    }


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
                ElementHandler.clickCmd(ElementHandler.getidXElement(Helpers.locatorMap("delete")));
            }

        }

    }
}
