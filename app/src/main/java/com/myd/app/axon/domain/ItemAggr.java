package com.myd.app.axon.domain;

import com.myd.app.axon.event.ItemCreatedEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 10:46
 * @Description: 业务聚合
 */
@Getter
@Setter
@NoArgsConstructor
public class ItemAggr{

    @AggregateIdentifier
    private String id;

    private String desc;

    @EventHandler
    public void on(ItemCreatedEvent event){
        System.out.println("聚合跟");
        this.id = event.getId();
    }

}
