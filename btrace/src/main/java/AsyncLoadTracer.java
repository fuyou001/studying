import static com.sun.btrace.BTraceUtils.addToAggregation;
import static com.sun.btrace.BTraceUtils.field;
import static com.sun.btrace.BTraceUtils.get;
import static com.sun.btrace.BTraceUtils.newAggregation;
import static com.sun.btrace.BTraceUtils.newAggregationKey;
import static com.sun.btrace.BTraceUtils.printAggregation;
import static com.sun.btrace.BTraceUtils.println;
import static com.sun.btrace.BTraceUtils.str;
import static com.sun.btrace.BTraceUtils.strcat;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.aggregation.Aggregation;
import com.sun.btrace.aggregation.AggregationFunction;
import com.sun.btrace.aggregation.AggregationKey;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnEvent;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.OnTimer;
import com.sun.btrace.annotations.Self;

@BTrace
public class AsyncLoadTracer {

    private static AtomicInteger rejecctCount = BTraceUtils.newAtomicInteger(0);
    private static Aggregation histogram = newAggregation(AggregationFunction.QUANTIZE);
    private static Aggregation average = newAggregation(AggregationFunction.AVERAGE);
    private static Aggregation max = newAggregation(AggregationFunction.MAXIMUM);
    private static Aggregation min = newAggregation(AggregationFunction.MINIMUM);
    private static Aggregation sum = newAggregation(AggregationFunction.SUM);
    private static Aggregation count = newAggregation(AggregationFunction.COUNT);

    @OnMethod(clazz = "java.util.concurrent.ThreadPoolExecutor", method = "execute", location = @Location(value = Kind.ENTRY))
    public static void executeMonitor(@Self Object self) {
        Field poolSizeField = field("java.util.concurrent.ThreadPoolExecutor", "poolSize");
        Field largestPoolSizeField = field("java.util.concurrent.ThreadPoolExecutor", "largestPoolSize");
        Field workQueueField = field("java.util.concurrent.ThreadPoolExecutor", "workQueue");

        Field countField = field("java.util.concurrent.ArrayBlockingQueue", "count");
        int poolSize = (Integer) get(poolSizeField, self);
        int largestPoolSize = (Integer) get(largestPoolSizeField, self);
        int queueSize = (Integer) get(countField, get(workQueueField, self));

        println(strcat(strcat(strcat(strcat(strcat("poolSize : ", str(poolSize)), " largestPoolSize : "),
                str(largestPoolSize)), " queueSize : "), str(queueSize)));
    }

    @OnMethod(clazz = "java.util.concurrent.ThreadPoolExecutor", method = "reject", location = @Location(value = Kind.ENTRY))
    public static void rejectMonitor(@Self Object self) {
        String name = str(self);
        if (BTraceUtils.startsWith(name, "com.alibaba.pivot.common.asyncload.impl.pool.AsyncLoadThreadPool")) {
            BTraceUtils.incrementAndGet(rejecctCount);
        }
    }

    @OnTimer(1000)
    public static void rejectPrintln() {
        int reject = BTraceUtils.getAndSet(rejecctCount, 0);
        println(strcat("reject count in 1000 msec: ", str(reject)));
        AggregationKey key = newAggregationKey("rejectCount");
        addToAggregation(histogram, key, reject);
        addToAggregation(average, key, reject);
        addToAggregation(max, key, reject);
        addToAggregation(min, key, reject);
        addToAggregation(sum, key, reject);
        addToAggregation(count, key, reject);
    }

    @OnEvent
    public static void onEvent() {
        BTraceUtils.truncateAggregation(histogram, 10);
        println("---------------------------------------------");
        printAggregation("Count", count);
        printAggregation("Min", min);
        printAggregation("Max", max);
        printAggregation("Average", average);
        printAggregation("Sum", sum);
        printAggregation("Histogram", histogram);
        println("---------------------------------------------");
    }
}