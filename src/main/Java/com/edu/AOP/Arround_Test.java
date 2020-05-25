package com.edu.AOP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ArroundAdvice.xml")
public class Arround_Test {
    @Resource(name = "StudentDaoProxy")
    private StudentDao studentDao;
    @Test
    public void demo(){
        studentDao.find();
        studentDao.save();
        studentDao.update();
    }
}
