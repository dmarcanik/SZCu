package cz.sazka.tests.LotteryUtils;

import org.junit.Assert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class LotteryInfo {
    /**
     * @return Winning numbers for Sportka according day, when this method is called.
     */
    static int[] getSportkaWinNumbers() {
        int[] winArrayFr = {1, 10, 18, 30, 32, 48};
        int[] winArrayWe = {1, 10, 18, 30, 32, 48};
        int[] winArraySu = {2, 20, 28, 20, 30, 28, 49};
        int[] winNumbers = new int[0];
        switch (getCalendarDay()) {
            case Calendar.SUNDAY:
                winNumbers = winArraySu;
                break;
            case Calendar.MONDAY:
                winNumbers = winArrayWe;
                break;
            case Calendar.TUESDAY:
                winNumbers = winArrayWe;
                break;
            case Calendar.WEDNESDAY:
                winNumbers = winArrayWe;
                break;
            case Calendar.THURSDAY:
                winNumbers = winArrayFr;
                break;
            case Calendar.FRIDAY:
                winNumbers = winArrayFr;
                break;
            case Calendar.SATURDAY:
                winNumbers = winArraySu;

        }
        return winNumbers;
    }

    /**
     * @return Eurojackpot winning numbers (not necessary to check what day is EJ have only one set of winning numbers for every draw).
     */
    static int[] getEuroJWinNumbers() {
        return new int[]{1, 10, 20, 30, 50};
    }

    /**
     * @return Eurojackpot additional winning numbers (not necessary to check what day is EJ have only one set of winning numbers for every draw).
     */
    static int[] getEuroJExWinNumbers() {
        return new int[]{1, 10};
    }

    /**
     * @return Euromiliony winning additional numbers according day, when this method is called.
     */
    static int[] getEuroMExWinNumber() {
        int[] winArrayTu = {5};
        int[] winArraySa = {1};
        int[] winNumbers = new int[0];
        switch (getCalendarDay()) {
            case Calendar.SUNDAY:
                winNumbers = winArrayTu;
                break;
            case Calendar.MONDAY:
                winNumbers = winArrayTu;
                break;
            case Calendar.TUESDAY:
                winNumbers = winArrayTu;
                break;
            case Calendar.WEDNESDAY:
                winNumbers = winArraySa;
                break;
            case Calendar.THURSDAY:
                winNumbers = winArraySa;
                break;
            case Calendar.FRIDAY:
                winNumbers = winArraySa;
                break;
            case Calendar.SATURDAY:
                winNumbers = winArraySa;

        }
        return winNumbers;
    }

    /**
     * @return Stastnych 10 winning numbers according time, when this method is called.
     */
    static int[] getS10WinNumbers() {
        int[] winArrayAm = {1, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 77, 78, 79, 80};
        int[] winArrayPm = {1, 2, 3, 4, 9, 10, 19, 20, 29, 30, 39, 40, 49, 50, 59, 60, 69, 70, 79, 80};
        int[] winNumbers;
        if (getHour() < 12) {
            winNumbers = winArrayAm;
        } else {
            winNumbers = winArrayPm;
        }
        return winNumbers;
    }

    /**
     * @return Euromiliony winning numbers according day, when this method is called.
     */
    static int[] getEuroMWinNumbers() {
        int[] winArrayTu = {1, 10, 18, 20, 28, 30, 35};
        int[] winArraySa = {1, 5, 19, 20, 25, 29, 35};
        int[] winNumbers = new int[0];
        switch (getCalendarDay()) {
            case Calendar.SUNDAY:
                winNumbers = winArrayTu;
                break;
            case Calendar.MONDAY:
                winNumbers = winArrayTu;
                break;
            case Calendar.TUESDAY:
                winNumbers = winArrayTu;
                break;
            case Calendar.WEDNESDAY:
                winNumbers = winArraySa;
                break;
            case Calendar.THURSDAY:
                winNumbers = winArraySa;
                break;
            case Calendar.FRIDAY:
                winNumbers = winArraySa;
                break;
            case Calendar.SATURDAY:
                winNumbers = winArraySa;

        }
        return winNumbers;

    }

    /**
     * @param lotteryKind lottery name.
     * @return price for desired lottery
     */
    static int getLotteryColumnPrice(String lotteryKind) {
        int price = 0;
        switch (lotteryKind) {
            case "sportka":
                price = 20;
                break;
            case "eurojackpot":
                price = 60;
                break;
            case "euromilliony":
                price = 30;
                break;
        }
        Assert.assertNotEquals(0, price);
        return price;
    }

    /**
     * @param lotteryKind lottery name.
     * @return price for chance.
     */
    static int getLotteryChancePrice(String lotteryKind) {
        int chancePrice = -1;
        switch (lotteryKind) {
            case "sportka":
                chancePrice = 20;
                break;
            case "eurojackpot":
                chancePrice = 40;
                break;
            case "euromilliony":
                chancePrice = 30;
                break;
            case "stastnych10":
                chancePrice = 10;
                break;
            case "keno":
                chancePrice = 0;
                break;
        }
        Assert.assertNotEquals(-1, chancePrice);
        return chancePrice;
    }


    /**
     * @return what hour is now.
     */
    static int getHour() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh");
        String timeS = localTime.format(dateTimeFormatter);
        return Integer.parseInt(timeS);
    }

    /**
     * @return what day is today.
     */
    static int getCalendarDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
