package com.fuyou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkEngine {

    /**
     * @param warmUpTime       ms
     * @param benchmarkService
     */
    protected void warmUp(long warmUpTime, BenchmarkService benchmarkService) {
        long start = System.nanoTime();
        long escapedTime = warmUpTime;
        while (escapedTime < warmUpTime) {
            try {
                benchmarkService.benchmark();
                // benchmarkWorker.doRun();
            } catch (Exception e) {
                System.err.println("BenchmarkService exception:" + e);
            }
            long now = System.nanoTime();
            escapedTime = TimeUnit.MICROSECONDS.convert(now - start, TimeUnit.NANOSECONDS);
        }
    }

    public BenchmarkResult benchmark(int concurrencyLevel, int totalRequests,
                                long warmUpTime, BenchmarkService benchmarkService) {

        if (null == benchmarkService) {
            throw new IllegalArgumentException("BenchmarkService is null....");
        }
        warmUp(warmUpTime, benchmarkService);
        // 每个线程的测试次数
        int everyThreadCount = totalRequests / concurrencyLevel;
        CyclicBarrier threadStartBarrier = new CyclicBarrier(concurrencyLevel);// 线程同步开始任务
        CountDownLatch threadEndLatch = new CountDownLatch(concurrencyLevel);// 线程任务结束计数
        AtomicInteger failedCounter = new AtomicInteger(); // 成功次数统计

        BenchmarkContext benchmarkContext = new BenchmarkContext();
        benchmarkContext.setBenchmarkService(benchmarkService);
        benchmarkContext.setEveryThreadCount(everyThreadCount);
        benchmarkContext.setThreadStartBarrier(threadStartBarrier);
        benchmarkContext.setThreadEndLatch(threadEndLatch);
        benchmarkContext.setFailedCounter(failedCounter);

        ExecutorService executorService = Executors
                .newFixedThreadPool(concurrencyLevel);

        List<BenchmarkThread> benchmarkThreads = new ArrayList<BenchmarkThread>(
                concurrencyLevel);
        for (int i = 0; i < concurrencyLevel; i++) {
            BenchmarkThread benchmarkThread = new BenchmarkThread(benchmarkContext,
                    everyThreadCount);
            benchmarkThreads.add(benchmarkThread);
        }

        for (BenchmarkThread benchmarkThread : benchmarkThreads) {
            executorService.submit(benchmarkThread);
        }


//        for (int i = 0; i < concurrencyLevel; i++) {
//            BenchmarkThread worker = workers.get(i);
//            executorService.submit(worker);
//        }


        try {
            threadEndLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        executorService.shutdown();

        // long limit = end - start;s
        // long startLimit = testContext.getStartTime() - start;
        int realTotalRequests = everyThreadCount * concurrencyLevel;
        int failedRequests = failedCounter.get();
        BenchmarkResult result = new BenchmarkResult();

        SortResult sortResult = getSortedTimes(benchmarkThreads);
        List<Long> allTimes = sortResult.allTimes;

        result.setAllTimes(allTimes);
        List<Long> threadTimes = sortResult.threadtimes;
        //每个线程最长作为总的基准测试时间
        long benchmarkEscapedTime = threadTimes.get(threadTimes.size() - 1);

        result.setEscapedTime(benchmarkEscapedTime);
        result.setFailedRequests(failedRequests);
        result.setTotalRequests(realTotalRequests);
        result.setConcurrencyLevel(concurrencyLevel);
        result.setWorkers(benchmarkThreads);
        return result;

    }

    protected SortResult getSortedTimes(List<BenchmarkThread> workers) {
        //每次Benchmark 的时间
        List<Long> allTimes = new ArrayList<Long>();
        //每个线程的的时间
        List<Long> threadTimes = new ArrayList<Long>();
        for (BenchmarkThread worker : workers) {
            List<Long> everyWorkerTimes = worker.getEveryTimes();
            for (Long time : everyWorkerTimes) {
                allTimes.add(time);
            }
            long workerTotalTime = BenchmarkUtils.getTotal(everyWorkerTimes);
            threadTimes.add(workerTotalTime);
        }

        Collections.sort(allTimes);
        Collections.sort(threadTimes);
        SortResult result = new SortResult();
        result.allTimes = allTimes;
        result.threadtimes = threadTimes;
        return result;
    }


    class SortResult {
        List<Long> allTimes;
        List<Long> threadtimes;
    }

}
