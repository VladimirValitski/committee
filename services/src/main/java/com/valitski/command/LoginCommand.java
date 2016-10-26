package com.valitski.command;

import com.valitski.dao.AbiturientDAO;
import com.valitski.managerService.ConfigurationManager;
import com.valitski.managerService.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class LoginCommand implements requests for checking of login and password
 */
public class LoginCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        // extracting from the request login and password
        String login = request.getParameter(MessageManager.getProperty("message.login"));
        String pass = request.getParameter(MessageManager.getProperty("message.password"));
        // login and password verification
        if ((AbiturientDAO.checkLogin(login, pass)) &&
                (MessageManager.getProperty("message.roleAdmin").equalsIgnoreCase(AbiturientDAO.checkLoginUserRole(pass)))) {
            request.setAttribute("user", login);
            // determining paths depending on the user
            page = ConfigurationManager.getProperty("path.page.adminRequest");
            if ((AbiturientDAO.checkLogin(login, pass)) &&
                    (MessageManager.getProperty("message.roleUser").equalsIgnoreCase(AbiturientDAO.checkLoginUserRole(pass)))) {
                request.setAttribute("user", login);
                page = ConfigurationManager.getProperty("path.page.checkAbitur");
            }
        } else {
            request.setAttribute("errorMessage", MessageManager.getProperty("message.errorLogin"));
            page = ConfigurationManager.getProperty("path.page.error");
        }
        return page;
    }
}
