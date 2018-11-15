package cz.sazka.tests.LotteryUtils;

import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class WagerChecker {

    private static WebDriver webDriver = Hook.getDriver();
    private static Logger log = LogManager.getRootLogger();

    /**
     * Parsing data from last performed wager according data saved in WagerStorage.class and check if those data are in currently active wagers.
     */
    public static void checkGeneratedWagers() {
        try {
            String desiredLotteryBets = Helpers.getDataTest(WagerStorage.getLotteryKind());
            ElementHandler.waitElementLoadedBy(By.cssSelector(desiredLotteryBets));
            List<WebElement> wagerElems = ElementHandler.getElementArray(desiredLotteryBets);
            ElementHandler.waitPageToBeLoaded();
            WebElement lastBet = wagerElems.get(0).findElement(By.cssSelector("[class=\"" + WagerStorage.getLotteryKind() + " table-cell game\"]"));
            ElementHandler.clickCmd(lastBet);
            ElementHandler.waitElementLoadedBy(ElementHandler.getIdBy("dialog-wager"));
            WebElement dialogWager = ElementHandler.getIdCssElement("dialog-wager");
            for (int columnNum = 1; columnNum <= WagerStorage.getColumnCount(); columnNum++) {
                WebElement currentColumn = dialogWager.findElement(By.cssSelector("[id=\"row-" + columnNum + "\"]"));
                List<WebElement> numbersInColumn = currentColumn.findElements(By.cssSelector("td > span"));

                for (int currentNumber = 0; currentNumber != WagerStorage.getNumCountListValue(columnNum - 1); currentNumber++) {
                    WebElement elem = numbersInColumn.get(currentNumber);
                    boolean savedNumberInWager = WagerStorage.getNumberStorage(columnNum - 1).contains(stringToInt(elem.getText()));
                    Assert.assertTrue(savedNumberInWager);


                }
                log.info("Numbers in " + columnNum + " .row match currently waged numbers in  " + columnNum + ". row");

                if (WagerStorage.addNumbbersEnabled()) {
                    List<WebElement> currentRowAddNumElems = ElementHandler.getElementArray("[class=\"additional-numbers\"]");
                    List<WebElement> addNumsInColumn = currentRowAddNumElems.get(columnNum - 1).findElements(By.cssSelector("td > span"));
                    for (WebElement addnumElem : addNumsInColumn) {
                        boolean savedAddNumberInWager = WagerStorage.getAddNumberStorage(columnNum-1).contains(stringToInt(addnumElem.getText()));
                        Assert.assertTrue(savedAddNumberInWager);


                    }

                    log.info("Additional numbers in " + columnNum + " .row match currently waged additional numbers in  " + columnNum + ". row");
                }

            }

        } catch (IndexOutOfBoundsException e) {
            log.error("Wager not found");
            throw e;
        }


    }

    private static int stringToInt(String target) {
        return Integer.parseInt(target);
    }

}
