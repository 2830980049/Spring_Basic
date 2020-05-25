import com.edu.Bean.*;
import com.edu.Bean.DI.CollectionBean;
import com.edu.Bean.DI.Persons;
import com.edu.Bean.DI.SpEL_Product;
import com.edu.Bean.DI.User;
import com.edu.XML_Add_Annotation.ProductService;
import com.edu.annotation.ioc_annotation;
import com.edu.ioc.UserService;
import com.edu.ioc.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Spring_Bean {
    //传统方式开发
    @Test
    public void UserService(){
        UserService userService = new UserServiceImpl();
        userService.Hello();

        UserServiceImpl userService1 = new UserServiceImpl();
        userService1.setName("苏苏");
        userService1.Hello();
    }

    //Spring 工厂 + 反射 + 配置文件
    @Test
    public void Spring_UserService(){
        //创建Spring工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //通过工厂获得类
        UserService userService = (UserService)applicationContext.getBean("userservice");
        userService.Hello();
    }

    //读取磁盘系统中的配置文件
    @Test
    public void System_file(){
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("c:\\beans.xml");
        UserService userService = (UserService)applicationContext.getBean("userservice");
        userService.Hello();
    }

    //Bean实例化三种方式
    @Test
    public void Bean_Ways(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //无参构造方法    通过工厂获得类实例
        Bean_1 bean_1 = (Bean_1)applicationContext.getBean("bean_1");

        //静态工厂实例化  通过工厂获得类实例
        Bean_2 bean_2 = (Bean_2)applicationContext.getBean("bean_2");

        //实例工厂实例化  通过工厂获得类实例
        Bean_3 bean_3 = (Bean_3)applicationContext.getBean("bean_3");
    }

    // Bean执行顺序
    @Test
    public void Man(){
        //创建工厂
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Man man = (Man)applicationContext.getBean("man");
        man.age();
        applicationContext.close();
    }

    // 类增强
    @Test
    public void UserDao(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDao)applicationContext.getBean("userDao");
        userDao.findAll();
        userDao.save();
        userDao.update();
    }

    //DI    构造函数注入
    @Test
    public void di(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
    }

    //DI    属性setter方法注入
    @Test
    public void di2(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Persons persons = (Persons)applicationContext.getBean("persons");
        System.out.println(persons);
    }

    //DI    P名称空间属性注入
    @Test
    public void di3(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Persons persons = (Persons)applicationContext.getBean("person");
        System.out.println(persons);
    }

    //DI    SlEl属性注入
    @Test
    public void di4(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SpEL_Product spELProduct = (SpEL_Product)applicationContext.getBean("spELProduct");
        System.out.println(spELProduct);
    }

    //DI    集合属性注入
    @Test
    public void di5(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CollectionBean CollectionBean = (CollectionBean)applicationContext.getBean("collection");
        System.out.println(CollectionBean);
    }

//  注解
    @Test
    public void annotation(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_annotation.xml");
        ioc_annotation woman = (ioc_annotation)applicationContext.getBean("WomanService");
        System.out.println(woman.Woman("苏苏"));
        woman.save();
    }

    //  传统XML配置和注解配置混合使用
    @Test
    public void complex(){
        //创建工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans_annotation.xml");
        ProductService productService = (ProductService)applicationContext.getBean("productService");
        productService.save();
    }




}
