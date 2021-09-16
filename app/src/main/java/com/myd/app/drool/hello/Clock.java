package com.myd.app.drool.hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/8/28 16:53
 * @Description: 时钟
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Clock {
    private int hour;
    private int minutes;
    private int seconds;


    public String autoPrint(){
        System.out.println("自动打印系列");
        return "逢2自动打印，哈哈";
    }
}
