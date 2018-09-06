package cz.sazka.tests.LotteryUtils;

import com.google.common.collect.Lists;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.InvalidParameterException;

public class ColumnWorker {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();
    private static boolean extraWaged;

    public ColumnWorker() {
        extraWaged = false;
    }

    public static void fillColumns(int numberOfColumns, int numberCount, int winningNumberCount, String loteryKind, int extraNumCount, String addFeature) {

        if (ElementHandler.getElementArray(Helpers.getDataColumnIndex()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }

        for (int currentColumn = 0; currentColumn < numberOfColumns; currentColumn++) {
            WebElement element = ElementHandler.getElementArray(Helpers.getDataColumnIndex()).get(currentColumn);
            element.click();
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
                            break;
                        case "eurojackpot":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJWinNumbers(), winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "euromiliony":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMWinNumbers(), winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
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
                            break;
                        case "eurojackpot":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[50], LotteryMatrix
                                    .getEuroJWinNumbers(), numberCount - winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(losNumber);
                            webElement.click();
                            break;

                        case "euromiliony":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[35], LotteryMatrix
                                    .getEuroMWinNumbers(), numberCount - winningNumberCount);
                            webElement = ElementHandler.getDialogColumnEl(losNumber);
                            webElement.click();
                            break;
                    }

                }


            }
            if (extraWaged = addFeature.equals("win")) {
                for (int currentExNumber = 0; currentExNumber < extraNumCount; currentExNumber++) {
                    int winExNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "eurojackpot":
                            winExNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJExWinNumbers(), 2);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "euromiliony":
                            winExNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMExWinNumber(), 1);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                    }


                }
                extraWaged = true;


            } else if (extraWaged = addFeature.equals("lose")) {
                for (int currentExNumber = 0; currentExNumber < extraNumCount; currentExNumber++) {
                    int winExNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "eurojackpot":
                            winExNumber = LotteryMatrix.getRandomLosNumber(new int[10], LotteryMatrix.getEuroJExWinNumbers(), 2);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "euromiliony":
                            winExNumber = LotteryMatrix.getRandomLosNumber(new int[5], LotteryMatrix.getEuroMExWinNumber(), 1);
                            webElement = ElementHandler.getAdditionalColumnEl(winExNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;

                    }
                }
                extraWaged = true;
            }
            WebElement element3 = ElementHandler.getidXElement("dialog-column-save");
            element3.click();


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
                ElementHandler.waitElementLoaded("btn-dialog-column-delete");
                ElementHandler.clickCmd(ElementHandler.getidXElement("btn-dialog-column-delete"));
            }

        }

    }
}
