import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

@BTrace public class TraceMethodExecuteTime{

    @TLS static long beginTime;

    @OnMethod(
            clazz="CaseObject",
            method="execute"
    )
    public static void traceExecuteBegin(){
        beginTime=timeMillis();
    }

    @OnMethod(
            clazz="CaseObject",
            method="execute",
            location=@Location(Kind.RETURN)
    )
    public static void traceExecute(int sleepTime,@Return boolean result){
        println(strcat(strcat("CaseObject.execute time is:",str(timeMillis()-beginTime)),"ms"));
    }
}
