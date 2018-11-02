package cz.sazka.tests.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class ConfigFileReader {
    private static Logger log = LogManager.getRootLogger();
    private Properties properties;
    private String propertyFilePath = "Configs//Configuration.properties";
    private static String hostname;

    public static String getHostname() {
        return hostname;
    }

    /**
     * Creates configFileReader object which loads paths from configuration file placed in Configs folder.
     *
     */
    public ConfigFileReader() throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                log.error("ERROR while loading properties : \n", e);
                throw e;

            }
        } catch (FileNotFoundException e) {
            log.error("ERROR while loading file : \n", e);
            throw e;
        }
    }

    /**
     * @return driverpath to browser driver.
     */
    public String getDriverPath() {
        String driverPath = properties.getProperty("driverpath");
        if (driverPath != null) {
            return driverPath;
        } else throw new RuntimeException("ERROR: Driver not found in configuration file file may be empty");
    }

    /**
     * @return Url to web environment.
     */
    public String getUrl() throws URISyntaxException {
        String url = properties.getProperty("url");
        if (url != null) {
            URI uri = new URI(url);
            hostname = uri.getHost();
            return url;
        } else throw new RuntimeException("ERROR: standaloneUrl in configuration file may be empty");
    }


}
