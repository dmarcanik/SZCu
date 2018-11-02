package cz.sazka.tests.Storage;

import java.util.ArrayList;


public class WagerStorage {
    private static int columnCount;
    private static int numberCount;
    private static int addNumberCount;
    private static String lotteryKind;
    private static boolean addNumbers = false;

    private static ArrayList<ArrayList<Integer>> numberStorage = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> AddNumberStorage = new ArrayList<>();
    private static ArrayList<Integer> numCountList = new ArrayList<>();
    private static ArrayList<Integer> addNumCountList = new ArrayList<>();


    /**
     * Saves array of numbers from current column and save it to Array of columns
     * @param index number of column.
     * @param list array of numbers in current column.
     */
    public static void storeNumbers(int index, ArrayList<Integer> list){
        numberStorage.add(index,list);
    }
    /**
     * Saves array of additional numbers from current column and save it to Array of columns
     * @param index number of column.
     * @param list array of numbers in current column.
     */
    public static void storeAddNumbers(int index, ArrayList<Integer> list){
        AddNumberStorage.add(index,list);
    }

    /**
     * Saves number of columns in current wager.
     * @param count number of columns.
     */
    public static void storeColumnCount (int count){
        columnCount = count;
    }

    /**
     * Saves count of numbers in current wager.
     * @param count count of numbers.
     */
    public static void storenumberCount (int count){
        numberCount = count;
    }

    /**
     * Saves how many numbers are in each column.
     * @param list list of numbers.
     */
    public static void storeNumCountList (ArrayList<Integer> list){
        numCountList = list;
    }

    /**
     * @return count of numbers in desired column.
     * @param index desired number of column.
     */
    public static int getNumCountListValue(int index){
        return numCountList.get(index);
    }

    /**
     * Saves how many additional numbers are in each column.
     * @param list list of aaditional numbers.
     */
    public static void storeAddNumCountList (ArrayList<Integer> list){
        addNumCountList = list;
    }

    /**
     * Enables additional numbers for lottery (saying that in this lottery are additional numbers)
     */
    public static void enableAddNumbers(){
        addNumbers = true;
    }

    /**
     * @return whether are additional numbers enabled or not.
     */
    public static boolean addNumbbersEnabled() {
        return addNumbers;
    }

    /**
     * Saves count of additional numbers.
     * @param count additional number count.
     */
    public static void storeAddNumberCount (int count){
        addNumberCount = count;
    }

    /**
     * Saves lottery name in current wager.
     * @param count current wager name.
     */
    public static void storeLotteryKind(String count){
        lotteryKind = count;
    }

    /**
     * @return number of columns in current wager.
     */
    public static int getColumnCount(){
        return columnCount;
    }

    /**
     * @return name of lottery in current wager.
     */
    public static String getLotteryKind(){
        return lotteryKind;
    }

    /**
     * @return Array of saved numbers in from desired position.
     * @param index desired position.
     */
    public static ArrayList<Integer> getNumberStorage(int index){
        return numberStorage.get(index);
    }
    /**
     * @return Array of saved additional numbers in from desired position.
     * @param index desired position.
     */
    public static ArrayList<Integer> getAddNumberStorage(int index){
        return AddNumberStorage.get(index);
    }
}

