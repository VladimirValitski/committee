package com.valitski.command;

import com.valitski.managerService.ConfigurationManager;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Class EmptyCommand implements null requests
*/
public class EmptyCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }

}
