/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author jurijspe
 */
public class BookFileReader {

    private static String nl = Constants.LINE_SEPARATOR;
    private static String encoding = Constants.ENCODING;

    public static String readBookFromFile(String filename) throws FileNotFoundException {

        List<Word> wordList = new ArrayList<Word>();
        HashMap<Integer,Word> topWordMap = new HashMap<Integer, Word>();
        
        StringBuilder book = new StringBuilder();
        Scanner scanner = new Scanner(new FileInputStream(filename), encoding);
        try {
            while (scanner.hasNextLine()) {
                String bookLine = scanner.nextLine();
                WordProcessor.getTopWordsAndCount(bookLine, wordList);
                book.append(bookLine).append(nl);
            }
        } finally {
            scanner.close();
        }
        
        System.out.print("Word list size "+wordList.size() +"[ ");
        for (Word word : wordList) {
            System.out.print(word.getWord()+" "+"("+word.getNoOfOcc()+") ");
        }
        System.out.print("]");
        
        System.out.println("\n-------------------------------\n");
        System.out.print("Top 100 words are: ");
        topWordMap = WordProcessor.getTopWords(wordList);
        Set s = (topWordMap).entrySet();
        Iterator it = s.iterator();
        while(it.hasNext()){
            System.out.print("[ "+(String)it.next()+" ");
        }
        System.out.print("]\n-------------------------------\n");

        return book.toString();
    }
}
