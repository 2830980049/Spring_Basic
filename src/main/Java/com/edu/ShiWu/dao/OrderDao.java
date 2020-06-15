package com.edu.ShiWu.dao;

import com.edu.ShiWu.entity.Order;

import java.util.List;

public interface OrderDao {
    void insert(Order order);
    void update(Order order);
    void delete(String id);
    Order select(String id);
    List<Order> select();
}