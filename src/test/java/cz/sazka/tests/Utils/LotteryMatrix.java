package cz.sazka.tests.Utils;

import com.google.common.primitives.Ints;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class LotteryMatrix {
    private static int[] usedWinNum = new int[1];
    private static int[] usedLosNum = new int[1];
    private static int posWin = 0;
    private static int posLos = 0;


    public static int[] getSportkaWinNumbers() {
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

    public static int[] getEuroJWinNumbers(){
        return new int[] {1,10,20,30,50};
    }
    public static int[] getEuroJExWinNumbers(){
        return new int[] {1,10};
    }
    public static int[] getEuroMExWinNumber(){
        int[] winArrayTu = {5};
        int[] winArraySa = {1};
        int[] winNumbers = new int[0];
        switch (getCalendarDay()){
            case Calendar.SUNDAY:
                winNumbers = winArrayTu ;
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
    public static int[] getS10WinNumbers(){
        int[] winArrayAm = {1,5,10,15,20,25,30,35,40,45,50,55,60,65,70,75,77,78,79,80};
        int[] winArrayPm = {1,2,3,4,9,10,19,20,29,30,39,40,49,50,59,60,69,70,79,80};
        int[] winNumbers;
        if (getHour()<12){
            winNumbers = winArrayAm;
        }
        else {
            winNumbers = winArrayPm;
        }
        return winNumbers;
    }


    public static int[] getEuroMWinNumbers(){
        int[] winArrayTu = {1,10,18,20,28,30,35};
        int[] winArraySa = {1,5,19,20,25,29,35};
        int[] winNumbers = new int[0];
        switch (getCalendarDay()) {
            case Calendar.SUNDAY:
                winNumbers = winArrayTu ;
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


    private static int getHour(){
       LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh");
        String timeS = localTime.format(dateTimeFormatter);
        return Integer.parseInt(timeS);
    }

    private static int getCalendarDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    public static int getRandomLosNumber(int[] losNumbers, int[] winNumbers, int count) {
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

    public static int getRandomWinNum(int[] array, int count) {
        int nmbr = generateNumber(array);
        usedWinNum = Arrays.copyOf(usedWinNum, array.length);

        while (contains(usedWinNum, nmbr)) {
            nmbr = generateNumber(array);
        }
        usedWinNum[posWin] = nmbr;
        posWin++;
        if (posWin == count) {
            posWin = 0;
        }
        return nmbr;
    }

    private static int generateNumber(int[] array) {
        ArrayList<Integer> list = new ArrayList<>(array.length);
        int count =1;
        for (int anArray : array) {

            if (anArray==0){
                anArray = count;
                count++;

            }
            list.add(anArray);
        }
        int index = new Random().nextInt(array.length);
        while (index==0){
            index= new Random().nextInt(array.length);
        }

        return list.get(index);
    }

    private static boolean contains(final int[] array, final int key) {
        return Ints.contains(array, key);
    }
}
