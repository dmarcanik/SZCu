package cz.sazka.tests.LotteryUtils;

import com.google.common.primitives.Ints;
import cz.sazka.tests.Storage.WagerStorage;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

class LotteryNumMatrix {
    private static int[] usedWinNum = new int[1];
    private static int[] usedLosNum = new int[1];
    private static int posWin = 0;
    private static int posLos = 0;

    /**
     * @param losNumbers array of lose numbers.
     * @param winNumbers array of win numbers.
     * @param count      how many numbers will be generated (when counter hits maximum numbers are cleaned and started over).
     * @return Random lose number except winning numbers and lose numbers returned in current value
     */
    static int getRandomLosNumber(int[] losNumbers, int[] winNumbers, int count) {
        int nmbr = generateNumber(losNumbers);
        usedLosNum = Arrays.copyOf(usedLosNum, count);

        while (contains(usedLosNum, nmbr) || contains(winNumbers, nmbr)) {
            nmbr = generateNumber(losNumbers);
        }
        usedLosNum[posLos] = nmbr;
        posLos++;
        if (posLos == count) {
            posLos = 0;
            usedLosNum = new int[count];
        }
        return nmbr;
    }

    /**
     * @param array array of win numbers.
     * @param count how many numbers will be generated (when counter hits maximum numbers are cleaned and started over).
     * @return Random win number except winning numbers and lose numbers returned in current value
     */
    static int getRandomWinNum(int[] array, int count) {
        int nmbr = generateNumber(array);
        usedWinNum = Arrays.copyOf(usedWinNum, array.length);

        while (contains(usedWinNum, nmbr)) {
            nmbr = generateNumber(array);
        }
        usedWinNum[posWin] = nmbr;
        posWin++;
        if (posWin == count) {
            posWin = 0;
            usedWinNum = new int[0];
        }
        return nmbr;
    }

    /**
     * Randomly generates numbers from given array.
     *
     * @param array set of numbers from should be generated.
     * @return generated number from list.
     */
    private static int generateNumber(int[] array) {
        ArrayList<Integer> list = new ArrayList<>(array.length);
        int count = 0;
        for (int anArray : array) {

            if (anArray == 0) {
                anArray = count;
                count++;

            }
            list.add(anArray);
        }
        int index = new Random().nextInt(array.length);


        return list.get(index);
    }

    /**
     * @param prices            array of prices for each column
     * @param columnCount       number of columns.
     * @param chance            price for chance.
     * @param subscriptionCount how many draws will be bet.
     * @return price for whole wager.
     */
    static int countColumnPrice(ArrayList<Integer> prices, int columnCount, int chance, int subscriptionCount) {
        int priceWithColumns = 0;
        for (int i = 0; i < columnCount; i++) {
            priceWithColumns = priceWithColumns + prices.get(i);
        }
        int drawCount = WagerStorage.getDrawCount();
        int priceWithChance = priceWithColumns + chance;
        int priceWithDraws = priceWithChance * drawCount;
        return priceWithDraws * subscriptionCount;
    }

    /**
     * Checks whether generated number is contained in given array of numbers.
     *
     * @param array array of numbers
     * @param key   generated number.
     * @return true/false
     */
    private static boolean contains(final int[] array, final int key) {
        return Ints.contains(array, key);
    }
}
