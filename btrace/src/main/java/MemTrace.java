import com.sun.btrace.annotations.OnMethod;

import static com.sun.btrace.BTraceUtils.Threads.jstack;

/**
 * User: yubao.fyb
 * Date: 14/11/6
 * Time: 19:19
 */
public class MemTrace {
   //����ĵ�һ��������java.lang.OutOfMemoryError������дJava��ͬѧ����������
   // ����־�п��ܻῴ��java.lang.OutOfMemoryError: Unable to create new native thread��������ͳ����Ŀǰ���߳���(����ps -eLf | grep java -c)��Ȼ����Կ���ulimit -u������ֵ�Ƕ��٣����߳����Ѿ��ﵽ����ֵ��������ֵ�ɵ��������ͨ����������ֵ��������粻�ܵ�����ֵ�����ߴ������߳��Ѿ��ܶ��ˣ��Ǿ���Ҫ�����̶߳������ﴴ�������ģ�ͬ����ͨ��btrace����������ﴴ���ģ��ű��������£�
    @OnMethod(
            clazz="java.lang.Thread",
            method="start"
    )
    public static void traceExecute(){
        jstack();
    }

    //java.lang.OutOfMemoryError: PermGen Space���������������ʱ������ͨ������permgen size�����ԣ�����Ŵ���һ����ǲ��ϵ����ģ������ͨ��btrace��������װ��class�����󣬽ű��������£�
    @OnMethod(
            clazz="java.lang.ClassLoader",
            method="defineClass"
    )
    public static void defineClass(){
        jstack();
    }
}
