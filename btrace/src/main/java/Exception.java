
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

/**
 * This example demonstrates printing stack trace
 * of an exception and thread local variables. This
 * trace script prints exception stack trace whenever
 * java.lang.Throwable's constructor returns. This way
 * you can trace all exceptions that may be caught and
 * "eaten" silently by the traced program. Note that the
 * assumption is that the exceptions are thrown soon after
 * creation [like in "throw new FooException();"] rather
 * that be stored and thrown later.
 */
@BTrace public class Exception {
    // store current exception in a thread local
    // variable (@TLS annotation). Note that we can't
    // store it in a global variable!
    @TLS static Throwable currentException;

    // introduce probe into every constructor of java.lang.Throwable
    // class and store "this" in the thread local variable.
    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void Exception(@Self Throwable self) {
        currentException = self;
    }

    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow1(@Self Throwable self, String s) {
        currentException = self;
    }

    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow1(@Self Throwable self, String s, Throwable cause) {
        currentException = self;
    }

    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>"
    )
    public static void onthrow2(@Self Throwable self, Throwable cause) {
        currentException = self;
    }

    // when any constructor of java.lang.Throwable returns
    // print the currentException's stack trace.
    @OnMethod(
            clazz="java.lang.Throwable",
            method="<init>",
            location=@Location(Kind.RETURN)
    )
    public static void onthrowreturn() {
        if (currentException != null) {
            Threads.jstack(currentException);
            println("=====================");
            currentException = null;
        }
    }
}
