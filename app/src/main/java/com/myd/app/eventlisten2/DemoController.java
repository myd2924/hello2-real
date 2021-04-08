package com.myd.app.eventlisten2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/8 11:16
 * @Description: 监听测试
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/regaiter")
    public String register(String name){
        userService.register(name);
        return "success";
    }

}
