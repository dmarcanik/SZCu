package cz.sazka.tests.Db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GadgetHandler {
    private static Logger log = LogManager.getRootLogger();


    public static boolean isGadgetContained(String value) {
        Boolean idInDB = false;
        try {

            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT reference FROM DASHBOARDGADGET");
            while (resultSet.next()) {
                if (resultSet.getString("reference").equals(value)) {
                    idInDB = true;
                    break;
                }

            }
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }

        return idInDB;

    }

    public static ArrayList<String> getGadgetIds(String target) {
        ArrayList<String> ids = new ArrayList<>();
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();

            ResultSet resultSet = statement.executeQuery("SELECT ID FROM DASHBOARDGADGET WHERE REFERENCE='" + target + "' AND DASHBOARD_ID!='-52'");
            while (resultSet.next()) {
                ids.add(resultSet.getString("ID"));
            }
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return ids;
    }

    public static String getGatgetId(String target) {
        String gadgetId ="";

        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM DASHBOARDGADGET WHERE REFERENCE='" + target + "' AND DASHBOARD_ID!='-52'");
            resultSet.next();
            gadgetId = resultSet.getString("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gadgetId;
    }
}
