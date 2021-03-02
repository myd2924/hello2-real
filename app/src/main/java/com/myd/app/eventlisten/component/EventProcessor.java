package com.myd.app.eventlisten.component;

import com.myd.app.eventlisten.annotation.MyEvent;
import com.myd.app.eventlisten.event.IEvent;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/22 09:56
 * @Description:
 */
@Component
public class EventProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithLocalMethods(bean.getClass(), new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                MyEvent annotation = method.getAnnotation(MyEvent.class);
                if(Objects.isNull(annotation)){
                    return ;
                }

                Class<? extends MyEvent> aClass = annotation.cl();
                try {
                    if(!IEvent.class.isInstance(aClass.newInstance())){
                        FormattingTuple msg = MessageFormatter.format("{}没有实现IEvent接口",aClass);
                        throw new RuntimeException(msg.getMessage());
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                EventContainer.addEventToMap(aClass,method,bean);
            }
        });
        return true;
    }
}
