package com.myd.app.eventlisten3.event;

import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/10 19:11
 * @Description:
 */
public interface IEvent {
    /**
     * 获取事件消息
     */
    String gotMessage();

    /**
     * 发生时间
     */
    Date gotWhen();

    /**
     * 事件来源
     */
    Object gotSource();

    /**
     * 回调方法
     */
    void callback();
}
