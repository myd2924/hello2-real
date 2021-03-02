package com.myd.app.eventlisten.service;

import com.myd.app.eventlisten.component.EventContainer;
import com.myd.app.eventlisten.event.LoginEvent;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/22 10:16
 * @Description:
 */
@Service
public class AService {

    public void login(){
        System.out.println("我是A方法登录起始事件");
        EventContainer.submit(LoginEvent.class);
    }
}
