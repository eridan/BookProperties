/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jurijspe
 */
public class WordProcessor {

    static List<Word> getTopWordsAndCount(String bookLine, List<Word> wordList) {
        int index = 0;
        int spaceIndex = 0;

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
    
    public static HashMap<Integer, Word> getTopWords(List<Word> wordList) {
        HashMap<Integer,Word> topWordMap = new HashMap<Integer, Word>();
        for (Word word : wordList) {
            if(topWordMap.containsValue(word)) {
                System.out.println("Word already exists!");
                topWordMap.get(word).setNoOfOcc(word.getNoOfOcc()+1);
            } else {
                word.setNoOfOcc(word.getNoOfOcc()+1);
                topWordMap.put(word.getNoOfOcc(), word);
            }
        }
        return topWordMap;
    }

    private static void setWordCount(String wordText, List<Word> wordList) {
        for (Word aWord : wordList) {
            if(aWord.getWord().equalsIgnoreCase(wordText)) {
                aWord.setNoOfOcc(aWord.getNoOfOcc()+1);
            } else {
                Word word = new Word();
                word.setWord(wordText);
            wordList.add(word);
            }
        }
    }
}
