package com.valitski.util;

import java.util.ResourceBundle;

/**
 * Class ManagerSQL take query from querySQL.properties
 */
public class ManagerSQL {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("querySQL");

    public ManagerSQL() {
    }

    /**
     * Method getProperty() getting query to database from query.properties
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
