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
    private static boolean extraWaged;


    @And("^I create \"([^\"]*)\" column \"(sportka|euromiliony|stastnych10|eurojackpot)\" ticket with \"([^\"]*)\" numbers and \"([^\"]*)\" winning$")
    public void iCreateColumnTicketWithNumbersAndWinning(int numberOfColumns, String loteryKind, int numberCount, int winningNumbers) throws Throwable {
        cleanAllColumns();
        fillColumns(numberOfColumns, numberCount, winningNumbers, loteryKind);

    }

    public void fillColumns(int numberOfColumns, int numberCount, int winningNumberCount, String loteryKind) {
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
                            webElement = getLotteryNumElement(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            break;
                        case "eurojackpot":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJWinNumbers(), winningNumberCount);
                            webElement = getLotteryNumElement(winNumber);
                            ElementHandler.waitElementLoadedEl(webElement);
                            webElement.click();
                            if (extraWaged = false){

                            }
                            break;
                        case "euromiliony":
                            winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMWinNumbers(), winningNumberCount);
                            webElement = getLotteryNumElement(winNumber);
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
                            webElement = getLotteryNumElement(losNumber);
                            webElement.click();
                            break;
                        case "eurojackpot":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[50], LotteryMatrix
                                    .getEuroJWinNumbers(), numberCount - winningNumberCount);
                            webElement = getLotteryNumElement(losNumber);
                            webElement.click();
                            break;

                        case "euromiliony":
                            losNumber = LotteryMatrix.getRandomLosNumber(new int[35], LotteryMatrix
                                    .getEuroMWinNumbers(), numberCount - winningNumberCount);
                            webElement = getLotteryNumElement(losNumber);
                            webElement.click();
                            break;
                    }

                }


            }
            WebElement element3 = ElementHandler.getidXElement("dialog-column-save");
            element3.click();


        }

    }
    private WebElement getLotteryNumElement(int number){
        return ElementHandler.getidXElement("dialog-column-checkboxes")
                .findElement(By.cssSelector("[class=\"skin-icon-" + number + "\"]"));
    }

    public void cleanAllColumns() {

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
