package com.edu.ShiWu.service.Impl;

import com.edu.ShiWu.dao.OrderDao;
import com.edu.ShiWu.dao.ProductDao;
import com.edu.ShiWu.entity.Order;
import com.edu.ShiWu.entity.Product;
import com.edu.ShiWu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Transactional()
    public void addOrder(Order order) {
        order.setCreateTime(new Date());
        order.setStatus("待付款");
        //持久化操作
        orderDao.insert(order);
        Product product = productDao.select(order.getProductsId());
        product.setStock(product.getStock() - order.getNumber());
        productDao.update(product);
    }
}
