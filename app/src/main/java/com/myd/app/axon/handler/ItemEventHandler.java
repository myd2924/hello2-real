package com.myd.app.axon.handler;

import com.myd.app.axon.event.ItemCompletedEvent;
import com.myd.app.axon.event.ItemCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:16
 * @Description: 可以做一些mq操作、db操作等
 */
@Component
public class ItemEventHandler {


    @EventHandler
    public void handle(ItemCreatedEvent createdEvent){
        System.out.println("create****:"+createdEvent.getId()+"****:"+createdEvent.getDesc());

    }

    @EventHandler
    public void handle(ItemCompletedEvent completedEvent){
        System.out.println("complete****:"+completedEvent.getId());
    }

}
