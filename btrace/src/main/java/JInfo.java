import com.sun.btrace.annotations.BTrace;

import static com.sun.btrace.BTraceUtils.*;
import static com.sun.btrace.BTraceUtils.Sys.Env.printEnv;

/**
 * User: yubao.fyb
 * Date: 14/11/6
 * Time: 17:47
 */
@BTrace
public class JInfo {
    static {
        println("System Properties:");
        printProperties();
        println("VM Flags:");
        printVmArguments();
        println("OS Enviroment:");
        printEnv();
        exit(0);
    }
}