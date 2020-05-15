package com.edu.Bean;

//Bean_2静态工厂
public class Bean_2Factory {
    public static Bean_2 createBean_2(){
        System.out.println("Bean_2执行...");
        return new Bean_2();
    }
}
