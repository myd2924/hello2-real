package com.myd.client.support.pool;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;


/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/27 17:58
 * @Description:
 */
public abstract class AbstractPool<BeanType,IdType> implements PageSizeAdjustablePool<BeanType>{
    public final static transient int DEAFAULT_PAGE_SIZE = 100;
    private volatile boolean hasNext = true;
    private volatile IdType lastMaxId;
    private volatile int pageSize = DEAFAULT_PAGE_SIZE;

    @Override
    public boolean hasNext(){
        return hasNext;
    }

    @Override
    public synchronized Collection<BeanType> next() {
        if(!hasNext()){
            return Collections.emptyList();
        }
        if(Objects.isNull(lastMaxId)){
            lastMaxId = firstId();
        }
        final Collection<BeanType> result = load(lastMaxId,getPageSize());
        
        if(CollectionUtils.isNotEmpty(result)){
            lastMaxId = lastMaxId(result.stream().reduce((first,second)->second).orElse(null));
        } else {
            setHasNext(false);
        }
        return CollectionUtils.emptyIfNull(result);
    }

    protected abstract IdType lastMaxId(BeanType beanType);

    protected void setHasNext(boolean b) {
        hasNext = b;
    }

    protected abstract Collection<BeanType> load(IdType lastMaxId, int pageSize);

    protected abstract IdType firstId();

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public void close(){
        this.reset();
    }

    private void reset(){
        lastMaxId = firstId();
        setHasNext(true);
    }
}
