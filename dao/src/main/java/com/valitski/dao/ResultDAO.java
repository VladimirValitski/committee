package com.valitski.dao;

import com.valitski.dbSourse.DataSource;
import com.valitski.dto.ResultDTO;
import com.valitski.util.ManagerSQL;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class ResultDAO implements request from database
 */
public class ResultDAO implements Dao {
    private static final String SQL_INSERT_RESULT = ManagerSQL.getProperty("SQL_INSERT_RESULT");
    private static final String SQL_SELECT_ALL_RESULT = ManagerSQL.getProperty("SQL_SELECT_ALL_RESULT");
    private static final String SQL_FIND_BY_PASSPORT = ManagerSQL.getProperty("SQL_FIND_BY_PASSPORT");

    /**
     * Method  create() create entity by result table
     */
    public boolean create(ResultDTO entity) throws SQLException {
        ArrayList<ResultDTO> resultBD = new ArrayList<>();
        // Filling the database table
        PreparedStatement preparedstatement = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            preparedstatement = cn.prepareStatement(SQL_INSERT_RESULT);
            for (ResultDTO result : resultBD) {
                preparedstatement.setString(1, result.getPasport());
                preparedstatement.setInt(2, result.getAccept());
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
     * Method  findEntityById() finding entity by passport
     */
    public int findEntityById(String passportAbitur) {
        int resultFind = 0;
        ResultSet resultSet = null;
        PreparedStatement preparedstatement = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            preparedstatement = cn.prepareStatement(SQL_FIND_BY_PASSPORT);
            preparedstatement.setString(1, passportAbitur);
            resultSet = preparedstatement.executeQuery();
            resultFind = resultSet.getInt("accept");
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
                resultSet.close();
                preparedstatement.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Request  failed.");
            }
        }
        return resultFind;
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
