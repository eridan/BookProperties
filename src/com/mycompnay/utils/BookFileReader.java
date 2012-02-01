/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompnay.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jurijspe
 */
public class BookFileReader {

    private static String nl = Constants.LINE_SEPARATOR;
    private static String encoding = Constants.ENCODING;

    public static String readBookFromFile(String filename) throws FileNotFoundException {

        StringBuilder book = new StringBuilder();
        Scanner scanner = new Scanner(new FileInputStream(filename), encoding);
        try {
            while (scanner.hasNextLine()) {
                String bookLine = scanner.nextLine();
                WordProcessor.getTopWordsAndCount(bookLine);
                book.append(bookLine).append(nl);
            }
        } finally {
            scanner.close();
        }

        return book.toString();
    }
}
