import com.fuyou.BenchmarkEngine;
import com.fuyou.BenchmarkResult;
import com.fuyou.BenchmarkResultFormat;
import com.fuyou.BenchmarkService;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-8-27
 * Time: ÉÏÎç11:15
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkTest {
    public static void main(String[] args) {
        BenchmarkEngine benchmarkEngine = new BenchmarkEngine();
        BenchmarkService benchmarkService = new BenchmarkService() {
            @Override
            public Object benchmark() throws Exception {
                Thread.sleep(100);
                return null;
            }
        };

        BenchmarkResult benchmarkResult = benchmarkEngine.benchmark(15, 100, 5, benchmarkService);
        BenchmarkResultFormat benchmarkResultFormat = new BenchmarkResultFormat();
        String st =  benchmarkResultFormat.format(benchmarkResult,"test");
        System.out.println(st);
    }
}
