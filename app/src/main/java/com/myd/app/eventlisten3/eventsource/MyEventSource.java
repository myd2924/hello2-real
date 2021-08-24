package com.myd.app.eventlisten3.eventsource;

import com.myd.app.eventlisten3.event.IEvent;
import com.myd.app.eventlisten3.event.MyEvent;
import com.myd.app.eventlisten3.eventlisten.IEventListen;
import com.myd.app.eventlisten3.eventlisten.MyEventListen;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/10 19:39
 * @Description: TODO
 */
public class MyEventSource implements IEventSource {

    private List<IEventListen> listens = new ArrayList<>();

    private IEvent iEvent;

    @Override
    public void addListen(IEventListen iEventListen) {
        listens.add(iEventListen);
    }

    @Override
    public void notifyListen() {
        for (IEventListen listen:listens) {
            listen.eventHandler(iEvent);
        }
    }

    public void publish(IEvent iEvent){
        this.iEvent = iEvent;
        notifyListen();
    }

    @Test
    public void test(){
        MyEventSource myEventSource = new MyEventSource();
        myEventSource.addListen(new MyEventListen());
        MyEvent myEvent = new MyEvent();
        myEvent.setMessage("大马曦");
        myEvent.setSource(myEventSource);
        myEvent.setWhen(new Date());
        myEventSource.publish(myEvent);

    }
}
