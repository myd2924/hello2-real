package com.myd.client.support.pool;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/27 17:22
 * @Description: 数据提供
 */
public interface Pool<BeanType> extends Iterator<Collection<BeanType>>,AutoCloseable{
}
