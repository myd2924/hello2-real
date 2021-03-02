package com.myd.app.bean.bean;

import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/1 13:51
 * @Description: TODO
 */

public class User implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean{

    @Setter
    private String name;
    @Setter
    private int age;

    public void myInit(){
        User user = new User();
        user.setName("大豆");
        user.setAge(5);
        System.out.println("myInit--指定初始化方法");
    }

    public void myDestory(){
        System.out.println("myDestory--指定销毁方法");
    }

    public void say(){
        System.out.println("我自己定义的业务方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第二个：BeanFactoryAware---设置bean工厂");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("第一个：BeanNameAware---设置beanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("最后：DisposableBean--destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第三个：InitializingBean---afterPropertiesSet");
    }
}
