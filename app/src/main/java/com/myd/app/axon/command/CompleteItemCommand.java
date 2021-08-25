package com.myd.app.axon.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:33
 * @Description: TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CompleteItemCommand {

    @TargetAggregateIdentifier
    private String id;

}
