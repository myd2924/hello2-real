package com.myd.app.eventlisten3.eventsource;

import com.myd.app.eventlisten3.eventlisten.IEventListen;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/10 19:13
 * @Description:
 */
public interface IEventSource {

    /**
     * 添加监听
     * @param iEventListen
     */
    void addListen(IEventListen iEventListen);

    /**
     * 通知监听处理
     */
    void notifyListen();


}
