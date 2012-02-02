/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
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

        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(bookLine);
        while (m.find()) {
            String w = m.group();
            Word word = new Word();
            int number = word.getNoOfOcc();
            word.setNoOfOcc(number++);
            setWordCount(word.getWord(),wordList);
            word.setWord(w);
            wordList.add(word);
        }

        return wordList;

    }

    private static void setWordCount(String word, List<Word> wordList) {
        for (Word aWord : wordList) {
            if(aWord.getWord().equalsIgnoreCase(word)) {
                aWord.setNoOfOcc(aWord.getNoOfOcc()+1);
            }
        }
    }
}
