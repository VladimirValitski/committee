package com.valitski.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.valitski.dbSourse.DataSource;
import com.valitski.dto.Entity;
import com.valitski.dto.FacultyDTO;
import com.valitski.util.ManagerSQL;

/**
 * Class FacultyDAO implements request from database
 */
public class FacultyDAO implements Dao {
    private static final String SQL_INSERT_FACULTY = ManagerSQL.getProperty("SQL_INSERT_FACULTY");
    private static final String SQL_SELECT_ALL_FACULTY = ManagerSQL.getProperty("SQL_SELECT_ALL_FACULTY");
    private static final String SQL_FIND_BY_ID_FACULTY = ManagerSQL.getProperty("SQL_FIND_BY_ID_FACULTY");

    /**
     * Method  create() create entity by faculty
     */
    public boolean create(FacultyDTO entity) throws SQLException {
        ArrayList<FacultyDTO> facultyBD = new ArrayList<>();
        // Filling the database table
        PreparedStatement preparedstatement = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            preparedstatement = cn.prepareStatement(SQL_INSERT_FACULTY);
            for (FacultyDTO faculty : facultyBD) {
                preparedstatement.setInt(1, faculty.getId_faculty());
                preparedstatement.setString(2, faculty.getName_faculty());
                preparedstatement.setInt(3, faculty.getEnrollment());
                preparedstatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL exception: " + e);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            System.out.println("PropertyVetoException: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: " + e);
        } finally {
            try {
                preparedstatement.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Request failed.");
            }
        }
        return true;
    }

    /**
     * Method  List<FacultyDTO> findAll() find all faculties
     */
    public List<FacultyDTO> findAll() {
        List<FacultyDTO> fucultyList = new ArrayList<>();
        Statement st = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_FACULTY);
            while (resultSet.next()) {
                FacultyDTO facultyDTO = new FacultyDTO();
                facultyDTO.setId_faculty(resultSet.getInt("id_faculty"));
                facultyDTO.setName_faculty(resultSet.getString("name_faculty"));
                facultyDTO.setEnrollment(resultSet.getInt("enrollment"));
                fucultyList.add(facultyDTO);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception request failed): " + e);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            System.out.println("PropertyVetoException: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: " + e);
        } finally {
            try {
                st.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Request  failed.");
            }
        }
        return fucultyList;
    }

    /**
     * Method  List<Entity> findEntityById() finding entity by Id
     */
    public List<Entity> findEntityById(int id) {
        List<Entity> findByIdList = new ArrayList<>();
        Entity entityDTO = null;
        ResultSet resultSet = null;
        PreparedStatement preparedstatement = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            preparedstatement = cn.prepareStatement(SQL_FIND_BY_ID_FACULTY);
            preparedstatement.setInt(1, id);
            resultSet = preparedstatement.executeQuery();
            while (resultSet.next()) {
                entityDTO.setName_faculty(resultSet.getString("name_faculty"));
                entityDTO.setEnrollment(resultSet.getInt("enrollment"));
                entityDTO.setPasport(resultSet.getString("pasport"));
                entityDTO.setTotal_score(resultSet.getInt("total_score"));
                findByIdList.add(entityDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL exception request failed): " + e);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            System.out.println("PropertyVetoException: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: " + e);
        } finally {
            try {
                resultSet.close();
                preparedstatement.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Request  failed.");
            }
        }
        return findByIdList;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object read(int id) throws SQLException {
        return null;
    }

    @Override
    public List update(Object entity) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
