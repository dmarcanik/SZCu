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



    public static void setWagerFeatures(int numberCount, int deposit, boolean kingsGame) {
        String numCountString = String.valueOf(numberCount);
        String depositString = String.valueOf(deposit);
        new ClickStep().clickComboBox("drpInputsCountSelectBoxItArrow", numCountString);
        new ClickStep().clickComboBox("drpDepositSelectBoxItArrow", depositString);
        if (kingsGame) {
            new ClickStep().clickCheckbox("dialog-check-king-game");
        }
    }

    public static void createWager(String lottery, DataTable data) {
        new ClickStep().click(Helpers.locatorMap("close"));
        WagerCreator.cleanAllColumns();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> addNumList = new ArrayList<>();
        ArrayList<Integer> addNumCountList = new ArrayList<>();
        ArrayList<Integer> numCountList = new ArrayList<>();
        int currentColumn = 0;
        for (Map<String, String> columnData : data.asMaps(String.class, String.class)) {

            new ClickStep().click(Helpers.locatorMap("add"));
            String numbers = columnData.get("numbers");
            String[] splittedNumbers = numbers.split(",");
            if (columnData.get("vklad") != null) {
                boolean kingsGame = false;
                int deposit = Integer.parseInt(columnData.get("vklad"));
                if(columnData.get("kralovskahra")!=null){
                    kingsGame = columnData.get("kralovskahra").contains("ano");
                }
                setWagerFeatures(splittedNumbers.length, deposit, kingsGame);
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
            currentColumn++;
        }
        WagerStorage.storeColumnCount(currentColumn);
    }


    public static void selectDrawDate(String draws, String lottery) {
        WebElement element = ElementHandler.getIdCssElement("date-picker-wrapper");
        List<WebElement> elementList = element.findElements(By.cssSelector("[for]"));
        for (WebElement button : elementList) {
            if (!button.getCssValue("background-color").contains("rgb(255, 255, 255)")) {
                button.click();
            }
        }
        int[] drawNums = DrawInfo.getAllDrawNums(draws);
        for (int drawNum : drawNums) {
            if (lottery.equals("stastnych10")) {
                element.findElement(By.cssSelector("[data-hour=\"" + drawNum + "\"]")).click();
            } else {
                element.findElement(By.cssSelector("[data-dayofweek=\"" + drawNum + "\"]")).click();
            }

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
                ElementHandler.clickCmd(ElementHandler.getCssElement(Helpers.locatorMap("delete")));
            }

        }

    }
}
