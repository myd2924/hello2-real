package com.myd.client.support;

import com.myd.client.support.pool.AbstractPool;
import com.myd.client.support.pool.PageSizeAdjustablePool;
import com.myd.client.support.pool.ParamAcceptablePool;
import com.myd.client.support.pool.Pool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/5 14:25
 * @Description:
 */
@Slf4j
public final class PoolHelper {

    static <PoolType> PoolType findPool(final Worker worker){
        final PoolType poolType = worker.getBeanFactory().getBean(findPoolClassType(worker));
        if(Objects.nonNull(poolType)){
            return poolType;
        }
        throw new RuntimeException("can't find pool from BeanFactory");
    }

    static <PoolType> Class<PoolType> findPoolClassType(Worker worker) {
        final Class clazz = AopUtils.getTargetClass(worker);
        final Type[] types = PoolHelper.getActualTypeArguments(clazz);
        if(null != types){
            for(Type type:types){
                if(type instanceof Class && Pool.class.isAssignableFrom((Class)type)){
                    return (Class<PoolType>) type;
                }
            }
        }
        throw new RuntimeException("can't find pool class type");
    }

    static Type[] getActualTypeArguments(Class clazz) {
        if(null != clazz){
            Type genericSuperclass = clazz.getGenericSuperclass();
            if(ParameterizedType.class.isAssignableFrom(genericSuperclass.getClass())){
                return ((ParameterizedType)genericSuperclass).getActualTypeArguments();
            }
        }
        return new Type[0];
    }

    static void closePool(final Pool pool){
        try{
            pool.close();
        } catch (Exception e){
            log.error("Close dataPool error",e);
        }
    }

    static int getBatchSize(final Pool pool){
        if(pool instanceof PageSizeAdjustablePool){
            return ((PageSizeAdjustablePool)pool).getPageSize();
        }
        return AbstractPool.DEAFAULT_PAGE_SIZE;
    }

    static <AcceptParameterType> AcceptParameterType getPoolParameter(final Pool pool) {
        if (pool instanceof ParamAcceptablePool) {
            return ((ParamAcceptablePool<AcceptParameterType, ?>) pool).getParameter();
        }
        return null;
    }

    @SuppressWarnings({"unchecked"})
    static <AcceptParameterType> void setPoolParameter(final Pool pool, final AcceptParameterType parameter) {
        if (null != parameter && pool instanceof ParamAcceptablePool) {
            ((ParamAcceptablePool<AcceptParameterType, ?>) pool).accept(parameter);
        }
    }
}
