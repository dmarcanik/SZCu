package cz.sazka.tests.LotteryUtils;

import org.junit.Assert;

 class LotteryNumGenerator {
     /**
      * @return winning number for desired lottery.
      * @param lotteryKind lottery name.
      * @param winningNumberCount count of winning numbers.
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
      * @return lose number for desired lottery.
      * @param lotteryKind lottery name.
      * @param winningNumberCount count of winning numbers.
      * @param numberCount count of numbers in current column.
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
      * @return winning additional number.
      * @param loteryKind lottery name.
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
      * @return lose additional number.
      * @param loteryKind lottery name.
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
}
