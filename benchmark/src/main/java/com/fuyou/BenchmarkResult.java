package com.fuyou;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: ����10:36
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkResult {

    private int concurrencyLevel;// �����߳���
    private int totalRequests;// ���������

    private long escapedTime;// �ܺ�ʱ
    private int failedRequests;// ʧ���������

    private List<Long> allTimes;// ÿ������ĺ�ʱ

    private List<BenchmarkThread> workers;

    public long getEscapedTime() {
        return escapedTime;
    }

    public int getConcurrencyLevel() {
        return concurrencyLevel;
    }

    public void setConcurrencyLevel(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(int totalRequests) {
        this.totalRequests = totalRequests;
    }

    public void setEscapedTime(long escapedTime) {
        this.escapedTime = escapedTime;
    }

    public int getFailedRequests() {
        return failedRequests;
    }

    public void setFailedRequests(int failedRequests) {
        this.failedRequests = failedRequests;
    }

    public List<Long> getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(List<Long> allTimes) {
        this.allTimes = allTimes;
    }

    public List<BenchmarkThread> getWorkers() {
        return workers;
    }

    public void setWorkers(List<BenchmarkThread> workers) {
        this.workers = workers;
    }
}
