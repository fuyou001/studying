package com.fuyou;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: yubao.fyb@alibaba-inc.com
 * Date: 13-8-12
 */
public class Consumer implements Callable<Multiset<Word>> {
    private BlockingQueue<String> blockingQueue;
    private Pattern pattern = Pattern.compile("\\w++");
    private Multiset<Word> wordHashMultiset;
    private Set<Integer> ignoreSet;
    private boolean isDone;

    public Consumer(BlockingQueue<String> blockingQueue, Set<Integer> ignoreSet) {
        this.blockingQueue = blockingQueue;
        this.wordHashMultiset = HashMultiset.create();
        this.ignoreSet = ignoreSet;
    }

    @Override
    public Multiset<Word> call() throws Exception {
        while (!isDone) {
            String line = blockingQueue.take();
            if (Constant.ENDLINE_HASHCODE == line.hashCode()) {
                blockingQueue.put(line);
                isDone = true;
            } else {
                Matcher matcher = pattern.matcher(StringUtils.trim(line));
                while (matcher.find()) {
                    String word = matcher.group();
                    addWord(word.toLowerCase()); //不区分大小写
                }
            }
        }
        return wordHashMultiset;

    }


    public void addWord(String word) {
        if (ignoreSet.contains(word.hashCode())) {
            return;
        }
        wordHashMultiset.add(new Word((word)));
    }



}