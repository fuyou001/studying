package com.fuyou;

import com.google.common.base.Charsets;
import com.google.common.base.Stopwatch;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: yubao.fyb@alibaba-inc.com
 * Date: 13-8-12
 */
public class Producer implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private File file;
    private Charset charset = Charsets.UTF_8;

    public Producer(BlockingQueue<String> blockingQueue, File file) {
        this.blockingQueue = blockingQueue;
        this.file = file;
    }

    public Producer(BlockingQueue<String> blockingQueue, String fileName) {
        this(blockingQueue, new File(fileName));
    }

    @Override
    public void run() {
        try {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.start();
            Files.readLines(file, charset, new LineProcessor<Boolean>() {
                @Override
                public boolean processLine(String line) throws IOException {
                    try {
                        blockingQueue.put(line);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return true;
                }
                @Override
                public Boolean getResult() {
                    return true;
                }
            });
            stopwatch.stop();
            System.out.println("read file elapsed\t" +stopwatch.elapsed(TimeUnit.MILLISECONDS)+" ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                blockingQueue.put(Constant.ENDLINE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


