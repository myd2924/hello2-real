package com.myd.client.family;

import lombok.Data;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/26 10:06
 * @Description:
 */
@Data
public class Family {
    private String id;
    private String pids;
    private String name;
    private FamilyType type;
}
