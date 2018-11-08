package cz.sazka.tests.LotteryUtils;

import cz.sazka.tests.Storage.WagerStorage;
import org.junit.Assert;

import java.util.ArrayList;

public class LotteryNumGenerator {
    /**
     * @param lotteryKind        lottery name.
     * @param winningNumberCount count of winning numbers.
     * @return winning number for desired lottery.
     */
    static int getLotteryWinNum(String lotteryKind, int winningNumberCount) {
        int winNumber = 0;
        switch (lotteryKind) {
            case "sportka":
                winNumber = LotteryNumMatrix.getRandomWinNum(LotteryInfo.getSportkaWinNumbers(), winningNumberCount);
                break;
            case "eurojackpot":
                winNumber = LotteryNumMatrix.getRandomWinNum(LotteryInfo.getEuroJWinNumbers(), winningNumberCount);
                break;

            case "euromilliony":
                winNumber = LotteryNumMatrix.getRandomWinNum(LotteryInfo.getEuroMWinNumbers(), winningNumberCount);
                break;

            case "stastnych10":
                winNumber = LotteryNumMatrix.getRandomWinNum(LotteryInfo.getS10WinNumbers(), winningNumberCount);
                break;
        }
        Assert.assertNotEquals(0, winNumber);
        return winNumber;
    }

    /**
     * @param lotteryKind        lottery name.
     * @param winningNumberCount count of winning numbers.
     * @param numberCount        count of numbers in current column.
     * @return lose number for desired lottery.
     */
    static int getLotteryLosNum(String lotteryKind, int winningNumberCount, int numberCount) {
        int losNumber = 0;
        switch (lotteryKind) {
            case "sportka":
                losNumber = LotteryNumMatrix.getRandomLosNumber(new int[49], LotteryInfo
                        .getSportkaWinNumbers(), numberCount - winningNumberCount);
                break;
            case "eurojackpot":
                losNumber = LotteryNumMatrix.getRandomLosNumber(new int[50], LotteryInfo
                        .getEuroJWinNumbers(), numberCount - winningNumberCount);
                break;

            case "euromilliony":
                losNumber = LotteryNumMatrix.getRandomLosNumber(new int[35], LotteryInfo
                        .getEuroMWinNumbers(), numberCount - winningNumberCount);
                break;

            case "stastnych10":
                losNumber = LotteryNumMatrix.getRandomLosNumber(new int[80], LotteryInfo.getS10WinNumbers(), numberCount - winningNumberCount);
                break;
        }
        Assert.assertNotEquals(0, losNumber);
        return losNumber;
    }

    /**
     * @param loteryKind lottery name.
     * @return winning additional number.
     */
    static int getLotteryAddWinNum(String loteryKind) {
        int winAddNumber = 0;
        switch (loteryKind) {
            case "eurojackpot":
                winAddNumber = LotteryNumMatrix.getRandomWinNum(LotteryInfo.getEuroJExWinNumbers(), 2);
                break;
            case "euromilliony":
                winAddNumber = LotteryNumMatrix.getRandomWinNum(LotteryInfo.getEuroMExWinNumber(), 1);
                break;
        }
        Assert.assertNotEquals(0, winAddNumber);
        return winAddNumber;
    }

    /**
     * @param loteryKind lottery name.
     * @return lose additional number.
     */
    static int getLotteryAddLosNum(String loteryKind) {
        int losAddNumber = 0;
        switch (loteryKind) {
            case "eurojackpot":
                losAddNumber = LotteryNumMatrix.getRandomLosNumber(new int[10], LotteryInfo.getEuroJExWinNumbers(), 2);
                break;
            case "euromilliony":
                losAddNumber = LotteryNumMatrix.getRandomLosNumber(new int[5], LotteryInfo.getEuroMExWinNumber(), 1);
                break;
        }
        Assert.assertNotEquals(0, losAddNumber);
        return losAddNumber;
    }

    /**
     * @param lotteryKind lottery name
     * @return final price for desired lottery
     */
    public static int getLotteryPrice(String lotteryKind, boolean chanceEnabled) {
        int finalPrice = 0;
        int chancePrice = 0;
        if (chanceEnabled){
            chancePrice = LotteryInfo.getLotteryChancePrice(lotteryKind);
        }
        ArrayList<Integer> depositList = WagerStorage.getDepositList();
        int columnCount = WagerStorage.getColumnCount();
        int drawCount = 1;
        switch (lotteryKind) {
            case "sportka":
                finalPrice = LotteryNumMatrix.countColumnPrice(depositList, columnCount, chancePrice, drawCount);
                break;
            case "eurojackpot":
                finalPrice = LotteryNumMatrix.countColumnPrice(depositList, columnCount, chancePrice, drawCount);
                break;
            case "euromilliony":
                finalPrice = LotteryNumMatrix.countColumnPrice(depositList, columnCount, chancePrice, drawCount);
                break;
            case "stastnych10":
                finalPrice = LotteryNumMatrix.countColumnPrice(depositList, columnCount, chancePrice, drawCount);
                break;
            case "keno" : finalPrice = LotteryNumMatrix.countColumnPrice(depositList,columnCount,chancePrice,drawCount);
        }
        Assert.assertNotEquals(0, finalPrice);
        return finalPrice;
    }

}
