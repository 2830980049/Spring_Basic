package com.edu.Bean;

public class UserDaoImpl implements UserDao{
    @Override
    public void findAll() {
        System.out.println("查询用户...");
    }

    @Override
    public void save() {
        System.out.println("保存用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }
}
