import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.jstack;

@BTrace
public class ClassNotFoundExceptionTrace {
    @OnMethod(
            clazz = "java.lang.ClassNotFoundException",
            method = "<init>"
    )
    public static void traceExecute() {
        jstack();
    }
}