package com.myd.app.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 10:37
 * @Description: 创建命令
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemCommand {

    @TargetAggregateIdentifier
    private String id;

    private String desc;



}
