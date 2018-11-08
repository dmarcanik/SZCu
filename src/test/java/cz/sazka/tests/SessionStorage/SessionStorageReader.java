package cz.sazka.tests.SessionStorage;

import com.google.common.collect.Lists;

import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class SessionStorageReader {
    private JavascriptExecutor js;


    public SessionStorageReader(WebDriver webDriver) {
        this.js = (JavascriptExecutor) webDriver;
    }

    private  String getItemFromSessionStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", key));
    }

    private List<Object> getReversedStorageArray(String lotteryKind) {
        if (lotteryKind.equals("euromilliony")){
            lotteryKind = "euromiliony";
        }
        String jsonText = getItemFromSessionStorage(lotteryKind + "-online-tipnums");
        JSONObject jsonObj = new JSONObject(jsonText);
        return Lists.reverse(jsonObj.getJSONArray("AddonNumbers").toList());
    }

    public String[] getLastTwoNums(String lotteryKind) {
        List<Object> list = getReversedStorageArray(lotteryKind);
        String[] lastwoNums = new String[2];
        for (int i = 0; i < 2; i++) {
            lastwoNums[i] = list.get(i).toString();
        }
        return lastwoNums;
    }



}
