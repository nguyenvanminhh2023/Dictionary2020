/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.dic;

import java.util.Comparator;

/**
 *
 * @author Tram Tram
 */
public class Word implements Comparator<Word> {
    private String word_target;
    private String word_explain;

    public Word() {
        
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    @Override
    public int compare(Word o1, Word o2) {
        return  (o1.getWord_target().compareTo(o2.getWord_target())); //To change body of generated methods, choose Tools | Templates.
    }
}

