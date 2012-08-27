package com.fuyou;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: ����10:31
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkContext {
    // ÿ���̵߳Ĳ��Դ���
    private int everyThreadCount;
    private CyclicBarrier threadStartBarrier;// �߳�ͬ����ʼ����
    private CountDownLatch threadEndLatch;// �߳������������
    private AtomicInteger failedCounter; // ʧ�ܴ���ͳ��

    private BenchmarkService benchmarkService;

    public int getEveryThreadCount() {
        return everyThreadCount;
    }

    public void setEveryThreadCount(int everyThreadCount) {
        this.everyThreadCount = everyThreadCount;
    }

    public CyclicBarrier getThreadStartBarrier() {
        return threadStartBarrier;
    }

    public void setThreadStartBarrier(CyclicBarrier threadStartBarrier) {
        this.threadStartBarrier = threadStartBarrier;
    }

    public CountDownLatch getThreadEndLatch() {
        return threadEndLatch;
    }

    public void setThreadEndLatch(CountDownLatch threadEndLatch) {
        this.threadEndLatch = threadEndLatch;
    }

    public AtomicInteger getFailedCounter() {
        return failedCounter;
    }

    public void setFailedCounter(AtomicInteger failedCounter) {
        this.failedCounter = failedCounter;
    }

    public BenchmarkService getBenchmarkService() {
        return benchmarkService;
    }

    public void setBenchmarkService(BenchmarkService benchmarkService) {
        this.benchmarkService = benchmarkService;
    }

}
