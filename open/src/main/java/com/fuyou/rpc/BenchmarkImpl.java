package com.fuyou.rpc;

/**
 * Created with IntelliJ IDEA.
 * User: yubaofu
 * Date: 12-7-30
 * Time: обнГ2:27
 * To change this template use File | Settings | File Templates.
 */
public class BenchmarkImpl implements Benchmark {
    @Override
    public Object Bencharmk(int size) {
        char c = 'c';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
