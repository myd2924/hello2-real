package com.myd.client.support.pool;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/27 17:29
 * @Description:
 */
public interface PageSizeAdjustablePool<BeanType> extends Pool<BeanType> {
    void setPageSize(final int pageSize);
    int getPageSize();
}
