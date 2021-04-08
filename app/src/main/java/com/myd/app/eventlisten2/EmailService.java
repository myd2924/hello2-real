package com.myd.app.eventlisten2;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/8 11:07
 * @Description: 监听事件
 */
@Service
public class EmailService implements ApplicationListener<MyEvent> {// 1-监听的事件
    @Override
    @Async  //2-异步操作
    public void onApplicationEvent(MyEvent myEvent) {
        //3-对监听的事件自行处理

        System.out.println("给用户:"+myEvent.getName()+" 发邮件通知");
    }
}
