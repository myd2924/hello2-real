package com.myd.client.support;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/5 13:55
 * @Description: 基本设置
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)//级联操作 set方法 返回this
@RequiredArgsConstructor(staticName = "of")
public class Setting implements Serializable {
    private static final long serialVersionUID = -5310326948942583859L;

    private final String taskName;
    private int batchSize;
    private int threadSize;
    private long restTime;
    private Object poolParameter;
    private Object extendMessage;
    private boolean sleepNightTime;
    private int nightTimeStartHour;
    private int nightTimeEndHour;
}
