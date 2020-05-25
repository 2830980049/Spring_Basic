package com.edu.AOP;

import org.springframework.stereotype.Repository;

@Repository("CustomDao")
public class CustomDaoImpl implements CustomDao{
    public void find() {
        System.out.println("消费者查询...");
    }
    public void save() {
        System.out.println("消费者保存...");
    }
    public void update() {
        System.out.println("消费者修改...");
    }
}
