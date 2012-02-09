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

        int num = ((Word)word).getNoOfOcc();        
        int num1 = ((Word)aWord).getNoOfOcc();
       
        if(num > num1)
            return 1;
        else if(num < num1)
            return -1;
        else
            return 0;    
    }
    
    
}
