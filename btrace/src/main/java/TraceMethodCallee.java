import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

@BTrace public class TraceMethodCallee{
    @OnMethod(
            clazz="CaseObject",
            method="execute"
    )
    public static void traceExecute(){
        println("who call CaseObject.execute :");
        jstack();
    }
}