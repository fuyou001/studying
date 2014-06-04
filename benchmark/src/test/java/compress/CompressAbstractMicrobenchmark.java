package compress;

import com.fuyou.compress.SnappyCompress;
import com.fuyou.compress.ZLIBCompress;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

/**
 * User: yubao.fyb
 * Date: 14-6-4
 * Time: 14:30
 */

public class CompressAbstractMicrobenchmark extends AbstractMicrobenchmark {
    //100 byte
    private static String str = "Hello snappy-java! Snappy-java is a JNI-based wrapper of Snappy, a fast compresser/decompresser tes";
    private static final String encoding = "utf-8";
    @Param({"10", "20", "30", "40", "80"})
    public int size;
    static String snappyCompressStr = null, zlibCompressStr = null;

    @GenerateMicroBenchmark
    public void SnappyCompress() throws IOException {
        StringBuffer stringBuffer = new StringBuffer(8 * 1024);
        for (int i = 0; i < size; i++) {
            stringBuffer.append(str);
        }
        byte[] snappyByte = SnappyCompress.compress(stringBuffer.toString().getBytes(encoding));
        snappyCompressStr = new String(snappyByte, encoding);
        //System.out.println(compressStr.concat(str));
    }

    @GenerateMicroBenchmark
    public void ZlibCompress() throws IOException {
        StringBuffer stringBuffer = new StringBuffer(8 * 1024);
        for (int i = 0; i < size; i++) {
            stringBuffer.append(str);
        }
        byte[] zlibBytes = ZLIBCompress.compress(stringBuffer.toString().getBytes(encoding));
        zlibCompressStr = new String(zlibBytes, encoding);
        //System.out.println(compressStr.concat(str));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + CompressAbstractMicrobenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .build();

        new Runner(opt).run();

        System.out.println("SnappyCompress:" + snappyCompressStr.concat(str));
        System.out.println("zlibCompressStr:" + zlibCompressStr.concat(str));
    }
}
