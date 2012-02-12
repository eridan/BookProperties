package com.mycompnay.bookstatistics;

import com.mycompnay.utils.BookFileReader;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStatistics {

    public static void main(String[] args) {
        
        BookStatistics inst = new BookStatistics();
        inst.go();
    }
    
    private void go() {
        
        long startTime = Calendar.getInstance().getTimeInMillis();
        String book = "";
        try {
            book = BookFileReader.readBookFromFile("book.txt");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Process Time in mils: "+(endTime-startTime));
        System.out.println("--");
        System.out.println(book);
        
    }
}
