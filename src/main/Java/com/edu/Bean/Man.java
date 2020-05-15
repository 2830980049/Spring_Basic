package com.edu.Bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Man implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
    private String username;
    public Man() {
        System.out.println("第一步：Man被实例化了...");
    }
    public void setUsername(String username) {
        System.out.println("第二步：设置属性");
        this.username = username;
    }
    @Override
    public void setBeanName(String name) {
        // name为配置文件里的name值
        System.out.println("第三步：设置Bean名称 "+ name);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第四步：了解工厂信息 "+applicationContext);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第六步：属性设置后执行");
    }
    public void setup(){
        System.out.println("第七步：Man被初始化了...");
    }
    public void age(){
        System.out.println("第九步：执行业务方法");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("第十步：执行Spring销毁方法");
    }
    public void removes(){
        System.out.println("第十一步：Man被销毁了...");
    }
}
