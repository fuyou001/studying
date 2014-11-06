import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.Threads.jstack;

/**
 * User: yubao.fyb
 * Date: 14/11/6
 * Time: 19:19
 */
public class MemTrace {
   //最常见的第一个问题是java.lang.OutOfMemoryError，估计写Java的同学都碰到过。
   // 在日志中可能会看到java.lang.OutOfMemoryError: Unable to create new native thread，可以先统计下目前的线程数(例如ps -eLf | grep java -c)，然后可以看看ulimit -u的限制值是多少，如线程数已经达到限制值，如限制值可调整，则可通过调整限制值来解决；如不能调限制值，或者创建的线程已经很多了，那就需要看看线程都是哪里创建出来的，同样可通过btrace来查出是哪里创建的，脚本类似如下：
    @OnMethod(
            clazz="java.lang.Thread",
            method="start"
    )
    public static void traceExecute(){
        jstack();
    }

    //java.lang.OutOfMemoryError: PermGen Space，当碰到这个现象时，可以通过调整permgen size来试试，如果放大了一点后还是不断的消耗，则可以通过btrace来跟踪下装载class的现象，脚本类似如下：
    @OnMethod(
            clazz="java.lang.ClassLoader",
            method="defineClass"
    )
    public static void defineClass(){
        jstack();
    }
}
