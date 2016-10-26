package com.valitski.command;

import com.valitski.dao.FacultyDAO;
import com.valitski.dto.FacultyDTO;
import com.valitski.managerService.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class GetListAdminCommand implements requests for geting list of faculty
 */
public class GetListAdminCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        FacultyDAO facultyDAO = null;
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setId_faculty(Integer.parseInt(request.getParameter("id_faculty")));
        facultyDAO.findEntityById(facultyDTO.getId_faculty());
        page = ConfigurationManager.getProperty("path.page.adminResult");
        return page;
    }

}
