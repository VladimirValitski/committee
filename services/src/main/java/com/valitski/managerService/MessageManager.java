package com.valitski.managerService;

import java.util.ResourceBundle;

/**
 * Class MessageManager connect whith  messages.properties
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    private MessageManager() {
    }

    /**
     * Method getProperty() take messages from messages.properties
     */
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}