import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.aggregation.Aggregation;
import com.sun.btrace.aggregation.AggregationFunction;
import com.sun.btrace.aggregation.AggregationKey;
import com.sun.btrace.annotations.*;

/**
 * User: yubao.fyb
 * Date: 14/11/27
 * Time: 15:37
 */
@BTrace
public class NotifyLatency {
    private static Aggregation histogram = newAggregation(AggregationFunction.QUANTIZE);

    private static Aggregation average = newAggregation(AggregationFunction.AVERAGE);

    private static Aggregation max = newAggregation(AggregationFunction.MAXIMUM);

    private static Aggregation min = newAggregation(AggregationFunction.MINIMUM);

    private static Aggregation sum = newAggregation(AggregationFunction.SUM);

    private static Aggregation count = newAggregation(AggregationFunction.COUNT);

    private static Aggregation globalCount = newAggregation(AggregationFunction.COUNT);

    @OnMethod(
            clazz = "/com.taobao\\.notify\\.server\\.kernel\\.handler\\..*/",
            method = "/.*/",
            location = @Location(Kind.RETURN))
    public static void onMethodReturn(@ProbeClassName String pcm,@ProbeMethodName String method, @Duration long duration) {
        AggregationKey key = newAggregationKey(Strings.strcat(pcm, Strings.strcat("#", method)));
        addToAggregation(histogram, key, duration);
        addToAggregation(average, key, duration);
        addToAggregation(max, key, duration);
        addToAggregation(min, key, duration);
        addToAggregation(sum, key, duration);
        addToAggregation(count, key, duration);
        addToAggregation(globalCount, duration);
    }

    @OnEvent
    public static void onEvent() {
        println(timestamp("yyyy HH:mm:ss"));
        printAggregation("histogram", histogram);
        printAggregation("min", min);
        printAggregation("max", max);
        printAggregation("average", average);
        printAggregation("sum", sum);
        printAggregation("count", count);
        printAggregation("global count", globalCount);
        println("---------------------------------------------");
    }

    @OnTimer(60000)
    public static void onTimer() {
        println(timestamp("yyyy HH:mm:ss"));
        printAggregation("histogram", histogram);
        printAggregation("min", min);
        printAggregation("max", max);
        printAggregation("average", average);
        printAggregation("sum", sum);
        printAggregation("count", count);
        printAggregation("global count", globalCount);
        println("---------------------------------------------");
    }

}
