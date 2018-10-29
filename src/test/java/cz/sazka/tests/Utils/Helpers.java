package cz.sazka.tests.Utils;

import cz.sazka.tests.Steps.Hook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Helpers {
    private static Logger log = LogManager.getRootLogger();

     static String getIdCss(String path) {
        return "[id=\"" + path + "\"]";
    }

     static String getForCss(String path) {
        return "[for=\"" + path + "\"]";
    }

     static String getClassCss(String target) {
        return "[class=\"" + target + "\"]";
    }

    public static String getClassCssContains(String path) {
        String oldcss = "[class~=\"{}\"]";
        return oldcss.replace("{}", path);
    }

    public static String getDataColumnIndex() {
        return "[data-columnindex]";
    }

    public static String getDataTest(String target) {
        return "[data-test=\"" + target + "\"]";
    }

    public static String getLoaderCss() {
        return "[class*=\"loader active\"]";
    }


    public static String getConsentPageCss() {
        return "[class=\"consents-bar active layout-bottom\"]";
    }

    public static List<String> GetLoadingCsss() {
        ArrayList<String> result = new ArrayList<>();
        result.add("[class~=\"authenticated\"]");
        result.add("[class~=\"unauthenticated\"]");
        return result;
    }

    public static String getLoggedInCss() {
        return "[class~=\"authenticated\"]";
    }

    public static String getLoggedOutCss() {
        return "[class~=\"unauthenticated\"]";
    }


    public static String locatorMap(String key) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("login", "neo-login");
        hashtable.put("user", "user");
        hashtable.put("password", "password");
        hashtable.put("submit", "submit");
        hashtable.put("myProfile", "myProfile");
        hashtable.put("logout", "btn-logout");
        hashtable.put("ok", "ng-scope mwc-col-xs-12");
        hashtable.put("myWagers", "myWagers");
        hashtable.put("wagerList", "wagerList");
        hashtable.put("loadingScreen", "loadingScreen");
        hashtable.put("columnBox", "dialog-column-checkboxes");
        hashtable.put("columnBoxAdd", "dialog-column-checkboxes-additional");
        hashtable.put("wagerSaved", "totalSendWagerPrice");
        hashtable.put("close", "dialog-column-close");
        hashtable.put("add", "btn-game-column-add");
        hashtable.put("save", "dialog-column-save");
        hashtable.put("delete", "btn-dialog-column-delete");
        if (hashtable.get(key).isEmpty()) {
            log.error(key + " Not found check spelling");
        }


        return hashtable.get(key);
    }

}
