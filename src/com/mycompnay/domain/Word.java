/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.domain;

/**
 *
 * @author jurijspe
 */
public class Word {
    
    private int id;
    private int noOfOcc;
    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNoOfOcc() {
        return noOfOcc;
    }

    public void setNoOfOcc(int noOfOcc) {
        this.noOfOcc = noOfOcc;
    }
    
    @Override
    public boolean equals(Object aWord) {
        Word w = (Word) aWord;
        return getWord().equals(w.getWord());
    }
    
    @Override
    public int hashCode() {
        return word.hashCode();
    }
    
}
