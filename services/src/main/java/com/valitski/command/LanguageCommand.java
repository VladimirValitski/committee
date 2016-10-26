package com.valitski.command;

import com.valitski.managerService.ConfigurationManager;
import com.valitski.managerService.LanguageBundle;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class LanguageCommand implements requests for setting of languages
 */
public class LanguageCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        HttpSession session = request.getSession(true);
        Locale.setDefault(new Locale(request.getParameter("language").toLowerCase(), request.getParameter("language").toUpperCase()));
        LanguageBundle.addLanguage(request.getParameter("language") + ".properties", request);
        session.setAttribute("language", request.getParameter("language"));
        page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
