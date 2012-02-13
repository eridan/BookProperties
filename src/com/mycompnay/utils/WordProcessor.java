/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.util.ArrayList;
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

        //Pattern for word
        Pattern p = Pattern.compile("\\b[[A-Z][a-z]-']+\\b");
//        Pattern p = Pattern.compile("\\w+['-]");
        Matcher m = p.matcher(bookLine);
        while (m.find()) {
            Word word = new Word();
            word.setWord(m.group().toLowerCase());
            wordList.add(word);
        }

        return wordList;

    }

    public static List<Word> getWordCount(ArrayList<Word> wordList) {

        List<Word> wordListCopy = wordList;

        for (Word word : wordList) {
            if (!wordList.get(wordList.indexOf(word)).isChecked()) {
                for (Word word1 : wordListCopy) {
//                    System.out.println(word + " vs " + word1);
                    if (word.equals(word1)) {
                        wordList.get(wordList.indexOf(word)).setNoOfOcc(word.getNoOfOcc() + 1);
//                        System.out.println("Updated: " + word);
                    }
                    if (wordListCopy.indexOf(word1) == wordListCopy.size() - 1) {
//                        System.out.println("End of text");
                        word.setChecked(true);
                    }
                }
            } else {
//                System.out.println(word.getWord() + " Had benn counted already");
            }
        }
        
        System.out.print("\nWords counted \n[");
        for (Word word : wordList) {
            System.out.print(word + " ");
        }
        System.out.print("]\n\n");
        
        return wordList;
    }
}
