package com.valitski.command;

import com.valitski.managerService.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class ReturnCommand return to the login page
 */
public class ReturnCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        /*redirected to the login page*/
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
