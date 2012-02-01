/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jurijspe
 */
public class WordProcessor {

    private static List<Word> wordList = new ArrayList<Word>();

    static void getTopWordsAndCount(String bookLine) {
        int index = 0;
        while (index >= 0 && index < bookLine.length()) {
            int spaceIndex = bookLine.indexOf(" ", index);
            index = spaceIndex + 1;
        }

    }
}
