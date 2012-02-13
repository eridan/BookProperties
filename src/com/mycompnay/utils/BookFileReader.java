/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import com.mycompnay.domain.Word;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

/**
 *
 * @author jurijspe
 */
public class BookFileReader {

    private static String nl = Constants.LINE_SEPARATOR;
    private static String encoding = Constants.ENCODING;
    private static List<Word> wordList = new ArrayList<Word>();
    private static TreeSet<Word> topWordSet;

    public static List<Word> getWordList() {
        return wordList;
    }

    public static String readBookFromFile(String filename) throws FileNotFoundException, IOException {
        StringBuilder book = new StringBuilder();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String bookLine = "";
        try {
            while ((bookLine = br.readLine()) != null) {
                WordProcessor.getTopWordsAndCount(bookLine, wordList);
                book.append(bookLine).append(nl);
            }
        } finally {
            br.close();
        }

        System.out.println("======== Calculating total Word count ============");
//        getTotalWordCount();

        System.out.println("\n======== Top 100 words ============");
//        getTop100Words();

        return book.toString();
    }

    private static void getTop100Words() {
//        System.out.print("Top 100 words are: [");
        WordCompare wordComparator = new WordCompare();
        topWordSet = new TreeSet<Word>(wordComparator);
        topWordSet.addAll(WordProcessor.getWordCount((ArrayList) wordList));
        topWordSet = (TreeSet<Word>) topWordSet.descendingSet();

//        System.out.println("-------------------------");
        System.out.println("Words with no dups " + topWordSet.size());
        System.out.print("[");
        for (Word word : topWordSet) {
            System.out.print(word + " ");
        }
        System.out.print("]\n-------------------------\n");
//
//        int iteration = 0;
//        int noOfOcc = 0;
//        while (iteration < 101 && noOfOcc != 1) {
//            for (Word word : topWordSet.descendingSet()) {
////                System.out.println("Examing word: " + word);
//                if (noOfOcc != 0) {
//                    if (noOfOcc == word.getNoOfOcc()) {
////                        System.out.println(iteration + ". " + word + "\n");
//                    } else {
//                        iteration++;
//                    }
//                } else {
//                    iteration++;
//                    noOfOcc = word.getNoOfOcc();
////                    System.out.println(iteration + ". " + word + "\n");
//                }
//            }
//        }

        System.out.print("]\n-------------------------------\n");
    }

    private static void getTotalWordCount() {
        System.out.print("Word list size " + wordList.size() + "[ ");
        for (Word word : wordList) {
            System.out.print(word.getWord() + " ");
        }
        System.out.println("]");
    }
}
