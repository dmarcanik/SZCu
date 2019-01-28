package cz.sazka.tests.LotteryUtils;

import com.google.common.collect.Lists;
import cz.sazka.tests.SessionStorage.WagerInfoReader;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Steps.Hook;
import cz.sazka.tests.Storage.WagerStorage;
import cz.sazka.tests.Utils.ActiveElementChecker;
import cz.sazka.tests.Utils.ElementHandler;
import cz.sazka.tests.Utils.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.InvalidParameterException;
import java.util.List;

public class WagerFeatures {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();
    private static String lastNum;
    private static String beforeLastNum;
    private static String[] lasTwoNums;
    private static String lastNumKey;
    private static String lastbeforeNumKey;
    private static boolean missmatched = false;
    private static By closeButton = ElementHandler.getIdBy(Helpers.locatorMap("close"));
    private static By deleteButton = ElementHandler.getIdBy(Helpers.locatorMap("delete"));
    private static By drawDate = ElementHandler.getBy("[for*=\"datePicker\"]");


    /**
     * Set features bellow in opened wager according delivered params.
     *
     * @param numberCount count of numbers in current column.
     * @param deposit     value of deposit in current column.
     * @param kingsGame   keyword which defines if should be kralovska hra activated or not in each column.
     */
    static void setColumnFeatures(int numberCount, int deposit, boolean kingsGame) {
        String numCountString = String.valueOf(numberCount);
        String depositString = String.valueOf(deposit);
        new ClickStep().clickComboBox("drpInputsCountSelectBoxIt", numCountString);
        new ClickStep().clickComboBox("drpDepositSelectBoxIt", depositString);
        if (kingsGame) {
            new ClickStep().clickCheckbox("dialog-check-king-game");
        }
    }


    /**
     * Checks which draw dates are selected and unselect them all.
     * Select desired draw dates according params:
     *
     * @param draws   draw name.
     * @param lottery lottery name.
     */
    public static void selectDrawDate(String draws, String lottery) {
        List<WebElement> elementList = webDriver.findElements(By.cssSelector("[for*=\"datePicker\"]"));
        for (WebElement button : elementList) {
            if (!button.getCssValue("background-color").contains("rgba(0, 0, 0, 0)")) {
                ElementHandler.clickOn(drawDate);
            }
        }
        int[] drawNums = DrawInfo.getAllDrawNums(draws);
        int drawCount = drawNums.length;
        WagerStorage.storeDrawCount(drawCount);
        for (int drawNum : drawNums) {
            if (lottery.equals("stastnych10")) {
                ElementHandler.clickOn(By.cssSelector("[data-hour=\"" + drawNum + "\"]"));
            } else {
                ElementHandler.clickOn(By.cssSelector("[data-dayofweek=\"" + drawNum + "\"]"));
            }

        }


    }

    /**
     * Set duration according to settings
     *
     * @param durationCount for how many times should be wager activated.
     * @param lottery       lottery name.
     */
    public static void setDuration(String durationCount, String lottery) {
        WagerStorage.setDurationCount(Integer.parseInt(durationCount));
        if (lottery.equals("Keno")) {
            new ClickStep().clickComboBox("p_lt_ctl10_pageplaceholder_p_lt_ctl03_wKO_ddlDurationSelectBoxItArrow", durationCount);

        } else {
            ElementHandler.clickCmd(ElementHandler.getCssElement("#duration-option > li:nth-child(2)"));
            new ClickStep().clickComboBox("durationSelectSelectBoxIt", durationCount);
        }

    }

    /**
     * Set šance for particular lottery
     *
     * @param lotteryKind lottery name
     * @param sance       value of sance, which should be set.
     */
    static void setChance(String lotteryKind, String sance) {
        if (sance.equals("none")) {
            enableChance(false);
            WagerStorage.enableChance(false);
        } else {
            enableChance(true);
            WagerStorage.enableChance(true);
            String[] keys = sance.split(",");
            lastNumKey = keys[1];
            lastbeforeNumKey = keys[0];
            lasTwoNums = new WagerInfoReader().getLastTwoNums(lotteryKind);
            pairChanceKeys(lastNumKey, lastbeforeNumKey, lotteryKind);


            while ((!lasTwoNums[0].equals(lastNum) || !lasTwoNums[1].equals(beforeLastNum) || missmatched)) {
               new ClickStep().click("change-chance-number");
                pairChanceKeys(lastNumKey, lastbeforeNumKey, lotteryKind);

            }

        }

    }

    /**
     * Reads last two numbers from Session storage
     *
     * @param lastNumKey        key for last number.
     * @param penultimateNumKey key for penultimate number.
     * @param lotteryKind       name of lottery.
     */
    private static void pairChanceKeys(String lastNumKey, String penultimateNumKey, String lotteryKind) {
        lasTwoNums = new WagerInfoReader().getLastTwoNums(lotteryKind);
        lastNum = getChanceConf(lastNumKey, 0, lasTwoNums);
        beforeLastNum = getChanceConf(penultimateNumKey, 1, lasTwoNums);


    }

    /**
     * @param key         desired key
     * @param index       position of desired number
     * @param lastTwoNums last two numbers
     * @return number according to key, if key is X 0 is never returned.
     */
    private static String getChanceConf(String key, int index, String[] lastTwoNums) {

        String correctKey = "0";
        if (!key.equals("0")) {
            correctKey = lastTwoNums[index];
            missmatched = lastTwoNums[index].equals("0");
        }
        return correctKey;
    }

    /**
     * Activates or deactivates šance.
     *
     * @param enable desired value
     */
    private static void enableChance(boolean enable) {
        boolean chanceActivated = ElementHandler.getIdCssElement("chance-numbers").isDisplayed();
        if (!enable || !chanceActivated) {
            ElementHandler.clickOn(ElementHandler.getForCssBy("check-include-chance"));

        }
    }


    /**
     * Deletes every pre-filled column in opened wager.
     */
    public static void cleanAllColumns() {
        if (ElementHandler.getElementArray(Helpers.getAllColumns()).size() == 0) {
            String error = "game-columns not found";
            log.error(error);

            throw new InvalidParameterException(error);
        }
        if (ActiveElementChecker.isActive(closeButton)) {
            ElementHandler.clickOn(closeButton);
        }
        for (WebElement element : Lists.reverse(ElementHandler.getElementArray(Helpers.getAllColumns()))) {
            if (element.getAttribute("class").contains("active")) {
                ElementHandler.clickCmd(element);
                ElementHandler.clickOn(deleteButton);
            }
        }

    }

}
