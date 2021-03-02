package com.myd.client.support.pool;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/27 17:31
 * @Description:
 */
public interface ParamAcceptablePool<ParameterType,BeanType> extends Pool<BeanType>{

    void accept(ParameterType p);

    ParameterType getParameter();
}
