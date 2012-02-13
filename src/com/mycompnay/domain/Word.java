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
    // to avoid double checking in Search
    private boolean checked=false;

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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object aWord) {
        if (this == aWord) {
            return true;
        }

        if (!(aWord instanceof Word)) {
            return false;
        }
        Word w = (Word) aWord;
        return word.equalsIgnoreCase(w.getWord());
    }

    @Override
    public int hashCode() {
        System.out.println("HashCode for "+toString()+": "+word.hashCode());
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word.toLowerCase() + "(" + noOfOcc + ")";
    }
}
