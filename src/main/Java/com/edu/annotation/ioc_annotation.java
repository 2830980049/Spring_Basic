package com.edu.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Spring Bean管理注解方式
 * 传统需要在XML中配置<bean id="" class=""></bean>
 */
@Service("WomanService")
public class ioc_annotation {
    private Integer age;
    @Resource(name = "WomanDao")
    private WomanDao womanDao;
    public Integer getAge() {
        return age;
    }
    @Value("20")
    public void setAge(Integer age) {
        this.age = age;
    }
    public String Woman(String name){
        return name + " " + age;
    }
    public void save(){
        System.out.println("Service中保存用户...");
        womanDao.save();
    }
}
