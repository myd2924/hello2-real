package com.myd.client.support;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/4 19:46
 * @Description: 一些锁控制
 */
public class StatusManager {

    private final static transient String STATUS_RUNNING   = "running";
    private final static transient String STATUS_PENDING   = "stopping";
    private final static transient String STATUS_TERMINATE = null;

    private final String                        lockKey;
    private RedisTemplate<String, Object> redisTemplate;

    StatusManager(final BeanFactory beanFactory, final String lockKey) {
        this.lockKey = lockKey;
        this.redisTemplate = beanFactory.getBean("redisTemplate", RedisTemplate.class);
    }

    boolean tryStart(){
        final boolean result = redisTemplate.opsForValue().setIfAbsent(lockKey,STATUS_RUNNING);
        if(result){
            redisTemplate.expire(lockKey,10, TimeUnit.DAYS);
        }
        return result;
    }

    boolean isRunning(){
        return Objects.equals(STATUS_RUNNING,redisTemplate.opsForValue().get(lockKey));
    }

    boolean isTerminate(){
        return Objects.equals(STATUS_TERMINATE,redisTemplate.opsForValue().get(lockKey));
    }

    void stopping(){
        redisTemplate.opsForValue().set(lockKey,STATUS_PENDING);
    }

    void stop(){
        redisTemplate.delete(lockKey);
    }

}
