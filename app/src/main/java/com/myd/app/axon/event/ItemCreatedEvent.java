package com.myd.app.axon.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 11:02
 * @Description: TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCreatedEvent {

    private String id;
    private String desc;

}
