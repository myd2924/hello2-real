package com.myd.app.eventlisten3.eventlisten;

import com.myd.app.eventlisten3.event.IEvent;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/10 19:33
 * @Description: TODO
 */
public class MyEventListen implements IEventListen {


    @Override
    public void eventHandler(IEvent iEvent) {
        System.out.println("业务处理 源："+iEvent.gotSource()+" --消息："+ iEvent.gotMessage()+" --时间："+iEvent.gotWhen());
        iEvent.callback();
    }
}
