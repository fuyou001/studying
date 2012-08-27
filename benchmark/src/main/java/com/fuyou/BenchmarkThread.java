package com.fuyou;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: ÉÏÎç10:36
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkThread implements Runnable {
    private BenchmarkService benchmarkService;
    private CyclicBarrier threadStartBarrier;
    private CountDownLatch threadEndLatch;
    private AtomicInteger failedCounter = null;
    private int count;

    private List<Long> everyTimes;

    public BenchmarkThread(BenchmarkContext benchmarkContext, int count) {
        super();
        this.threadStartBarrier = benchmarkContext.getThreadStartBarrier();
        this.threadEndLatch = benchmarkContext.getThreadEndLatch();
        this.failedCounter = benchmarkContext.getFailedCounter();
        this.count = count;

        everyTimes = new ArrayList<Long>(count);

        this.benchmarkService = benchmarkContext.getBenchmarkService();
    }

    public List<Long> getEveryTimes() {
        return everyTimes;
    }

    @Override
    public void run() {
        try {
            threadStartBarrier.await();
            doRun();
        } catch (Exception e) {
            System.err.println("Test exception:" + e);
        }
    }

    protected void doRun() throws Exception {
        for (int i = 0; i < count; i++) {
            long start = System.nanoTime();
            try {
                // Object result = service.test();
                benchmarkService.benchmark();
            } catch (Throwable e) {
                failedCounter.incrementAndGet();
                // throw e;
            } finally {
                long stop = System.nanoTime();
                long escapedTime = stop - start;
                everyTimes.add(escapedTime);
            }
        }
        threadEndLatch.countDown();
    }

}
