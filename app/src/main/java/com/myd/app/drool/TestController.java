package com.myd.app.drool;

import com.myd.app.drool.addre.Address;
import com.myd.app.drool.addre.AddressCheckResult;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/28 17:50
 * @Description: https://blog.csdn.net/wo541075754/article/details/75314694
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private KieSession kieSession;


    @RequestMapping("/address")
    public void test(){
        Address address = new Address();
        address.setPostcode("99425");

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        if(result.isPostCodeResult()){
            System.out.println("规则校验通过");
        }

    }
}
