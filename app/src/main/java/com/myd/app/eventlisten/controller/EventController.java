package com.myd.app.eventlisten.controller;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/20 17:52
 * @Description:
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @RequestMapping("/aMethod")
    public Object aMethod(){

        return "我是a方法";
    }
}
