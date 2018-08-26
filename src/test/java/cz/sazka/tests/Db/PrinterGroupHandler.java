package cz.sazka.tests.Db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrinterGroupHandler {
    private static Logger log = LogManager.getRootLogger();

    public static String getPrinterGroupId(String name) {
        String printerGroupId = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM PRINTERGROUP WHERE NAME='" + name + "'");
            resultSet.next();

            printerGroupId = resultSet.getString("ID");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);

        }
        return printerGroupId;

    }

    public static String getPrinterGroupParentId(String subgroup) {
        String groupParentId = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT PARENTID FROM PRINTERGROUP WHERE NAME='" + subgroup + "' ");
            resultSet.next();
            groupParentId = resultSet.getString("PARENTID");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }

        return groupParentId;
    }

    public static boolean isPrinterGroupContained(String group) throws SQLException {
        Boolean idInDB = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NAME FROM PRINTERGROUP");
            while (resultSet.next()) {
                if (resultSet.getString("NAME").equals(group)) {
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
