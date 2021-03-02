package com.myd.app.other.controller;

import com.myd.app.other.service.ResourceServcie;
import com.myd.client.family.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/26 15:32
 * @Description:
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceServcie resourceServcie;

    @GetMapping("/getFamily")
    public Family getFamily(String name){
        return resourceServcie.getFamilyByName(name,"");
    }
}
