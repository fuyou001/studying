package com.fuyou.compression;

import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: yubao.fyb
 * Date: 13-11-29
 * Time: 11:41
 */
public class SnappyCompress {
    public static byte[] compress(byte[] message) throws IOException {
        return Snappy.compress(message);

    }

    public static byte[] unCompress(byte[] message) throws IOException {
        return Snappy.uncompress(message);

    }

    public static void main(String[] args) throws IOException {
        String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of "
                + "Snappy, a fast compresser/decompresser.";
        byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
        byte[] uncompressed = Snappy.uncompress(compressed);

        String result = new String(uncompressed, "UTF-8");
        System.out.println(result);
    }
}
