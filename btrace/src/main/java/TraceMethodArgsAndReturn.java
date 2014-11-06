import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace public class TraceMethodArgsAndReturn{

    @OnMethod(
            clazz="CaseObject1",
            method="execute",
            location=@Location(Kind.RETURN)
    )
    public static void traceExecute(@Self CaseObject instance,int sleepTime,@Return boolean result){
        println("call CaseObject.execute");
        println(strcat("sleepTime is:",str(sleepTime)));
        println(strcat("sleepTotalTime is:",str(get(field("CaseObject","sleepTotalTime"),instance))));
        println(strcat("return value is:",str(result)));
        println(Strings.concat("object of: ", Reflective.name(Reflective.classOf(instance))));
        println(Strings.concat("size: ", Strings.str(sizeof(instance))));
    }

    @OnMethod(clazz="CaseObject", method="/.*/",
            location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
    public static void n(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn,
                         @TargetInstance Object instance, @TargetMethodOrField String method, String text,AnyType[] args ) { // all calls to the methods with signature "(String)"
        println(Strings.strcat("Context: ", Strings.strcat(pcm, Strings.strcat("#", pmn))));
        print(method);
        print(" ");
        println(text);
        printArray(args);
    }

    @OnMethod(clazz="CaseObject2", method="/.*/",
            location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
    public static void o(@Self Object self, @ProbeMethodName String pmn, AnyType[] args) { // all calls to methods
        printArray(args);
    }

    @OnMethod(
            clazz="CaseObject2",
            location=@Location(value=Kind.LINE, line=-1)
    )
    public static void online(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
        print(Strings.strcat(pcn, "."));
        print(Strings.strcat(pmn, ":"));
        println(line);
    }
    @OnMethod(
            clazz="+java.lang.ClassLoader",
            method="defineClass",
            location=@Location(Kind.RETURN)
    )
    public static void defineclass(@Return Class cl) {
        println(Strings.strcat("loaded ", Reflective.name(cl)));
        Threads.jstack();
        println("==========================");
    }

}

