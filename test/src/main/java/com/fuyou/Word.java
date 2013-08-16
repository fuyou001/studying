package com.fuyou;

/**
 * User: yubao.fyb@alibaba-inc.com
 * Date: 13-8-15
 */
public class Word {
    private String word;
    private int code;


    public Word(String word) {
        this.word = word;
        this.code = word.hashCode();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Word)) return false;
        return this.hashCode() == ((Word) o).hashCode() ? true : false;
    }

    @Override
    public int hashCode() {
        return code;
    }
}
