package com.myd.app.eventlisten.service;

import com.myd.app.eventlisten.annotation.MyEvent;
import com.myd.app.eventlisten.event.LoginEvent;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/22 10:34
 * @Description:
 */
@Service
public class CService {

    @MyEvent(cl = LoginEvent.class)
    public void afterLogin(){
        System.out.println("我是C服务，也监听到登录事件，执行我的C" +
                "方法了");
    }
}
