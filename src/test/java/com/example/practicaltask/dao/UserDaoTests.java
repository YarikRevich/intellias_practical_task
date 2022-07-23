package com.example.practicaltask.dao;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import com.example.practicaltask.entity.User;
import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.util.dataloader.DataLoader;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Integrational tests for UserDao
 */
@Import({DataLoader.class, ProductDao.class, UserDao.class})
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
