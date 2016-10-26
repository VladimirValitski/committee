package com.valitski.command;

import com.valitski.dao.AbiturientDAO;
import com.valitski.dto.AbiturientDTO;
import com.valitski.managerService.ConfigurationManager;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class CreateAbiturCommand implements requests for creating of abiturients
 */
public class CreateAbiturCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        AbiturientDAO abiturientDAO = null;
        AbiturientDTO abiturient = new AbiturientDTO();
        abiturient.setLast_name(request.getParameter("last_name"));
        abiturient.setFirst_name(request.getParameter("first_name"));
        abiturient.setSecond_name(request.getParameter("second_name"));
        abiturient.setPhone(request.getParameter("phone"));
        abiturient.setPasport(request.getParameter("pasport"));
        try {
            abiturientDAO.create(abiturient);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        page = ConfigurationManager.getProperty("path.page.createAbiturTwo");
        return page;
    }

}
