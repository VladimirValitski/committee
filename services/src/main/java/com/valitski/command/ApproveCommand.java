package com.valitski.command;

import com.valitski.dao.ResultDAO;
import com.valitski.dto.ResultDTO;
import com.valitski.managerService.ConfigurationManager;
import com.valitski.managerService.MessageManager;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Class ApproveCommand implements requests for approval of abiturient
 */
public class ApproveCommand implements ActionCommand {
    /**
     *
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        ResultDAO resultDAO = null;
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setPasport(request.getParameter("pasport"));
        resultDTO.setAccept(Integer.parseInt(request.getParameter("accept")));
        try {
            if (resultDAO.create(resultDTO)) {
                page = ConfigurationManager.getProperty("path.page.adminRequest");
            } else {
                request.setAttribute("errorMessage", MessageManager.getProperty("path.page.error"));
                page = ConfigurationManager.getProperty("path.page.error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return page;
    }

}
