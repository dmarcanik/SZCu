package cz.sazka.tests.Db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserGroupHandler {
    private static Logger log = LogManager.getRootLogger();


    public static String getUserGroupId(String name) {
        String userGroupId = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM TBLENTITIES WHERE NAME='" + name + "' AND CLASS='2'");
            resultSet.next();
            userGroupId = resultSet.getString("ID");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);

        }

        return userGroupId;
    }

    public static String getUserGroupParentId(String subgroup) throws SQLException {
        String parentId = "";
        try {
            String groupId = getUserGroupId(subgroup);
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT PARENTID FROM TBLGROUPS WHERE ID='" + groupId + "' ");
            resultSet.next();
            parentId = resultSet.getString("PARENTID");
        } catch (SQLException e) {
            log.error("ERROR: \n ", e);
        }
        return parentId;
    }

    public static boolean isUserGroupContained(String group) throws SQLException {
        Boolean idInDB = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NAME FROM TBLENTITIES");
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
