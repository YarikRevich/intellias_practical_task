package com.example.practicaltask.repository;

import org.springframework.stereotype.Repository;
import com.example.practicaltask.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findById(long id);
    public boolean existsById(long id);
}

