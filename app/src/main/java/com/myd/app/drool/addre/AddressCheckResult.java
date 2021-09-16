package com.myd.app.drool.addre;

import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/28 17:53
 * @Description: TODO
 */
@Setter
@Getter
public class AddressCheckResult {

    /**
     * true:通过校验；false：未通过校验
     */
    private boolean postCodeResult = false;
}
