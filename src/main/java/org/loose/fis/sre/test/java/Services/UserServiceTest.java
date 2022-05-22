package org.loose.fis.sre.test.java.Services;


import org.junit.Before;
import org.junit.Test;
import org.loose.fis.sre.services.UserService;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class UserServiceTest extends ApplicationTest {
    @Before
    public void setUp(){
        UserService.loadUsers();
    }

    @Test
    public void loadUsers(){
        UserService.loadUsers();

        assertTrue(UserService.getUsers().size()>0);
    }

    @Test
    public void encodePassword(){
        String s = UserService.encodePassword("pass");

        assertEquals(UserService.encodePassword("pass"), s);
    }
}
