/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.util.Comparator;

/**
 *
 * @author jurijspe
 */
public class WordCompare implements Comparator<Word> {

    @Override
    public int compare(Word word, Word aWord) {

        System.out.println("Comparing _"+word+"_ vs _"+aWord+"_");
        int num = ((Word) word).getNoOfOcc();
        int num1 = ((Word) aWord).getNoOfOcc();

        if (num > num1) {
            System.out.println("Comparator returns 1");
            return 1;
        } else if (num < num1) {
            System.out.println("Comparator returns -1");
            return -1;
        } else if (word.getWord().equalsIgnoreCase(aWord.getWord()) && num == num1) {
            System.out.println("Comparator returns 1");
            return 1;
//        } else if 
//                (word.getWord().equalsIgnoreCase(aWord.getWord())) {
//            return 0;
        } else {
            System.out.println("Comparator returns 0");
            return 0;
        }
    }
}
