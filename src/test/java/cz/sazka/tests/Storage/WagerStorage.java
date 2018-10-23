package cz.sazka.tests.Storage;
import java.util.ArrayList;


public class WagerStorage {
    private static int columnCount;
    private static int numberCount;
    private static int exNumberCount;
    private static String lotteryKind;

    private static ArrayList<ArrayList<Integer>> numberStorage = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> exNumberStorage = new ArrayList<>();




    public static void storeNumbers(int index, ArrayList<Integer> list){
        numberStorage.add(index,list);
    }
    public static void storeExColNumber(int index, ArrayList<Integer> list){
        exNumberStorage.add(index,list);
    }
    public static void storeColumnCount (int count){
        columnCount = count;
    }
    public static void storenumberCount (int count){
        numberCount = count;
    }
    public static void storeExNumberCount (int count){
        exNumberCount = count;
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
    public static int getExNumberCount(){
        return exNumberCount;
    }
    public static String getLotteryKind(){
        return lotteryKind;
    }
    public static ArrayList<Integer> getNumberStorage(int index){
        return numberStorage.get(index);
    }
    public static ArrayList<Integer> getExNumberStorage(int index){
        return exNumberStorage.get(index);
    }

    public static void cleanStorage(){
        numberStorage.clear();
        numberStorage.clear();
    }



}

