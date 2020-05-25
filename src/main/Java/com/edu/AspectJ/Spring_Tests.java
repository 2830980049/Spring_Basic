package com.edu.AspectJ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:AspectJ.xml")
public class Spring_Tests {
    @Resource(name = "productsdao")
    private ProductsDao productsDao;
    @Test
    public void demo1(){
        productsDao.delete();
        productsDao.save();
        productsDao.find();
        productsDao.update();
    }
}
