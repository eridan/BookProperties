/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jurijspe
 */
public class WordProcessor {

    static List<Word> getTopWordsAndCount(String bookLine, List<Word> wordList) {

        // [\w[\s,-]]+ Searching for sentence pattern
        
        Pattern p = Pattern.compile("\\w+['-]");
        Matcher m = p.matcher(bookLine);
        while (m.find()) {
            Word word = new Word();
            word.setWord(m.group());
            wordList.add(word);
        }

        return wordList;

    }
    
    public static List<Word> getWordCount(List<Word> wordList) {
        
        List<Word> wordListCopy = wordList;
        
        for (Word word : wordList) {
            for (Word word1 : wordListCopy) {
                if(word == word1) {
                    word.setNoOfOcc(word.getNoOfOcc()+1);
                }
            }
        }
        return wordList;
    }
}
