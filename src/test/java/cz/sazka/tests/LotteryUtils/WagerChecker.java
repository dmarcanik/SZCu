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

    public static void checkGeneratedWagers() {
        try {
            ElementHandler.waitElementLoadedBy(By.xpath(Helpers.getDataTest(WagerStorage.getLotteryKind())));
            List<WebElement> wagerElems = ElementHandler.getElementArray(Helpers.getDataTest(WagerStorage.getLotteryKind()));
            ElementHandler.waitPageToBeLoaded();
            ElementHandler.clickCmd(wagerElems.get(0).findElement(By.cssSelector("[class=\"" + WagerStorage.getLotteryKind() + " table-cell game\"]")));
            ElementHandler.waitElementLoadedBy(By.cssSelector("[id=\"dialog-wager\"]"));
            WebElement dialogWager = ElementHandler.getidXElement("dialog-wager");
            for (int rowNum = 1; rowNum <= WagerStorage.getColumnCount(); rowNum++) {
                WebElement currentRow = dialogWager.findElement(By.cssSelector("[id=\"row-" + rowNum+"\"]"));
                List<WebElement> numElems = currentRow.findElements(By.cssSelector("td > span"));

                for (int i = 0; i != WagerStorage.getNumCountListValue(rowNum - 1); i++) {
                    WebElement elem = numElems.get(i);
                    Assert.assertTrue(WagerStorage.getNumberStorage(rowNum - 1).contains(stringToInt(elem.getText())));
                    log.info("Waged numbers in " + rowNum + ". column :" + WagerStorage.getNumberStorage(rowNum - 1) + " contains previously generated number: " + elem.getText());

                }

                if (WagerStorage.addNumbbersEnabled()) {
                    List<WebElement> currentRowAddNumElems = ElementHandler.getElementArray("//*[@class=\"additional-numbers\"]");
                    List<WebElement> addNumElems = currentRowAddNumElems.get(rowNum-1).findElements(By.cssSelector("td > span"));
                    int i = 0;
                    for (WebElement addnumElem : addNumElems) {
                        Assert.assertTrue(WagerStorage.getExNumberStorage(i).contains(stringToInt(addnumElem.getText())));
                        i++;

                    }
                }

            }

        } catch (IndexOutOfBoundsException e) {
            log.error("Wager not found");
            throw e;
        }


    }
    private static int stringToInt (String target){
        return Integer.parseInt(target);
    }

}
