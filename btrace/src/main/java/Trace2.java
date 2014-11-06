import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

@BTrace public class Trace2{
    @OnMethod(
            clazz="org.apache.catalina.util.StringManager",
            method="getString",
            location=@Location(Kind.RETURN)
    )
    public static void traceExecute(String key,Object arg,@Return String result){
        println("-----------getString");
        println(key);
        println(arg);
        println(result);
    }

    @OnMethod(
            clazz="org.jboss.logging.Logger",
            method="error"
    )
    public static void traceExecute2(Object message,Throwable t){
        if(startsWith(str(message),"Exception sending context initialized event")){
            println("-----------exception");
            printFields(t);
        }
    }
}