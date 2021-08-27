package com.myd.app.axon.service;

import com.myd.app.axon.command.CompleteItemCommand;
import com.myd.app.axon.command.CreateItemCommand;
import com.myd.app.axon.command.ItemCommandCallback;
import com.myd.app.axon.request.ItemCompleteRequest;
import com.myd.app.axon.request.ItemCreateRequest;
import com.myd.app.bean.form.PersonForm;
import com.myd.app.bean.request.PersonRequest;
import com.myd.app.component.BeanMapper;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:22
 * @Description: 接口外部其请求 request转command
 */
@Service
public class ItemService {

    @Autowired
    private CommandBus commandBus;

    public Object create(ItemCreateRequest request){
        CreateItemCommand command = new CreateItemCommand();
        BeanUtils.copyProperties(request, command);
        ItemCommandCallback callback = new ItemCommandCallback();
        commandBus.dispatch(new GenericCommandMessage(command),callback);
        return callback.getResult();
    }

    public Object complete(ItemCompleteRequest request){
        CompleteItemCommand completeItemCommand = new CompleteItemCommand();
        BeanUtils.copyProperties(request, completeItemCommand);
        ItemCommandCallback callback = new ItemCommandCallback();
        commandBus.dispatch(new GenericCommandMessage(completeItemCommand),callback);
        return callback.getResult();
    }

    public PersonRequest copyBean(PersonForm form){
        final PersonRequest personRequest = BeanMapper.map(form, PersonRequest.class);
        return personRequest;
    }
}
