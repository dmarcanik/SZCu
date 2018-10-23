package cz.sazka.tests.Storage;
import cucumber.api.DataTable;

import java.util.ArrayList;


public class WagerStorage {
    private static int columnCount;
    private static int numberCount;
    private static int addNumberCount;
    private static String lotteryKind;

    private static ArrayList<ArrayList<Integer>> numberStorage = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> AddNumberStorage = new ArrayList<>();
    private static ArrayList<Integer> numCountList = new ArrayList<>();
    private static ArrayList<Integer> addNumCountList = new ArrayList<>();




    public static void storeNumbers(int index, ArrayList<Integer> list){
        numberStorage.add(index,list);
    }
    public static void storeAddNumbers(int index, ArrayList<Integer> list){
        AddNumberStorage.add(index,list);
    }
    public static void storeColumnCount (int count){
        columnCount = count;
    }
    public static void storenumberCount (int count){
        numberCount = count;
    }
    public static void storeNumCountList (ArrayList<Integer> list){
        numCountList = list;
    }
    public static int getNumCountListValue(int index){
        return numCountList.get(index);
    }
    public static void storeAddNumCountList (ArrayList<Integer> list){
        addNumCountList = list;
    }
    public static int getAddNumCountListValue(int index){
        return addNumCountList.get(index);
    }
    public static void storeAddNumberCount (int count){
        addNumberCount = count;
    }
    public static void storeLotteryKind(String count){
        lotteryKind = count;
    }
    public static int getColumnCount(){
        return columnCount;
    }
    public static int getNumberCount(){
        return numberCount;
    }
    public static int getAddNumberCount(){
        return addNumberCount;
    }
    public static String getLotteryKind(){
        return lotteryKind;
    }
    public static ArrayList<Integer> getNumberStorage(int index){
        return numberStorage.get(index);
    }
    public static ArrayList<Integer> getExNumberStorage(int index){
        return AddNumberStorage.get(index);
    }

    public static void cleanStorage(){
        numberStorage.clear();
        numberStorage.clear();
    }
    public static void parseDataToStorage (DataTable data, String lotteryKind){

    }



}

