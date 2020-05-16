package com.edu.annotation;
import org.springframework.stereotype.Repository;
@Repository("WomanDao")
public class WomanDao {
    public void save(){
        System.out.println("DAO中保存用户...");
    }
}
