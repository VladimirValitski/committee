package com.valitski.dao;

import com.valitski.dbSourse.DataSource;
import com.valitski.dto.AbiturientDTO;
import com.valitski.util.ManagerSQL;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class AbiturientDAO implements request from database
 */
public class AbiturientDAO implements Dao {
    private static final String SQL_SELECT_ALL_ABITURIENTS = ManagerSQL.getProperty("SQL_SELECT_ALL_ABITURIENTS");
    private static final String SQL_SELECT_LOGIN = ManagerSQL.getProperty("SQL_SELECT_LOGIN");
    private static final String SQL_SELECT_USER_ROLE = ManagerSQL.getProperty("SQL_SELECT_USER_ROLE");
    private static final String SQL_SELECT_ALL_ABITUR_AND_STATEMENT = ManagerSQL.getProperty("SQL_SELECT_ALL_ABITUR_AND_STATEMENT");
    private static final String SQL_INSERT = ManagerSQL.getProperty("SQL_INSERT");
    private static String role;

    /**
     * Method  List<AbiturientDTO> findAll() find all abiturients
     */
    public List<AbiturientDTO> findAll() {
        List<AbiturientDTO> abiturList = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = DataSource.getInstance().getConnection();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_SELECT_ALL_ABITURIENTS);
            while (resultSet.next()) {
                AbiturientDTO abiturient = new AbiturientDTO();
                abiturient.setLast_name(resultSet.getString("last_name"));
                abiturient.setFirst_name(resultSet.getString("first_name"));
                abiturient.setSecond_name(resultSet.getString("second_name"));
                abiturient.setPhone(resultSet.getString("phone"));
                abiturient.setPasport(resultSet.getString("pasport"));
                abiturList.add(abiturient);
            }
            resultSet.close();
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e);
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
        return abiturList;
    }

    /**
     * Method  create() create entity
     */
    public boolean create(AbiturientDTO entity) throws SQLException, IOException, PropertyVetoException {
        ArrayList<AbiturientDTO> abiturients = new ArrayList<>();
        // Filling the database table
        PreparedStatement preparedstatement = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            preparedstatement = cn.prepareStatement(SQL_INSERT);
            for (AbiturientDTO abiturient : abiturients) {
                preparedstatement.setString(1, abiturient.getLast_name());
                preparedstatement.setString(2, abiturient.getFirst_name());
                preparedstatement.setString(3, abiturient.getSecond_name());
                preparedstatement.setString(4, abiturient.getPhone());
                preparedstatement.setString(5, abiturient.getPasport());
                preparedstatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL exception: " + e);
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
     * Method  checkLogin() check clint for credential
     */
    public static boolean checkLogin(String login, String password) {
        // проверка логина и пароля
        int n = 0;
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            pst = cn.prepareStatement(SQL_SELECT_LOGIN);
            pst.setString(1, login);
            pst.setString(2, password);
            rs = pst.executeQuery();
            // check whether the user exists with the specified username and password
            if (rs.next()) n = 1;
            else n = 0;
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
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("close failed.");
            }
        }
        if (n == 1) {
            return true;
        } else return false;
    }

    /**
     * Method  checkLoginUserRole() check UserRole
     */
    public static String checkLoginUserRole(String userRole) {
        // check of the user role
        ResultSet rs = null;
        PreparedStatement pst = null;
        Connection cn = null;
        try {
            cn = DataSource.getInstance().getConnection();
            pst = cn.prepareStatement(SQL_SELECT_USER_ROLE);
            pst.setString(1, userRole);
            rs = pst.executeQuery();
            role = Integer.toString(rs.getInt("user_role"));
            // find user role
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
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("close failed.");
            }
        }
        return role;
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
