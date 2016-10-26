package com.valitski.dao;

import com.valitski.dbSourse.DataSource;
import com.valitski.dto.Entity;
import com.valitski.dto.StatementDTO;
import com.valitski.util.ManagerSQL;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class StatementDAO implements request from database
 */
public class StatementDAO implements Dao {
    private static final String SQL_INSERT_ST = ManagerSQL.getProperty("SQL_INSERT_ST");
    private static final String SQL_SELECT_ALL_STATEMENTS = ManagerSQL.getProperty("SQL_SELECT_ALL_STATEMENTS");

    /**
     * Method  create() create entity by statement table
     */
    public boolean create(StatementDTO entity) throws SQLException {
        ArrayList<StatementDTO> statementBD = new ArrayList<>(); // заполнение таблицы БД
        PreparedStatement preparedstatement = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            preparedstatement = cn.prepareStatement(SQL_INSERT_ST);
            for (StatementDTO state : statementBD) {
                preparedstatement.setString(1, state.getPasport());
                preparedstatement.setInt(2, state.getSubject_one());
                preparedstatement.setInt(3, state.getSubject_two());
                preparedstatement.setInt(4, state.getSchool_certificate());
                preparedstatement.setInt(5, state.getId_faculty());
                preparedstatement.executeUpdate();
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
                preparedstatement.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Request failed.");
            }
        }
        return true;
    }

    /**
     * Method  List<StatementDTO> findAll() find all statements
     */
    public List<StatementDTO> findAll() {
        List<StatementDTO> statementList = new ArrayList<>();
        ResultSet resultSet = null;
        Statement st = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            st = cn.createStatement();
            resultSet = st.executeQuery(SQL_SELECT_ALL_STATEMENTS);
            while (resultSet.next()) {
                StatementDTO statementDTO = new StatementDTO();
                statementDTO.setPasport(resultSet.getString("pasport"));
                statementDTO.setSubject_one(resultSet.getInt("subject_one"));
                statementDTO.setSubject_two(resultSet.getInt("subject_two"));
                statementDTO.setSchool_certificate(resultSet.getInt("school_certificate"));
                statementDTO.setTotal_score(resultSet.getInt("total_score"));
                statementDTO.setId_faculty(resultSet.getInt("id_faculty"));
                statementList.add(statementDTO);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            System.out.println("PropertyVetoException: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException: " + e);
        } finally {
            try {
                resultSet.close();
                st.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Request  failed.");
            }
        }
        return statementList;
    }

    @Override
    public boolean create(Object entity) throws SQLException {
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
