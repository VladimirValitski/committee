package com.valitski.command;

import com.valitski.managerService.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class SignUpCommand
 */
public class SignUpCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     * redirected to the registration page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        /*redirected to the registration page*/
        String page = ConfigurationManager.getProperty("path.page.createAbiturOne");
        return page;
    }
}
