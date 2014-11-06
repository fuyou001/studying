import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;

@BTrace public class Trace{

    @OnMethod(
            clazz="java.net.URL",
            method="openConnection",
            location=@Location(Kind.RETURN)
    )
    public static void resolveEntity(@Self Object instance){
        String protocol = str(get(field("java.net.URL", "protocol"),instance));
        String file = str(get(field("java.net.URL", "file"),instance));
        if(startsWith(protocol,"http") && (endsWith(file,".xsd") || endsWith(file,".dtd"))){
            String authority = str(get(field("java.net.URL", "authority"),instance));
            String path = str(get(field("java.net.URL", "path"),instance));
            println("=====================================");
            print(protocol);
            print("://");
            print(authority);
            print(path);
            println(" not found!");
            println("who call:");
            jstack();
        }
    }