package com.myd.app.eventlisten.component;

import com.myd.app.eventlisten.event.IEvent;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/22 09:36
 * @Description:
 */
public class EventContainer {

    private static Map<Class<IEvent>,List<MethodInfo>> eventListMap = new HashMap();

    /**
     * 添加事件
     * @param cl
     * @param m
     * @param o
     */
    public static void addEventToMap(Class cl, Method m , Object o){
        List<MethodInfo> methodInfos = eventListMap.get(cl);
        if(CollectionUtils.isEmpty(methodInfos)){
            methodInfos = new ArrayList<>();
            eventListMap.put(cl,methodInfos);
        }
        methodInfos.add(MethodInfo.ofValue(m,o));
    }

    /**
     * 触发事件
     * @param clazz
     */
    public static void submit(Class clazz){
        List<MethodInfo> methodInfos = eventListMap.get(clazz);
        if(CollectionUtils.isEmpty(methodInfos)){
            return ;
        }

        for (MethodInfo methodInfo : methodInfos){
            Method method = methodInfo.getMethod();
            Object object = methodInfo.getObject();
            try {
                method.setAccessible(true);
                method.invoke(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


}
