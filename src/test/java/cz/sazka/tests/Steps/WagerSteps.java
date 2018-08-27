package cz.sazka.tests.Steps;

import com.google.common.collect.Lists;
import cucumber.api.java.en.And;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import cz.sazka.tests.Utils.LotteryMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.security.InvalidParameterException;

public class WagerSteps {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();
    boolean extraWaged;

    public WagerSteps() {
        extraWaged = false;
    }


    @And("^I create \"([^\"]*)\" column \"(sportka|euromiliony|stastnych10|eurojackpot)\" ticket with \"([^\"]*)\" numbers, \"([^\"]*)\" winning and \"([^\"]*)\" extra numbers set to \"(win|lose|none)\"$")
    public void iCreateColumnTicketWithNumbersAndWinning(int numberOfColumns, String loteryKind, int numberCount, int winningNumbers, int extraNumCount, String addFeature) throws Throwable {
        cleanAllColumns();
        fillColumns(numberOfColumns, numberCount, winningNumbers, loteryKind, extraNumCount, addFeature);

    }

    public void fillColumns(int numberOfColumns, int numberCount, int winningNumberCount, String loteryKind, int extraNumCount, String addFeature) {

        if (ElementHandler.getElementArray(Helpers.getDataColumnIndex()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }

        for (int currentColumn = 0; currentColumn <= numberOfColumns; currentColumn++) {
            WebElement element = ElementHandler.getElementArray(Helpers.getDataColumnIndex()).get(currentColumn);
            element.click();
            for (int currentNumber = 0; currentNumber < numberCount; currentNumber++) {

                if (currentNumber < winningNumberCount) {
                    int winNumber;
                    WebElement webElement;
                    switch (loteryKind) {
                        case "sportka":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getSportkaWinNumbers(), winningNumberCount);
                            webElement = getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "eurojackpot":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJWinNumbers(), winningNumberCount);
                            webElement = getDialogColumnEl(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "euromiliony":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMWinNumbers(), winningNumberCount);
                            webElement = getDialogColumnEl(winNumber);
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
                            webElement = getDialogColumnEl(losNumber);
                            webElement.click();
                            break;
                        case "eurojackpot":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[50], LotteryMatrix
                                    .getEuroJWinNumbers(), numberCount - winningNumberCount);
                            webElement = getDialogColumnEl(losNumber);
                            webElement.click();
                            break;

                        case "euromiliony":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[35], LotteryMatrix
                                    .getEuroMWinNumbers(), numberCount - winningNumberCount);
                            webElement = getDialogColumnEl(losNumber);
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
                            webElement = getAdditionalColumnEl(winExNumber, "eurojackpot");
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "euromiliony":
                            winExNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMExWinNumber(), 2);
                            webElement = getAdditionalColumnEl(winExNumber, "euromiliony");
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
                            webElement = getAdditionalColumnEl(winExNumber, "eurojackpot");
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "euromiliony":
                            winExNumber = LotteryMatrix.getRandomLosNumber(new int[5], LotteryMatrix.getEuroMExWinNumber(), 1);
                            webElement = getAdditionalColumnEl(winExNumber, "euromiliony");
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

    private WebElement getDialogColumnEl(int number) {
        return ElementHandler.getidXElement("dialog-column-checkboxes")
                .findElement(By.cssSelector("[class=\"skin-icon-" + number + "\"]"));
    }

    private WebElement getAdditionalColumnEl(int number, String kind) {
        WebElement element = null;
        switch (kind) {
            case "eurojackpot":
                element = ElementHandler.getidXElement("dialog-column-checkboxes-additional")
                        .findElement(By.cssSelector("[class=\"skin-icon-" + (number + 50) + "\"]"));
                break;
            case "euromiliony":
                element = ElementHandler.getidXElement("dialog-column-checkboxes-additional")
                        .findElement(By.cssSelector("[" + number + "]"));
                break;
        }


        return element;
    }


    public static void cleanAllColumns() {

        if (ElementHandler.getElementArray(Helpers.getDataColumnIndex()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }
        for (WebElement element : Lists.reverse(ElementHandler.getElementArray(Helpers.getDataColumnIndex()))) {
            if (element.getAttribute("data-test") != null) {
                element.click();
                ElementHandler.waitElementLoaded("btn-dialog-column-delete");
                ElementHandler.clickCmd(ElementHandler.getidXElement("btn-dialog-column-delete"));
            }

        }

    }


}
