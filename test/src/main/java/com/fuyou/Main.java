package com.fuyou;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

import java.util.Set;
import java.util.concurrent.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


/**
 * User: yubao.fyb@alibaba-inc.com Date: 13-8-12
 */
public class Main {
    private static final int BLOCKINGQUEUESIZE = 100000;
    private static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(BLOCKINGQUEUESIZE);
    private static final  String[] ignoreWord =
            new String[]{"the", "and", "i", "to", "of", "a", "in", "was", "that", "had", "he", "you", "his", "my",
                    "it", "as", "with", "her", "for", "on"};

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    private static int top = 10;
    private static int threadSize = Runtime.getRuntime().availableProcessors();
    private static String fileName = "/Users/fuyou/study/java/studying/test/src/main/resources/document.txt";

    public static void main(String[] args) throws Exception {
        //Thread.sleep(5000);
        parserArgs(args);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        startupProducer(fileName);

        printResult(getEntryOrdering(), top, statisticsWord());

        stopwatch.stop();

        System.out.println("task elapsed time\t" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        executor.shutdown();
    }

    public static void parserArgs(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage:filePath threadSize(default processor) top(default 10)");
            System.exit(0);
        }
        fileName = StringUtils.trim(args[0]);

        if (args.length > 1 && !Strings.isNullOrEmpty(args[1])) {
            threadSize = Integer.parseInt(StringUtils.trim(args[1]));
        }

        if (args.length > 2 && !Strings.isNullOrEmpty(args[2])) {
            top = Integer.parseInt(StringUtils.trim(args[2]));
        }
        System.out.println("fileName:" + fileName + "\tthreadSize:" + threadSize + "\ttop:" + top);
    }

    public static void startupProducer(String fileName) {
        Producer producer = new Producer(blockingQueue, fileName);
        executor.submit(producer);
    }


    private static Set<Integer> buildIntegerSet() {
        Set<Integer> ignoreSet = Sets.newHashSet(ignoreWord.length * 2);
        for (String word : ignoreWord) {
            ignoreSet.add(word.hashCode());
        }
        return ignoreSet;
    }


    private static Multiset<Word> statisticsWord() throws InterruptedException, ExecutionException {
        Set<Integer> ignoreSet = buildIntegerSet();
        CompletionService<Multiset<Word>> completionService = new ExecutorCompletionService<Multiset<Word>>(executor);

        for (int i = 0; i < threadSize; i++) {
            Consumer consumer = new Consumer(blockingQueue, ignoreSet);
            completionService.submit(consumer);
        }

        Multiset<Word> multiset = HashMultiset.create();
        for (int i = 0; i < threadSize; i++) {
            Future<Multiset<Word>> future = completionService.take();
            multiset.addAll(future.get());
        }
        return multiset;
    }


    private static Ordering<Multiset.Entry<Word>> getEntryOrdering() {
        return new Ordering<Multiset.Entry<Word>>() {
            @Override
            public int compare(Multiset.Entry<Word> word1, Multiset.Entry<Word> word2) {
                return Ints.compare(word1.getCount(), word2.getCount());
            }
        };
    }


    public static void printResult(Ordering<Multiset.Entry<Word>> comparator, int top, Multiset<Word> result) {
        System.out.println("**********sort result**************");
        System.out.println("\tword\t\tcount");
        for (Multiset.Entry<Word> wordEntry : comparator.greatestOf(result.entrySet(), top)) {
            System.out.printf("\t%s\t%6d\n", wordEntry.getElement().getWord(), wordEntry.getCount());
        }
        System.out.println("**********done...**************");
    }

}
