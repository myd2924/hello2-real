package com.myd.app.axon.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:31
 * @Description: TODO
 */
@Getter
@Setter
@NoArgsConstructor
public class ItemCreateRequest {
    private String id;
    private String desc;
}
