package com.myd.app.eventlisten3.event;

import lombok.Setter;

import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/10 19:27
 * @Description: TODO
 */
@Setter
public class MyEvent implements IEvent {

    private String message;

    private Date when;

    private Object source;

    @Override
    public String gotMessage() {
        return message;
    }

    @Override
    public Date gotWhen() {
        return when;
    }

    @Override
    public Object gotSource() {
        return source;
    }

    @Override
    public void callback() {
        System.out.println("我是回调方法："+message);
    }
}
