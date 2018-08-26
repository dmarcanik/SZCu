package cz.sazka.tests.Db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueueHandler {

    private static Logger log = LogManager.getRootLogger();

    public static boolean isQueueContained(String queueName) {
        boolean idInDb = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NAME FROM TBLQUEUES");
            while (resultSet.next()) {
                if (resultSet.getString("NAME").equals(queueName)) {
                    idInDb = true;
                    break;
                }
            }
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return idInDb;
    }

    public static String getQueueId(String name) {
        String queueId = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM TBLQUEUES WHERE NAME='" + name + "'");
            resultSet.next();
            queueId = resultSet.getString("ID");

        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return queueId;
    }

    public static boolean isQueueOnline(String queueName) {
        boolean queueOnline = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT STATE FROM TBLQUEUES WHERE NAME='" + queueName + "'");
            resultSet.next();
            if (resultSet.getString("STATE").equals("2")) {
                queueOnline = true;
            }
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return queueOnline;
    }


}
