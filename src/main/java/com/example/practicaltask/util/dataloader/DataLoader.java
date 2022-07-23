package com.example.practicaltask.util.dataloader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import com.example.practicaltask.dao.UserDao;
import com.example.practicaltask.dao.ProductDao;

import com.example.practicaltask.entity.User;
import com.example.practicaltask.entity.Product;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service, which is used for initial data loading
 * for product and user repositories
 */
@Service
public class DataLoader implements ApplicationRunner {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    public void run(ApplicationArguments args) {
        User user1 = new User();
        user1.setFirstName("Boris");
        user1.setLastName("Johnson");
        user1.setMoneyAmount(1000);

        User user2 = new User();
        user2.setFirstName("Volodymyr");
        user2.setLastName("Zelenskyi");
        user2.setMoneyAmount(100);

        User user3 = new User();
        user3.setFirstName("Yaroslav");
        user3.setLastName("Svitlytskyi");
        user3.setMoneyAmount(2000);

        userDao.createUser(user1);
        userDao.createUser(user2);
        userDao.createUser(user3);

        Product product1 = new Product();
        product1.setName("IPhone X");
        product1.setPrice(550);

        Product product2 = new Product();
        product2.setName("MacBook Pro 2020");
        product2.setPrice(1000);
        
        Product product3 = new Product();
        product3.setName("Google Pixel 4");
        product3.setPrice(500);

        productDao.createProduct(product1);
        productDao.createProduct(product2);
        productDao.createProduct(product3);
    }
}
