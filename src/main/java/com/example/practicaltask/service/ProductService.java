package com.example.practicaltask.service;

import java.util.ArrayList;

import com.example.practicaltask.dao.ProductDao;
import com.example.practicaltask.entity.Product;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Services, which are used in "products" scope
 */
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * Creates certain product
     * @param product product to be created
     */
    public void createProduct(Product product){
        productDao.createProduct(product);
    }

    /**
     * Deletes certain product
     * @param product product to be deleted
     */
    public void deleteProduct(long id) throws Exception{
        productDao.deleteProduct(id);
    }

    /**
     * Lists all the existing products
     * @return list of all existing products
     */
    public ArrayList<Product> getAllProducts(){
        return productDao.getAllProducts();
    }
}
