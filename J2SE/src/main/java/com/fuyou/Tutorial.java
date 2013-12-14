package com.fuyou;

import com.google.caliper.Benchmark;
import com.google.caliper.Param;

/**
 * User: yubao.fyb
 * Date: 13-12-14
 * Time: 20:37
 */
public class Tutorial {
    @Param({"10", "100"}) int reps;

    @Benchmark
    void timeNanoTime(int reps) {
        for (int i = 0; i < reps; i++) {
            System.nanoTime();
        }
    }
}
