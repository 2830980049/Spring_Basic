package com.edu.ShiWu.dao;

import com.edu.ShiWu.entity.Product;

import java.util.List;

public interface ProductDao {
    void insert(Product product);
    void update(Product product);
    void delete(String id);
    Product select(String id);
    List<Product> select();
}
