package cz.sazka.tests.SessionStorage;

import com.google.common.collect.Lists;
import cz.sazka.tests.Steps.ClickStep;
import cz.sazka.tests.Utils.ElementHandler;
import org.apache.logging.log4j.LogManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WagerInfoReader {
    private static String[] lastwoNums = new String[2];
    private static org.apache.logging.log4j.Logger log = LogManager.getRootLogger();


    /**
     * @param lotteryKind lottery name
     * @return reversed list of values saved under AddonNumbers parameter
     */
    private List<Object> getAddonNumbers(String lotteryKind) {
        JSONObject jsonObj = new JSONObject(getLotteryJsonText(lotteryKind));
        return jsonObj.getJSONArray("AddonNumbers").toList();
    }
    public Object getDuration(String lotteryKind) {
        JSONObject jsonObj = new JSONObject(getLotteryJsonText(lotteryKind));
        return jsonObj.get("Duration");
    }

    public JSONArray getNumbersJSONArray(String lotteryKind) {
        JSONObject jsonObj = new JSONObject(getLotteryJsonText(lotteryKind));
        return jsonObj.getJSONArray("Numbers");
    }

    public ArrayList<String> getDataFromJSONArray(JSONArray jsonArray, String param){
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            arrayList.add(i,jsonObj.get(param).toString());

        }
        return arrayList;
    }

    public ArrayList<String> getPrimaryNumbers(String lotteryKind){
       return getDataFromJSONArray(getNumbersJSONArray(lotteryKind),"Primary");
    }
    public ArrayList<String> getAdditionalNumbers(String lotteryKind){
        return getDataFromJSONArray(getNumbersJSONArray(lotteryKind),"Additional");
    }
    public ArrayList<String> getKingsGameValues(String lotteryKind){
        return getDataFromJSONArray(getNumbersJSONArray(lotteryKind),"KralovskaHra");
    }





    private String getLotteryJsonText(String lotteryKind) {
        String key = getKey(lotteryKind);
        return new SessionStorageReader().getItemFromSessionStorage(key);
    }

    private List<Object> getReversedJsonObjArray(List<Object> array) {
        return Lists.reverse(array);
    }

    private String getKey(String lotteryKind) {
        String key = null;
        switch (lotteryKind) {
            case "sportka":
                key = "sportka-online-tipnums";
                break;
            case "eurojackpot":
                key = "eurojackpot-online-tipnums";
                break;
            case "euromilliony":
                key = "euromiliony-online-tipnums";
                break;
            case "keno":
                key = "keno-online-tipnums";
                break;
            case "stastnych10":
                key = "stastnych10-online-tipnums";
                break;
            case "kasicka":
                key = "kasicka-online-tipnums";
                break;
        }
        return key;
    }


    /**
     * @param lotteryKind Lottery name
     * @return last two numbers from Session storage, saved under AddonNumbers parameter.
     */
    public String[] getLastTwoNums(String lotteryKind) {
        List<Object> list = getReversedJsonObjArray(getAddonNumbers(lotteryKind));
        int attepmts=0;
        while (list.size()==0 && attepmts<5){
            ElementHandler.clickOn(ElementHandler.getForCssBy("check-include-chance"));
            list = getReversedJsonObjArray(getAddonNumbers(lotteryKind));
            attepmts++;


        }
        if (list.size() ==0){
            log.error("Unable to read chance numbers from browser");
            System.out.println("Unable to read chance numbers from browser");
            Assert.assertNotEquals(list.size(),0);
        }

        for (int i = 0; i < 2; i++) {
            lastwoNums[i] = list.get(i).toString();
            System.out.println("test");
        }
        return lastwoNums;
    }
}
