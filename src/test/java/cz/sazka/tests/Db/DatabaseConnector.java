package cz.sazka.tests.Db;

import cz.sazka.tests.DataProviders.ConfigFileReader;
import cz.sazka.tests.Steps.Hook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnector {
    private static Logger log = LogManager.getRootLogger();
    private static WebDriver webDriver = Hook.getDriver();

    public static Statement getDatabaseStatement() throws SQLException {
        Connection connection;
        Statement statement = null;
        try {
            String hostname = ConfigFileReader.getHostname();
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            connection = DriverManager.getConnection("jdbc:firebirdsql://" + hostname + ":3050/C:/ProgramData/MyQ/MYQ.fdb", "sysdba", "masterkey");
            statement = connection.createStatement();

        } catch (SQLException e) {
            log.error("ERROR", e);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return statement;

    }

}
