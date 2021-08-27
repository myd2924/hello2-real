package com.myd.app.controller;

import com.myd.app.axon.request.CreateForm;
import com.myd.app.axon.request.ItemCreateRequest;
import com.myd.app.axon.service.ItemService;
import com.myd.app.bean.form.PersonForm;
import com.myd.app.bean.request.PersonRequest;
import com.myd.app.component.BeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 16:35
 * @Description:
 */
@RestController
@RequestMapping("/axon/event")
public class AxonController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/create")
    public Object create(@RequestBody CreateForm form){
        ItemCreateRequest request = new ItemCreateRequest();
        request.setId(UUID.randomUUID().toString());
        System.out.println(form.getDesc());
        request.setDesc(form.getDesc());
        itemService.create(request);
        return "我是a方法";
    }

    @RequestMapping("/mapper")
    public PersonRequest testBeanMapper(@RequestBody PersonForm form){
        return itemService.copyBean(form);
    }

}
