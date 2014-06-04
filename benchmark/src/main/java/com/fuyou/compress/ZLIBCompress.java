package com.fuyou.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: yubao.fyb
 * Date: 13-11-29
 * Time: 11:35
 */
public class ZLIBCompress {
    public static byte[] compress(byte[] message) {
        boolean compressed = false;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(message.length);
        DeflaterOutputStream os = new DeflaterOutputStream(baos);
        try {
            os.write(message);
            os.finish();
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            compressed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
            }
        }
        return baos.toByteArray();
    }

    public static byte[] uncompress(byte[] message) {
        boolean uncompressed = false;
        int COMPRESS_RATIO = 8; // 8是经验的一个压缩比，不影响使用
        int size = message.length * COMPRESS_RATIO;
        ByteArrayInputStream bais = new ByteArrayInputStream(message);
        InflaterInputStream is = new InflaterInputStream(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
        try {
            byte[] uncompressMessage = new byte[size];
            while (true) {
                int len = is.read(uncompressMessage);
                if (len <= 0) {
                    break;
                }
                baos.write(uncompressMessage, 0, len);
            }
            baos.flush();

        } catch (IOException e) {
           e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
            try {
                bais.close();
            } catch (IOException e) {
            }
            try {
                baos.close();
            } catch (IOException e) {
            }
        }
        return  baos.toByteArray();
    }
}
