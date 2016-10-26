package com.valitski.managerService;

import java.util.ResourceBundle;

/**
 * Class ConfigurationManager connect whith  config.properties
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigurationManager() {
    }

    /**
     * Method getProperty() take path page config.properties
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}