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
        List<WebElement> lotteryWagerList = ElementHandler.getElementArray(Helpers.getDataTest(WagerStorage.getLotteryKind()));
        ElementHandler.waitElementLoadedEl(lotteryWagerList.get(0));
        ElementHandler.clickCmd(lotteryWagerList.get(0).findElement(By.cssSelector("[class=\"" + WagerStorage.getLotteryKind() + " table-cell game\"]")));
        for (int rowNum = 1; rowNum <= WagerStorage.getColumnCount(); rowNum++) {
            ElementHandler.waitElementLoaded("row-" + rowNum);
            WebElement element = ElementHandler.getidXElement("row-" + rowNum);
            List<WebElement> elementList = element.findElements(By.cssSelector("td > span"));
            for (int i = 0; i != WagerStorage.getNumCountListValue(rowNum - 1); i++) {
                WebElement elem = elementList.get(i);
                String num = elem.getText();
                int columnNum = Integer.parseInt(num);
                Assert.assertTrue(WagerStorage.getNumberStorage(rowNum - 1).contains(columnNum));
                log.info("Waged numbers in " + rowNum + ". column :" + WagerStorage.getNumberStorage(rowNum - 1) + " contains previously generated number: " + columnNum);


            }

        }
    }

}
