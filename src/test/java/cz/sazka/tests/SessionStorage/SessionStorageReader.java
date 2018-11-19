package cz.sazka.tests.SessionStorage;

import com.google.common.collect.Lists;

import cz.sazka.tests.Steps.Hook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;

public class SessionStorageReader {
    private JavascriptExecutor js;
    private WebDriver webDriver = Hook.getDriver();

    /**
     * Set js executor to particular webdriver
     */
    public SessionStorageReader() {
        this.js = (JavascriptExecutor) webDriver;
    }

    /**
     * @param key key which should be looked for in session storage
     * @return item from session storage according to key
     */
    String getItemFromSessionStorage(String key) {
        return (String) js.executeScript(String.format(
                "return window.sessionStorage.getItem('%s');", key));
    }





}
