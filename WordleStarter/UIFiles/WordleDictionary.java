/*
 * File: WordleDictionary.java
 * ---------------------------
 * This file exports the dictionary of five-letter words used in the
 * Wordle project.
 */

package UIFiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.net.*;

/**
 * This class implements the dictionary for the Wordle project.
 */

public class WordleDictionary {

    static String filePath = "UIFiles/valid-wordle-words.txt";
    static String filePath2 = "test-words.txt";
    public static final String[] FIVE_LETTER_WORDS;
    public static final String[] TEST_WORDS;
    

    static 
    {
        //List<String> tempList = new ArrayList<>();

        try {
            URL dictionaryDownload = new URL("https://gist.githubusercontent.com/dracos/dd0668f281e685bad51479e5acaadb93/raw/6bfa15d263d6d5b63840a8e5b64e04b382fdb079/valid-wordle-words.txt?scrlybrkr=c3a43dc7");
            BufferedReader br = new BufferedReader(new InputStreamReader(dictionaryDownload.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            // read from your scanner
            String line;
            while ((line = br.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

        } catch (e) {

        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            List<String> tempList = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                tempList.add(line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("File not found! Make sure you have the valid-wordle-words.txt file in the UIFiles folder!"); 
        }
        FIVE_LETTER_WORDS = tempList.toArray(new String[0]);
    }
    
    static 
    {
        List<String> tempList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) 
        {
            String line;
            while ((line = br.readLine()) != null) {
                tempList.add(line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("File not found! Make sure you have the test-words.txt file in the main folder!"); 
        }
        TEST_WORDS = tempList.toArray(new String[0]);
    }
}
