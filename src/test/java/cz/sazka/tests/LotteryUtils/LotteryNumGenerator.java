package cz.sazka.tests.LotteryUtils;

import org.junit.Assert;

 class LotteryNumGenerator {

     static int getLotteryWinNum(String lotteryKind, int winningNumberCount) {
        int winNumber = 0;
        switch (lotteryKind) {
            case "sportka":
                winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getSportkaWinNumbers(), winningNumberCount);
                break;
            case "eurojackpot":
                winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJWinNumbers(), winningNumberCount);
                break;

            case "euromilliony":
                winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMWinNumbers(), winningNumberCount);
                break;

            case "stastnych10":
                winNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getS10WinNumbers(), winningNumberCount);
                break;
        }
        Assert.assertNotEquals(0, winNumber);
        return winNumber;
    }

     static int getLotteryLosNum(String lotteryKind, int winningNumberCount, int numberCount) {
        int losNumber = 0;
        switch (lotteryKind) {
            case "sportka":
                losNumber = LotteryMatrix.getRandomLosNumber(new int[49], LotteryMatrix
                        .getSportkaWinNumbers(), numberCount - winningNumberCount);
                break;
            case "eurojackpot":
                losNumber = LotteryMatrix.getRandomLosNumber(new int[50], LotteryMatrix
                        .getEuroJWinNumbers(), numberCount - winningNumberCount);
                break;

            case "euromilliony":
                losNumber = LotteryMatrix.getRandomLosNumber(new int[35], LotteryMatrix
                        .getEuroMWinNumbers(), numberCount - winningNumberCount);
                break;

            case "stastnych10":
                losNumber = LotteryMatrix.getRandomLosNumber(new int[80], LotteryMatrix.getS10WinNumbers(), numberCount - winningNumberCount);
                break;
        }
        Assert.assertNotEquals(0, losNumber);
        return losNumber;
    }

     static int getLotteryAddWinNum(String loteryKind) {
        int winAddNumber = 0;
        switch (loteryKind) {
            case "eurojackpot":
                winAddNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroJExWinNumbers(), 2);
                break;
            case "euromilliony":
                winAddNumber = LotteryMatrix.getRandomWinNum(LotteryMatrix.getEuroMExWinNumber(), 1);
                break;
        }
        Assert.assertNotEquals(0, winAddNumber);
        return winAddNumber;
    }

     static int getLotteryAddLosNum(String loteryKind) {
        int losAddNumber = 0;
        switch (loteryKind) {
            case "eurojackpot":
                losAddNumber = LotteryMatrix.getRandomLosNumber(new int[10], LotteryMatrix.getEuroJExWinNumbers(), 2);
                break;
            case "euromilliony":
                losAddNumber = LotteryMatrix.getRandomLosNumber(new int[5], LotteryMatrix.getEuroMExWinNumber(), 1);
                break;
        }
        Assert.assertNotEquals(0, losAddNumber);
        return losAddNumber;
    }
}
