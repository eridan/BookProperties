package com.mycompnay.bookstatistics;

import com.mycompnay.utils.BookFileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStatistics {

    public static void main(String[] args) throws IOException {
        
        BookStatistics inst = new BookStatistics();
        inst.go();
    }
    
    private void go() throws IOException {
        
        String book = "";
        long startTime = System.currentTimeMillis();
        try {
            book = BookFileReader.readBookFromFile("book.txt");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("\n======== Process Time ============");
        System.out.println("\nProcess Time in mils: "+(endTime-startTime));
        System.out.println("\n======== Book ============");
        System.out.println(book);
        
    }
}
