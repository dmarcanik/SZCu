package cz.sazka.tests.Utils;

import cz.sazka.tests.Steps.Hook;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public static String getIdPath(String path) {
        String oldxpath = "//*[@id=\"{}\"]";
        return oldxpath.replace("{}", path);
    }

    public static String getClassPath(String path) {
        String oldxpath = "//*[@class=\"{}\"]";
        return oldxpath.replace("{}", path);
    }

    public static String getIdCss(String path) {
        String oldcss = "[id=\"{}\"]";
        return oldcss.replace("{}", path);
    }

    public static String getClassCss(String path) {
        String oldcss = "[class=\"{}\"]";
        return oldcss.replace("{}", path);
    }


    public static String getDataColumnIndex (){
        return "//*[@data-columnindex]";
    }
    public static String getLoaderPath(){
        return "//*[class=\"loader active\"]";
    }




    public static String getLoteryPagePath(String section, String game) {
        return "//*[@href=\"" + "/" + section + "/" + game + "/uvod" + "\"]";
    }
    public static String getConsentPagePath(){
       return  "//*[@class=\"consents-bar active layout-bottom\"]";
    }


    public static String getCmdIdPath(String path) {
        String oldxpath = "//*[@data-cmdid=\"{}\"]";
        return oldxpath.replace("{}", path);
    }


    public static String getPropnamePath(String path) {
        String oldxpath = "//*[@data-propname=\"{}\"]";
        return oldxpath.replace("{}", path);
    }

    public static List<String> getPaths(String path) {
        ArrayList<String> result = new ArrayList<>();
        result.add("//*[@data-propname=\"{}\"]".replace("{}", path));
        result.add("//*[@data-ctrlref=\"{}\"]".replace("{}", path));
        return result;
    }
    public static List<String> GetLoadingCsss() {
        ArrayList<String> result = new ArrayList<>();
        result.add("[class*=\"authenticated\"]");
        result.add("[class*=\"unauthenticated\"]");
        return result;
    }
}
