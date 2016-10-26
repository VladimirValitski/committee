package com.valitski.command;

import com.valitski.dao.ResultDAO;
import com.valitski.dto.ResultDTO;
import com.valitski.managerService.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class CheckAbiturCommand implements requests to verify of abiturient
 */
public class CheckAbiturCommand implements ActionCommand {
    /**
     * Method execute() Override ActionCommand method
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        ResultDAO resultDAO = null;
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setPasport(request.getParameter("pasport"));
        int result = resultDAO.findEntityById(resultDTO.getPasport());
        if (Integer.toString(result) != null) {
            // определение пути в зависимости от пользователя
            if (result == 1) {
                page = ConfigurationManager.getProperty("path.page.AbiturSuccess");
            } else if (result == 0) {
                page = ConfigurationManager.getProperty("path.page.AbiturUnSuccess");
            } else {
                page = ConfigurationManager.getProperty("path.page.checkAbitur");
            }
        } else {
            page = ConfigurationManager.getProperty("path.page.checkAbitur");
        }

        return page;
    }

}
