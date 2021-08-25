package com.myd.app.axon.handler;

import com.myd.app.axon.command.CreateItemCommand;
import com.myd.app.axon.event.ItemCompletedEvent;
import com.myd.app.axon.event.ItemCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.GenericEventMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 10:53
 * @Description: TODO
 */
@Service
public class ItemCommandHandler {

    /**
     * Axon框架的事件总线
     */
    @Autowired
    private EventBus eventBus;

    @CommandHandler
    @Transactional(rollbackFor = Exception.class)
    public Object create(CreateItemCommand  createItemCommand){
        ItemCreatedEvent event = new ItemCreatedEvent();
        event.setId(createItemCommand.getId());
        event.setDesc(createItemCommand.getDesc());
        EventMessage<ItemCompletedEvent> message = new GenericEventMessage(event);
        //db操作
        System.out.println("db操作。。。事件总线发布消息");
        eventBus.publish(message);
        return 1;
    }

}
