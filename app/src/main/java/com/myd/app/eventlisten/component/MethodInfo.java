package com.myd.app.eventlisten.component;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/22 09:42
 * @Description:
 */
@Getter
@Setter
public class MethodInfo {
    private Object object;
    private Method method;

    public static MethodInfo ofValue(Method m,Object o){
        MethodInfo methodInfo = new MethodInfo();
        methodInfo.setMethod(m);
        methodInfo.setObject(o);

        return methodInfo;
    }

}
