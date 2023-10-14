package com.practice.expandtesting.environment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesUtils {

    private static final Properties properties = new Properties();
    private static final Logger LOGGER = LogManager.getLogger(PropertiesUtils.class);

    public static String getBaseUrl(String key) {
        return PropertiesUtils.readProperties().getProperty(key);
    }

    public static Properties readProperties() {
        try {
            properties.load(FileReader.readFile());
        } catch (IOException e) {
            LOGGER.error("Property not found", e);
        }
        return properties;
    }
}
