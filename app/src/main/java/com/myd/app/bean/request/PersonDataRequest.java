package com.myd.app.bean.request;

import com.myd.app.bean.bean.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/27 09:36
 * @Description:
 */
@Data
@NoArgsConstructor
public class PersonDataRequest {
    private String requestName;
    private String requestSex;
    private Address address;
    private Integer age;
}