package com.myd.app.bean;

import com.myd.app.bean.bean.User;
import com.myd.app.bean.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/1 14:11
 * @Description:
 */
@SpringBootTest
public class UserTest {

    @Test
    public void userTest1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = applicationContext.getBean(User.class);
        user.say();
        applicationContext.close();

    }
}
