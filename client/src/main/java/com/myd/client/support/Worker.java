package com.myd.client.support;

import com.myd.client.support.pool.Pool;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/4 19:44
 * @Description: 工作
 */
public abstract class Worker<BeanType,PoolType extends Pool<BeanType>> implements BeanFactoryAware {

    @Setter
    @Getter(AccessLevel.PACKAGE)
    private BeanFactory beanFactory;
    private Setting setting;
    /**private BatchTaskReport batchTaskReport;*/
    private Executor<BeanType> executor;
    private PoolType dataPool;

    @PostConstruct
    private void init(){
        setting = Setting.of(this.jobName());
        executor = new Executor<>(this);
        dataPool = PoolHelper.findPool(this);

        this.afterPropertiesSet();
    }

    protected void afterPropertiesSet() {
    }

    protected abstract String jobName();

    /**
     * 任务具体处理动作
     */
    protected abstract void work(final Collection<BeanType> beans);

    private void destory(){
        this.shutdown();
    }

    /**
     * 关闭任务
     */
    public synchronized boolean shutdown() {
        if(executor.isRunning()){

        }
        return !executor.isRunning();
    }

}
