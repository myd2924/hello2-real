package com.myd.client.support;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/27 17:21
 * @Description: 任务执行器
 */
@Slf4j
public class Executor<BeanType> {
    private final static int DEAFAULT_THREAD_SIZE = 10;
    private final static int MAX_THREAD_SIZE = 100;
    private final static long DEAFAULT_REST_TIME = 0L;

    private volatile int threadSize = DEAFAULT_THREAD_SIZE;
    private volatile long restTime = DEAFAULT_REST_TIME;
    private final Object restTimeLock = new Object();

    private final ThreadLocal<ExecutorService> mainExecutor = new ThreadLocal<>();
    /**
     * 子线程可以继承父线程的变量
     */
    private final ThreadLocal<ExecutorService> workExecutor = new InheritableThreadLocal<>();
    private final LongAdder totalThreadCounter = new LongAdder();
    private final LongAdder currentThreadCounter = new LongAdder();
    private final ReentrantLock awaitLock = new ReentrantLock();
    private final Condition submitCondition = awaitLock.newCondition();
    private final Condition finishCondition = awaitLock.newCondition();

    private final Worker<BeanType,?> worker;
    private final StatusManager statusManager;
    @Getter(AccessLevel.PACKAGE)
    private final Pause pause = new Pause();

    Executor(Worker<BeanType,?> worker){
        this.worker = worker;
        this.statusManager = new StatusManager(worker.getBeanFactory(),"LOCK_WORKER:"+worker.getClass().getName());
    }

    void setThreadSize(int threadSize){
        this.threadSize = threadSize <=0 ? DEAFAULT_THREAD_SIZE : (threadSize>MAX_THREAD_SIZE ? MAX_THREAD_SIZE : threadSize);
    }

    int getThreadSize(){
        return threadSize;
    }
    long getRestTime() {
        return this.restTime <= 0 ? DEAFAULT_REST_TIME : this.restTime;
    }

    void setRestTime(long restTime) {
        this.restTime = restTime <= 0 ? DEAFAULT_REST_TIME : restTime;
    }

    boolean tryStart() {
        return statusManager.tryStart();
    }

    void start() {
       // this.getMainExecutor().submit((Runnable) worker::work);
    }
    boolean isRunning() {
        return statusManager.isRunning();
    }

    private ExecutorService getMainExecutor() {
        if (null == mainExecutor.get()) {
            synchronized (this) {
                if (null == mainExecutor.get()) {
                    mainExecutor.set(Executors.newSingleThreadExecutor(r -> new Thread(r, "MainThread-" + worker.jobName())));
                }
            }
        }
        return mainExecutor.get();
    }

    private void startWork(final Collection<BeanType> beans){
        try{
            worker.work(beans);
        } finally {
            final long restTime = this.getRestTime();
            if(restTime > 0){
                synchronized (restTimeLock){
                    try {
                        restTimeLock.wait();
                    } catch (InterruptedException ignore) {
                       Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    void stop(){
        if(statusManager.isRunning()){
            statusManager.stop();
        }
    }

    /**
     * 终止线程池
     */
    void terminated(){
        try{
            this.shutdownExecutor(this.getMainExecutor(),3);
            this.shutdownExecutor(this.getWorkExxcutor(),30);
        } finally {
            workExecutor.set(null);
            mainExecutor.set(null);
            totalThreadCounter.reset();
            currentThreadCounter.reset();
            statusManager.stop();
        }
    }

    private ExecutorService getWorkExxcutor(){
        if(null == workExecutor.get()){
            synchronized (this){
                if(null == workExecutor.get()){
                    workExecutor.set(new ThreadPoolExecutor(0,MAX_THREAD_SIZE,3L, TimeUnit.SECONDS,new SynchronousQueue<>(),r->{
                        totalThreadCounter.increment();
                        return new Thread(r," WorkerThtead-"+worker.jobName()+"-"+totalThreadCounter.intValue());
                    }));
                }
            }
        }
        return workExecutor.get();
    }

    private void shutdownExecutor(final ExecutorService executorService ,final int waitSeconds){
        if(Objects.nonNull(executorService) && !executorService.isShutdown() && !executorService.isTerminated()){
            executorService.shutdown();
            try{
                if(!executorService.awaitTermination(waitSeconds,TimeUnit.SECONDS)){
                    executorService.shutdownNow();
                    if(!executorService.awaitTermination(120,TimeUnit.SECONDS)){
                        log.error("executorService did not terminate");
                    }
                }
            } catch (InterruptedException e){
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            executorService.shutdownNow();
        }
    }


}
