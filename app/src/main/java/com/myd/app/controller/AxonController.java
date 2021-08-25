package com.myd.app.controller;

import com.myd.app.axon.request.CreateForm;
import com.myd.app.axon.request.ItemCreateRequest;
import com.myd.app.axon.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 16:35
 * @Description: TODO
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

}
