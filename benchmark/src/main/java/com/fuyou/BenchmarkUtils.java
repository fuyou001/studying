package com.fuyou;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: ÉÏÎç10:51
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkUtils {
    public static long getTotal(List<Long> times) {
        long total = 0;
        for (Long time : times) {
            total = total + time;
        }
        return total;
    }

    public static float getAverage(List<Long> allTimes) {
        long total = getTotal(allTimes);
        return total / (float) allTimes.size();
    }

    public static float toMs(long nm) {
        return nm / 1000000f;
    }

    public static float toMs(float nm) {
        return nm / 1000000f;
    }
}
