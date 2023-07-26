package uitls;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProviderManager {
    private static final String PROPERTIES_FILE = "config.properties";
    private static Properties properties;

    public static String getAccessToken(String data) {
        if (properties == null) {
            loadProperties();
        }
        switch (data) {
            case "valid":
                return properties.getProperty("accessToken");
            case "invalid":
                return properties.getProperty("invalidaccessToken");
            case "baseurl":
                return properties.getProperty("baseurl");
            default:
                // code block
        }
        return properties.getProperty("accessToken");
    }

    public static String getEndPoint(String data) {
        if (properties == null) {
            loadProperties();
        }
        switch (data) {
            case "issues":
                return properties.getProperty("issueendpoint");
            case "repo":
                return properties.getProperty("repo");
            case "invalidrepo":
                return properties.getProperty("invalidrepo");
        }
        return null;
    }

    public static String getBaseURL() {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty("baseurl");
    }

    private static void loadProperties() {
        properties = new Properties();
        try (InputStream inputStream = ProviderManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
