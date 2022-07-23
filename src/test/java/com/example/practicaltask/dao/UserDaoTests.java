package com.example.practicaltask.dao;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.entity.User;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Integrational tests for UserDao
 */
@SpringBootTest
@DataJpaTest
public class UserDaoTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        User userReceived = null;
        try {
            userReceived = userDao.getUserById(user.getId());
        } catch (Exception e){
        }
        assertNotNull(userReceived);
        assertEquals(userReceived.getId(), user.getId());
        assertEquals(userReceived.getFirstName(), user.getFirstName());
        assertEquals(userReceived.getLastName(), user.getLastName());
        assertEquals(userReceived.getMoneyAmount(), user.getMoneyAmount());
    }

    @Test
    public void testDeleteUser(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        try{
            userDao.deleteUser(user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }

        try {
            userDao.getUserById(user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getUserById(){
        User user = new User();
        user.setFirstName("Boris");
        user.setLastName("Johnson");
        user.setMoneyAmount(1000);

        userDao.createUser(user);

        try {
            userDao.getUserById(user.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
