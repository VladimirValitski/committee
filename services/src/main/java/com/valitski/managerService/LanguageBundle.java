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
    /**
     * Method addLanguage() add language
     */
    public static void addLanguage(String fileURL, HttpServletRequest request) {
        Properties properties = new Properties();
        InputStream in = LanguageBundle.class.getClassLoader().getResourceAsStream(fileURL);
        String resBundle = Locale.getDefault().getLanguage().toUpperCase();
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            System.out.print("Language not found");
        }
        for (Object key : properties.keySet()) {
            String value = properties.getProperty((String) key);
            request.getSession().setAttribute((String) key, value);
        }
    }
}