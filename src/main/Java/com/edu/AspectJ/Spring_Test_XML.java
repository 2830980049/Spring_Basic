package com.edu.AspectJ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:AspectJ_XML.xml")
public class Spring_Test_XML {
    @Resource(name = "customerdao")
    private CustomerDao customerDao;
    @Test
    public void demo1(){
        customerDao.delete();
        customerDao.finnd();
        customerDao.save();
        customerDao.update();
    }
}
