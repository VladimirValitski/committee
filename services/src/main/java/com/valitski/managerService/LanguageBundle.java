package com.valitski.managerService;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;

/**
 * Class LanguageBundle determines locales
 */
public class LanguageBundle {
    public static String resBundle;

    /**
     * Method addLanguage() add language
     */
    public static void addLanguage(String fileURL, HttpServletRequest request) {
        Properties properties = new Properties();
        InputStream in = LanguageBundle.class.getClassLoader().getResourceAsStream("properties/" + fileURL);
        resBundle = "properties/" + Locale.getDefault().getLanguage().toUpperCase();
        try {
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            properties.load(reader);
            reader.close();
            in.close();
        } catch (IOException e) {
        }
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            request.getSession().setAttribute(key, value);
        }
    }
}