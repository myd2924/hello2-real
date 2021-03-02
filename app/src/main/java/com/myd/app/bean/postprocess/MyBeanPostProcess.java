package com.myd.app.bean.postprocess;

import com.myd.app.bean.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/1 14:24
 * @Description:
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof User){
            ((User) bean).setBeanName("myGirl");
            ((User) bean).setName("马晨曦");
            System.out.println("BeforeInitialization 我今天5周岁了");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof User){
            System.out.println("AfterInitialization --我有个妹妹今年三岁半了");
        }
        return bean;
    }
}
