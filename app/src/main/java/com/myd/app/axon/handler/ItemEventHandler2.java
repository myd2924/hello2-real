package com.myd.app.axon.handler;

import com.myd.app.axon.event.ItemCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:16
 * @Description: 同一个方法里不行  不同的方法可以
 */
@Component
public class ItemEventHandler2 {

    @EventHandler
    public void handle(ItemCreatedEvent createdEvent){
        System.out.println("create****2:"+createdEvent.getId()+"****2:"+createdEvent.getDesc());

    }


}
