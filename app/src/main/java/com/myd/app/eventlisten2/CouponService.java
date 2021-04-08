package com.myd.app.eventlisten2;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/8 11:11
 * @Description: 监听事件的另一种写法  优惠券
 */
@Service
public class CouponService {

    @EventListener
    @Async
    public void addCoupon(MyEvent myEvent){
        System.out.println("给用户:"+myEvent.getName()+" 发放优惠券");
    }
}
