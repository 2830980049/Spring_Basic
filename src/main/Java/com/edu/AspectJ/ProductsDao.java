package com.edu.AspectJ;

public class ProductsDao {
    public void save(){
        System.out.println("保存");
    }
    public void update(){
        System.out.println("修改");
    }
    public String delete(){
        System.out.println("删除");
        return "删除成功";
    }
    public void find(){
        System.out.println("查询");
    }
}
