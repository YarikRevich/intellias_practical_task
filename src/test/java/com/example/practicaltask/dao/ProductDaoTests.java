package com.example.practicaltask.dao;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.util.dataloader.DataLoader;

import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * Integrational tests for ProductDao
 */
@Import({DataLoader.class, ProductDao.class, UserDao.class})
@DataJpaTest
public class ProductDaoTests {
    @Test
    public void testCreateProduct(){}

    @Test
    public void testDeleteProduct(){}
}
