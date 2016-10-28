package com.valitski.commandFactory;

import com.valitski.command.ActionCommand;
import com.valitski.command.EmptyCommand;
import com.valitski.commandEnum.CommandEnum;
import com.valitski.managerService.MessageManager;

import javax.servlet.http.HttpServletRequest;

/*
 * Class ActionFactory determines command from enum
*/
public class ActionFactory {
    /**
     * Method defineCommand() define command from enum
     */
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command ");
        if (action == null || action.isEmpty()) {
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
