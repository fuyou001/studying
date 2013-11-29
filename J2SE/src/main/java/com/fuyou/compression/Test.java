package com.fuyou.compression;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: yubao.fyb
 * Date: 13-11-29
 * Time: 11:49
 */
public class Test {
    private static final String encoding = "utf-8";

    public static void main(String[] args) throws IOException {
        String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of Snappy, a fast compresser/decompresser.";
        input+=input;
        int warmUp = 1000000;
        byte[] zlibBytess = null, snappy = null;
        for (int i = 0; i < warmUp; i++) {
            zlibBytess = ZLIBCompress.compress(input.getBytes(encoding));
        }
        for (int i = 0; i < warmUp; i++) {
            snappy = SnappyCompress.compress(input.getBytes(encoding));
        }

        long zlibStartup = System.currentTimeMillis();
        for (int i = 0; i < warmUp * 10; i++) {
            zlibBytess = ZLIBCompress.compress(input.getBytes(encoding));
        }
        long zipTime = System.currentTimeMillis() - zlibStartup;

        long snappyStartup = System.currentTimeMillis();
        for (int i = 0; i < warmUp * 10; i++) {
            snappy = SnappyCompress.compress(input.getBytes(encoding));
        }
        long snappTime = System.currentTimeMillis() - snappyStartup;

        System.out.println("zlip:" + zipTime);
        System.out.println("napptime:" + snappTime);
        String zlibStr = new String(ZLIBCompress.uncompress(zlibBytess), encoding);
        String snappyStr = new String(SnappyCompress.unCompress(snappy), encoding);
        System.out.println(input.equals(zlibStr));
        System.out.println(input.equals(snappyStr));

    }
}
