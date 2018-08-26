package cz.sazka.tests.Db;

import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserHandler {

    private static Logger log = LogManager.getRootLogger();


    public static boolean isPasswordContained(String user, String password) throws SQLException, NoSuchAlgorithmException {
        boolean passContained = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT PWD FROM entity WHERE name='" + user + "'");
            resultSet.next();
            String DbValue = resultSet.getString(1);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(), 0, password.length());
            byte[] digest = messageDigest.digest();
            String result = new String(Hex.encodeHex(digest));
            passContained = DbValue.equals(result);

        } catch (SQLException | NoSuchAlgorithmException e) {
            log.error("ERROR: \n", e);
        }
        return passContained;
    }

    public static Boolean isCardContained(String user, String card) {
        Boolean cardInDb = false;
        try {
            String ID = getUserID(user);
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CARD_ID FROM TBLCARD WHERE USER_ID='" + ID + "' AND ISPIN='0';");

            ArrayList<String> list = new ArrayList<String>();
            while (resultSet.next()) {
                list.add(resultSet.getString("CARD_ID"));
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(card.getBytes(), 0, card.length());
            byte[] digest = messageDigest.digest();
            String result = new String(Hex.encodeHex(digest)).toUpperCase();

            for (Object item : list) {
                if (item.equals(result)) {
                    cardInDb = true;
                    break;

                }
            }

        } catch (SQLException | NoSuchAlgorithmException e) {
            log.error("ERROR: \n", e);
        }
        return cardInDb;
    }


    public static Boolean isPinContained(String user, String pin) {
        Boolean pinInDB = false;
        try {
            String ID = getUserID(user);
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CARD_ID FROM TBLCARD WHERE USER_ID='" + ID + "' AND ISPIN='1';");

            ArrayList<String> list = new ArrayList<String>();
            while (resultSet.next()) {
                list.add(resultSet.getString("CARD_ID"));
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(pin.getBytes(), 0, pin.length());
            byte[] digest = messageDigest.digest();
            String result = new String(Hex.encodeHex(digest)).toUpperCase();

            for (Object item : list) {
                if (item.equals(result)) {
                    pinInDB = true;
                    break;

                }
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            log.error("ERROR: \n", e);
        }
        return pinInDB;
    }

    public static String getUserEmail(String user) {
        String userEmail = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT EMAIL FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userEmail = resultSet.getString("EMAIL");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userEmail;
    }

    public static String getUserFullname(String user) {
        String userFullname = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT FULLNAME FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userFullname = resultSet.getString("FULLNAME");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userFullname;
    }

    public static String getUserStorage(String user) {
        String userStorage = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SCANSTORAGE FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userStorage = resultSet.getString("SCANSTORAGE");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userStorage;
    }


    public static String getUserLang(String user) {
        String userLang = "";

        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT LANG FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userLang = resultSet.getString("LANG");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userLang;
    }


    public static String getUserID(String user) {
        String id = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT ID FROM entity WHERE name='" + user + "'");
            resultSet.next();
            id = resultSet.getString(1);

        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }

        return id;
    }

    public static String getEntiyName(String id) {
        String name = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NAME FROM entity WHERE ID='" + id + "'");
            resultSet.next();
            name = resultSet.getString(1);

        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }

        return name;
    }

    public static boolean isUserActive(String user) {
        boolean userActive = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT IS_ACTIVE FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userActive = resultSet.getBoolean("IS_ACTIVE");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userActive;
    }

    public static double getUserCredit(String user) throws SQLException {
        double userCredit = 0;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CREDIT FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userCredit = resultSet.getDouble("CREDIT");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userCredit;
    }

    public static String getUserCode(String user) throws SQLException {
        String userCode = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CODE FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userCode = resultSet.getString("CODE");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userCode;
    }

    public static String getUserDelegate(String userId) {
        String delegateId = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DELEGATE_ID FROM PRINTDELEGATE WHERE ENTITY_ID='" + userId + "'");
            resultSet.next();

            delegateId = resultSet.getString("DELEGATE_ID");

        } catch (SQLException e) {
            log.error("ERROR: \n", e);

        }
        return delegateId;

    }


    public static String getUserNotes(String user) {
        String userNotes = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NOTES FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userNotes = resultSet.getString("NOTES");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userNotes;
    }

    public static String getUserPhone(String user) {
        String userPhone = "";
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT PHONE FROM entity WHERE name='" + user + "'");
            resultSet.next();
            userPhone = resultSet.getString("PHONE");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return userPhone;
    }

    public static boolean isUseAuthServerActive(String user) {
        boolean authServerActive = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT USEAUTHSERVER FROM entity WHERE name='" + user + "'");
            resultSet.next();
            authServerActive = resultSet.getBoolean("USEAUTHSERVER");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return authServerActive;
    }

    public static boolean isQuotaActive(String user) {
        boolean quotaActive = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT QUOTAACTIVE FROM entity WHERE name='" + user + "'");
            resultSet.next();
            quotaActive = resultSet.getBoolean("QUOTAACTIVE");
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return quotaActive;
    }

    public static boolean isUserContained(String user) {
        boolean idInDb = false;
        try {
            Statement statement = DatabaseConnector.getDatabaseStatement();
            ResultSet resultSet = statement.executeQuery("SELECT NAME FROM ENTITY WHERE CLASS='1'");
            while (resultSet.next()) {
                if (resultSet.getString("NAME").equals(user)) {
                    idInDb = true;
                    break;
                }
            }
        } catch (SQLException e) {
            log.error("ERROR: \n", e);
        }
        return idInDb;
    }


}
