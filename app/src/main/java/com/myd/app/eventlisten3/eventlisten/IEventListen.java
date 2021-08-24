package com.myd.app.eventlisten3.eventlisten;

import com.myd.app.eventlisten3.event.IEvent;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/10 19:14
 * @Description:
 */
public interface IEventListen {
    void eventHandler(IEvent iEvent);
}
