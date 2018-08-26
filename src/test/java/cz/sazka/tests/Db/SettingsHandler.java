package cz.sazka.tests.Db;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SettingsHandler {
    private static Logger log = LogManager.getRootLogger();


    public static String getSettingsValue(String value) throws SQLException {
        String settingsValue = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DATA FROM datastore WHERE name='" + value + "'");
            resultSet.next();
            settingsValue = resultSet.getString("DATA");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return settingsValue;
    }

    public static String getAuthServerId(String value) {
        String authServer = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  ID FROM AUTHSERVER WHERE name='" + value + "'");
            resultSet.next();

            authServer = resultSet.getString("ID");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return authServer;
    }


    public static boolean isLicenseContained(String value) throws SQLException {
        Boolean idInDB = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM TBLLICENSE");
            while (resultSet.next()) {
                if (resultSet.getString("ID").equals(value)) {
                    idInDB = true;
                    break;
                }

            }
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }

        return idInDB;

    }


}
