import com.edu.AOP.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_AOP {
    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao)new MyJdkProxy(userDao).createProxy();
        proxy.save();
    }

    @Test
    public void demo2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("proxy.xml");
        StudentDao studentDao = (StudentDao)applicationContext.getBean("StudentDao");
        studentDao.find();
        studentDao.save();
        studentDao.update();
    }

    @Test
    public void demo3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AutoProxy.xml");
        StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
        CustomDao customDao = (CustomDao)applicationContext.getBean("customDao");
        studentDao.find();
        studentDao.save();
        studentDao.update();
        customDao.find();
        customDao.save();
    }
}
