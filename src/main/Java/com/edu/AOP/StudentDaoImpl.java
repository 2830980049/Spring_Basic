package com.edu.AOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
public class StudentDaoImpl implements StudentDao{

    @Override
    public void find() {
        System.out.println("学生查询...");
    }
    @Override
    public void save() {
        System.out.println("学生保存...");
    }
    @Override
    public void update() {
        System.out.println("学生修改...");
    }
}
