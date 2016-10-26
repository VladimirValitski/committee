package com.valitski.command;

import com.valitski.dao.StatementDAO;
import com.valitski.dto.StatementDTO;
import com.valitski.managerService.ConfigurationManager;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Class CreateStatementCommand implements requests for creating of statement
*/
public class CreateStatementCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        StatementDAO statementDAO = null;
        StatementDTO statementDTO = new StatementDTO();
        statementDTO.setPasport(request.getParameter("pasport"));
        statementDTO.setSubject_two(Integer.parseInt(request.getParameter("subject_one")));
        statementDTO.setSubject_two(Integer.parseInt(request.getParameter("subject_two")));
        statementDTO.setSchool_certificate(Integer.parseInt(request.getParameter("school_certificate")));
        statementDTO.setId_faculty(Integer.parseInt(request.getParameter("id_faculty")));
        try {
            statementDAO.create(statementDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page = ConfigurationManager.getProperty("path.page.infoAbitur");
        return page;
    }

}
