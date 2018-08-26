package cz.sazka.tests.Db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrinterHandler {
    private static Logger log = LogManager.getRootLogger();

    public static String getPrinterId(String printerIp) {
        String printerId = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();

            printerId = resultSet.getString("ID");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);

        }
        return printerId;

    }

    public static String getPrinterName(String printerIp) {
        String printerName = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NAME FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            printerName = resultSet.getString("NAME");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return printerName;
    }

    public static boolean isPrinterFaxActive(String printerIp) {
        boolean faxActive = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FAXPRESENT FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            faxActive = resultSet.getBoolean(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }


        return faxActive;
    }

    public static boolean isPrinterCoveradgeActive(String printerIp) {
        boolean faxActive = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COVERAGE FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            faxActive = resultSet.getBoolean(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return faxActive;
    }

    public static int isPrinterActive(String printerIp) {
        int state = 0;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT STATE FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            state = resultSet.getInt(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return state;
    }

    public static int getTerminalType(String printerIp) {
        int type = 0;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TERMINALTYPE FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            type = resultSet.getInt(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }


        return type;
    }

    public static String getPrinterAdminUsername(String printerIp) {
        String printerAdminUsername = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ADMINUSER FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            printerAdminUsername = resultSet.getString(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return printerAdminUsername;
    }

    public static String getPrinterAdminPass(String printerIp) {
        String printerAdminPass = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ADMINPWD FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            printerAdminPass = resultSet.getString(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }


        return printerAdminPass;
    }

    public static String getPrinterNotes(String printerIp) {
        String printerNotes = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MEMO FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            printerNotes = resultSet.getString(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }


        return printerNotes;
    }

    public static String getPrinterSnmp(String printerIp) {
        String getPrinterSnmp = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SNMPPROFILE_ID FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            getPrinterSnmp = resultSet.getString(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return getPrinterSnmp;
    }

    public static int getSimpleLoginMethod(String printerIp) {
        int loginMethod = 0;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT LOGINMETHODSIMPLE FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            loginMethod = resultSet.getInt(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return loginMethod;
    }

    public static int getTwoStepLoginMethod(String printerIp) throws SQLException {
        int twoStepLoginMethod = 0;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT LOGINMETHOD FROM TBLPRINTERS WHERE IP_ADDRESS='" + printerIp + "'");
            resultSet.next();
            twoStepLoginMethod = resultSet.getInt(1);
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return twoStepLoginMethod;
    }


}
