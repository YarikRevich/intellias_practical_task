package com.example.practicaltask.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.practicaltask.entity.Product;
import com.example.practicaltask.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product); 
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct(@PathVariable long id) throws Exception{
        productService.deleteProduct(id); 
    }

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
