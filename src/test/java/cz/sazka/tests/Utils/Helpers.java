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

    static String getIdCssContains(String path) {
        return "[id*=\"" + path + "\"]";
    }

    static String getForCss(String path) {
        return "[for=\"" + path + "\"]";
    }

    static String getForCssContains(String path) {
        return "[for*=\"" + path + "\"]";
    }

    public static String getClassCss(String target) {
        return "[class=\"" + target + "\"]";
    }

    public static String getClassCssContains(String path) {
        String oldcss = "[class*=\"{}\"]";
        return oldcss.replace("{}", path);
    }


    public static String getColumn(String number) {
        return "[data-columnindex=\"" + number + "\"]";
    }

    public static String getColumnContains(String number) {
        return "[data-columnindex*=\"" + number + "\"]";

    }

    public static String getMergedCssOr(String css1, String css2) {
        return css1 + "," + css2;
    }

    public static String getMergedCssChild(String parent, String child) {
        return parent + ">" + child;
    }

    public static String getMergedCssNext(String first, String second) {
        return first + "+" + second;
    }

    public static String getMergedCssAnd(String css1, String css2) {
        return css1 + css2;
    }


    public static String getAllColumns() {
        return "[data-columnindex]";
    }

    public static String getDataTest(String target) {
        return "[data-test=\"" + target + "\"]";
    }

    public static String getDataColumn(String target) {
        return "[data-column=\"" + target + "\"]";
    }

    public static String getDataTestContains(String target) {
        return "[data-test*=\"" + target + "\"]";
    }

    static String getLoaderCss() {
        return "[class*=\"loader active\"]";
    }

    static String getNumberCSS(String target) {
        return "[id=\"dialog-checkbox-" + target + "\"]+span";
    }

    static String getAddNumberCSS(String target) {
        return "[id=\"dialog-additional-checkbox-" + target + "\"]+span";
    }

    public static String getNumberCountCSS(String target) {
        return "[value=\"" + target + "\"]+span";
    }



    public static String getConsentPageCss() {
        return "[class=\"consents-bar active layout-bottom\"]";
    }

    static List<String> GetLoadingCsss() {
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

    static List<String> getObstacles() {
        ArrayList<String> result = new ArrayList<>();
        result.add("[class*=\"loader active\"]");
        result.add("[id=\"alertModal\"]");
        result.add("[id=\"dialog-confirm\"]");
        result.add("[class=\"additional-info\"]");
        result.add("[class=\"modal fade modal-grey modal-confirm-online-bet show\"]");

        return result;
    }


    public static String locatorMap(String key) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("login", "neo-login");
        hashtable.put("user", "user");
        hashtable.put("password", "password");
        hashtable.put("submit", "submit");
        hashtable.put("myProfile", "userName");
        hashtable.put("logout", "btn-logout");
        hashtable.put("ok", "buttons");
        hashtable.put("myWagers", "myWagers");
        hashtable.put("wagerList", "wager-list");
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
