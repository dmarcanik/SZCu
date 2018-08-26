package cz.sazka.tests.Db;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiscoveryHandler {

    private static Logger log = LogManager.getRootLogger();

    public static String getDiscoveryId(String name) {
        String result = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM PRINTERDISCOVERY WHERE NAME='" + name + "'");
            resultSet.next();
            result = resultSet.getString("ID");
        } catch (SQLException e) {
            log.error("ERROR: ", e);
        }
        return result;
    }

    public static boolean isDiscoveryContained(String name){
        Boolean idInDB = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM PRINTERDISCOVERY WHERE NAME='" + name + "'");
            while (resultSet.next()) {
                if (resultSet.getString("reference").equals(name)) {
                    idInDB = true;
                    break;
                }

            }
        }catch (SQLException e){
            log.error("ERROR: ", e);
        }

        return idInDB;
    }
}
