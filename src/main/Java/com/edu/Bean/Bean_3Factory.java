package com.edu.Bean;

//Bean_3实例工厂
public class Bean_3Factory {
    public Bean_3 createBean3(){
        System.out.println("Bean_3执行了...");
        return new Bean_3();
    }
}
