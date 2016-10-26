package com.valitski.util;

import java.util.ResourceBundle;

/**
 * Class ManagerJDBC take setting from configDB.properties
 */
public class ManagerJDBC {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("configDB");

    private ManagerJDBC() {
    }

    /**
     * Method getProperty() getting value of setting from configDB.properties
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
