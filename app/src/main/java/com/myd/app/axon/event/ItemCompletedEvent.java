package com.myd.app.axon.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/25 15:20
 * @Description: TODO
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemCompletedEvent {
    private String id;
}
