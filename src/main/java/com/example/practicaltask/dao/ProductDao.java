package com.example.practicaltask.dao;

import java.util.ArrayList;
import java.util.Optional;

import com.example.practicaltask.entity.Product;
import com.example.practicaltask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.practicaltask.util.exception.ProductNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Dao service which interects with product repository
 */
@Service
public class ProductDao {
    @Autowired
    private ProductRepository productRepository;

    public int getProductPrice(long id) throws Exception{
        Product product = null;
        if (productRepository.existsById(id)){
            product = productRepository.getById(id);
        } else {
            throw new ProductNotFoundException();
        }
        return product.getPrice();
    }

    public Product getProductById(long id) throws Exception{
        Product product = null;
        if (productRepository.existsById(id)){
            product = productRepository.getById(id);
        } else {
            throw new ProductNotFoundException();
        }
        return product;
    }
    
    public ArrayList<Product> getAllProducts(){
        return new ArrayList<Product>(productRepository.findAll());
    }

    /**
     * Creates new product to product repository
     */
    public void createProduct(Product product){
        productRepository.save(product);
    }

    /**
     * Deletes product from product repository
     */
    public void deleteProduct(long id) throws Exception{
        productRepository.delete(this.getProductById(id));
    }
}
