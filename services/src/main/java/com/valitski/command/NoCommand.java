package com.valitski.command;

import com.valitski.managerService.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class NoCommand checks for the command
 */
public class NoCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            /*in the case of a direct appeal to the controller redirects to the login page input*/
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
