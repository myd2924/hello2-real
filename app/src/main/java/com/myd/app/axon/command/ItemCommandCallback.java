package com.myd.app.axon.command;

import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:36
 * @Description:
 */
@Getter
@Setter
public class ItemCommandCallback implements CommandCallback{

    private Object result;

    private Throwable throwable;

    @Override
    public void onSuccess(CommandMessage commandMessage, Object o) {
        this.result = o;
    }

    @Override
    public void onFailure(CommandMessage commandMessage, Throwable throwable) {
        this.throwable = throwable;
    }
}
