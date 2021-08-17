package com.myd.app.eventlisten.controller;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/20 17:52
 * @Description:
 */

import com.myd.app.eventlisten.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private AService aService;

    @RequestMapping("/aMethod")
    public Object aMethod(){
        aService.login();
        return "我是a方法";
    }
}
