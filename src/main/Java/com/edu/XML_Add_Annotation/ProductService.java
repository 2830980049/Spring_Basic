package com.edu.XML_Add_Annotation;

import javax.annotation.Resource;

public class ProductService {
    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;
    @Resource(name = "productDao")
    private ProductDao productDao;
    public void save(){
        System.out.println("ProductService的save方法...");
        categoryDao.save();
        productDao.save();
    }
}
