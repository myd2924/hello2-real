package com.myd.app.bean.config;

import com.myd.app.bean.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/1 14:01
 * @Description:
 */
@Configuration
@ComponentScan("com.myd.app.bean")
public class MyConfig {

    @Bean(initMethod = "myInit",destroyMethod = "myDestory")
    public User getUser(){
        User user = new User();
        return user;
    }

}
