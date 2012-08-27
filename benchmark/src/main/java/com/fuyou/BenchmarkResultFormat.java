package com.fuyou;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: ÉÏÎç11:10
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkResultFormat {
    public void format(BenchmarkResult benchmarkResult, String serviceName, Writer writer) {
        long benchmarkEscapedTime = benchmarkResult.getEscapedTime();
        int totalRequests = benchmarkResult.getTotalRequests();
        int concurrencyLevel = benchmarkResult.getConcurrencyLevel();

        float takes = TimeUnit.MILLISECONDS.convert(benchmarkEscapedTime,TimeUnit.NANOSECONDS);//toMs(benchmarkEscapedTime);

        float tps = (totalRequests * 1000) / takes;


        List<Long> allTimes = benchmarkResult.getAllTimes();

        float average = toMs(getAverage(allTimes));

        int count_50 = totalRequests / 2;
        int count_66 = totalRequests * 66 / 100;
        int count_75 = totalRequests * 75 / 100;
        int count_80 = totalRequests * 80 / 100;
        int count_90 = totalRequests * 90 / 100;
        int count_95 = totalRequests * 95 / 100;
        int count_98 = totalRequests * 98 / 100;
        int count_99 = totalRequests * 99 / 100;

        long longestRequest = allTimes.get(allTimes.size() - 1);
        long shortestRequest = allTimes.get(0);

        StringBuilder view = new StringBuilder();

        view.append(" Service Name:\t").append(serviceName);
        view.append("\r\n Concurrency Level:\t").append(concurrencyLevel);
        view.append("\r\n Time taken for Benchmark:\t").append(takes).append(" ms");
        view.append("\r\n Complete Requests:\t").append(totalRequests);
        view.append("\r\n Failed Requests:\t").append(
                benchmarkResult.getFailedRequests());
        view.append("\r\n Requests per second:\t").append(tps);
        view.append("\r\n Time per request:\t").append(average).append(" ms");
        view.append("\r\n Shortest request:\t").append(toMs(shortestRequest))
                .append(" ms");

        StringBuilder certainTimeView = view;
        certainTimeView
                .append("\r\n Percentage of the requests served within a certain time (ms)");
        certainTimeView.append("\r\n  50%\t").append(
                toMs(allTimes.get(count_50)));
        certainTimeView.append("\r\n  66%\t").append(
                toMs(allTimes.get(count_66)));
        certainTimeView.append("\r\n  75%\t").append(
                toMs(allTimes.get(count_75)));
        certainTimeView.append("\r\n  80%\t").append(
                toMs(allTimes.get(count_80)));
        certainTimeView.append("\r\n  90%\t").append(
                toMs(allTimes.get(count_90)));
        certainTimeView.append("\r\n  95%\t").append(
                toMs(allTimes.get(count_95)));
        certainTimeView.append("\r\n  98%\t").append(
                toMs(allTimes.get(count_98)));
        certainTimeView.append("\r\n  99%\t").append(
                toMs(allTimes.get(count_99)));
        certainTimeView.append("\r\n 100%\t").append(toMs(longestRequest))
                .append(" (longest request)");

        try {
            writer.write(view.toString());
        } catch (IOException e) {
            System.err.println("IOException:" + e);
        }

    }

    public String format(BenchmarkResult result, String serviceName) {
        StringWriter sw = new StringWriter();
        format(result, serviceName, sw);
        return sw.toString();
    }

    protected float getAverage(List<Long> allTimes) {
        return BenchmarkUtils.getAverage(allTimes);
    }

    protected float toMs(long nm) {
        return BenchmarkUtils.toMs(nm);
    }

    protected float toMs(float nm) {
        return BenchmarkUtils.toMs(nm);
    }
}
