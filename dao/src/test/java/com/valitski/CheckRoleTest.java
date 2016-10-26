package com.valitski;

import com.valitski.dao.AbiturientDAO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class CheckRoleTes describe checking for user role
 */
public class CheckRoleTest {
    /**
     * Method checkLoginUserRole() check request for user role
     */
    @Test
    public void checkLoginUserRole() throws Exception {
        String roleOne = "admin";
        String roleTwo = AbiturientDAO.checkLoginUserRole("password");
        assertEquals(roleOne, roleTwo);
    }
}
