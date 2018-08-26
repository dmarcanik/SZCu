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

    public static String getUserHash(String userId, String tab) {
        return "{\"r\":\"users\",\"filter\":{\"filterID\":3},\"d\":{\"r\":\"user\",\"id\":" + userId + ",\"tab\":\"tab" + tab + "\"}}";
    }

    public static String getPrinterHash(String printerId, String tab) {
        return "{\"r\":\"printers\",\"d\":{\"r\":\"printer\",\"id\":" + printerId + ",\"tab\":\"" + tab + "\"},\"fid\":-16}";

    }

    public static String getPrinterGroupHash(String groupId) {
        return "{\"r\":\"printers\",\"fid\":" + groupId + "}";
    }

    public static String getUserGroupHash(String groupId) {
        return "{\"r\":\"users\",\"filter\":{\"filterID\":" + groupId + "}}";
    }

    public static String getDiscoveryHAsh(String discoveryId, String tab) {
        return "{\"r\":\"printerDiscovery\",\"d\":{\"r\":\"range\",\"id\":" + discoveryId + ",\"tab\":\"" + tab + "\"}}";

    }

    public static String getQueueHash(String queueId, String tab) {
        return "{\"r\":\"queues\",\"d\":{\"r\":\"queue\",\"id\":" + queueId + ",\"tab\":\"tab" + tab + "\"}}";
    }


    public static String getUserFilterHash(String filter) {
        return "{\"r\":\"users\",\"filter\":{\"filterID\":" + filter + "}}";
    }

    public static String getPrinterFilterHash(String filter) {
        return "{\"r\":\"printers\",\"fid\":" + filter + "}";
    }
}
