package compress;

import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * User: yubao.fyb
 * Date: 14-6-4
 * Time: 14:24
 * ²Î¿¼
 * http://netty.io/wiki/microbenchmarks.html
 */
@Warmup(iterations = AbstractMicrobenchmark.DEFAULT_WARMUP_ITERATIONS)
@Measurement(iterations = AbstractMicrobenchmark.DEFAULT_MEASURE_ITERATIONS)
@Fork(AbstractMicrobenchmark.DEFAULT_FORKS)
@State(Scope.Thread)
public class AbstractMicrobenchmark {
    protected static final int DEFAULT_WARMUP_ITERATIONS = 10;
    protected static final int DEFAULT_MEASURE_ITERATIONS = 10;
    protected static final int DEFAULT_FORKS = 2;

    protected static final String[] JVM_ARGS = {
            "-server", "-dsa", "-da", "-ea:io.netty...", "-Xms768m", "-Xmx768m",
            "-XX:MaxDirectMemorySize=768m", "-XX:+AggressiveOpts", "-XX:+UseBiasedLocking",
            "-XX:+UseFastAccessorMethods", "-XX:+UseStringCache", "-XX:+OptimizeStringConcat",
            "-XX:+HeapDumpOnOutOfMemoryError", "-Dio.netty.noResourceLeakDetection"
    };

    @Test
    public void run() throws Exception {
        String className = getClass().getSimpleName();

        ChainedOptionsBuilder runnerOptions = new OptionsBuilder()
                .include(".*" + className + ".*")
                .jvmArgs(JVM_ARGS);

        if (getWarmupIterations() > 0) {
            runnerOptions.warmupIterations(getWarmupIterations());
        }

        if (getMeasureIterations() > 0) {
            runnerOptions.measurementIterations(getMeasureIterations());
        }

        if (getForks() > 0) {
            runnerOptions.forks(getForks());
        }

//        if (getReportDir() != null) {
//            String filePath = getReportDir() + className + ".json";
//            File file = new File(filePath);
//            if (file.exists()) {
//                file.delete();
//            } else {
//                file.getParentFile().mkdirs();
//                file.createNewFile();
//            }
//
//            runnerOptions.resultFormat(ResultFormatType.JSON);
//            runnerOptions.result(filePath);
//        }

        new Runner(runnerOptions.build()).run();
    }

    protected int getWarmupIterations() {
        return SystemPropertyUtil.getInt("warmupIterations", -1);
    }

    protected int getMeasureIterations() {
        return SystemPropertyUtil.getInt("measureIterations", -1);
    }

    protected int getForks() {
        return SystemPropertyUtil.getInt("forks", -1);
    }

    protected String getReportDir() {
        return SystemPropertyUtil.get("perfReportDir", "/Users/fuyou/study/java/studying/benchmark/src/test/java");
    }
}
