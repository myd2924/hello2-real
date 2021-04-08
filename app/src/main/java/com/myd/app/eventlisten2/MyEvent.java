package com.myd.app.eventlisten2;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/8 11:00
 * @Description: 我的事件定义
 *
 * 定义事件 发布事件 监听事件
 */
public class MyEvent extends ApplicationEvent {

    @Getter
    private String name;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source,String name){
        super(source);
        this.name = name;
    }


}
