package cz.sazka.tests.SessionStorage;

import com.google.common.collect.Lists;

import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class SessionStorageReader {
    private JavascriptExecutor js;

    /**
     * Set js executor to particular webdriver
     * @param webDriver current web driver
     */
    public SessionStorageReader(WebDriver webDriver) {
        this.js = (JavascriptExecutor) webDriver;
    }

    /**
     * @param key key which should be looked for in session storage
     * @return item from session storage according to key
     */
    private  String getItemFromSessionStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", key));
    }

    /**
     * @param lotteryKind lottery name
     * @return reversed list of values saved under AddonNumbers parameter
     */
    private List<Object> getReversedAddonNumbers(String lotteryKind) {
        if (lotteryKind.equals("euromilliony")){
            lotteryKind = "euromiliony";
        }
        String jsonText = getItemFromSessionStorage(lotteryKind + "-online-tipnums");
        JSONObject jsonObj = new JSONObject(jsonText);
        return Lists.reverse(jsonObj.getJSONArray("AddonNumbers").toList());
    }

    /**
     * @param lotteryKind Lottery name
     * @return last two numbers from Session storage, saved under AddonNumbers parameter.
     */
    public String[] getLastTwoNums(String lotteryKind) {
        List<Object> list = getReversedAddonNumbers(lotteryKind);
        String[] lastwoNums = new String[2];
        for (int i = 0; i < 2; i++) {
            lastwoNums[i] = list.get(i).toString();
        }
        return lastwoNums;
    }



}
