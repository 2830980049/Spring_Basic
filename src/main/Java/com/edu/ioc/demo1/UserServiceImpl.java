package com.edu.ioc.demo1;

public class UserServiceImpl implements UserService{

    //添加属性
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void Hello() {
        System.out.println("Hello "+name+" 年龄 "+age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
