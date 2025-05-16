/*
 * File: updateDictionary.java
 * ---------------------------
 * This file updates and fixes the dictionary of five-letter words used in the
 * Wordle project.
 */

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class updateDictionary {
    public static void main(String[] args) {
        String filePath = "UIFiles/valid-wordle-words.txt";

        try {
            // Read all lines (words) from the file
            List<String> words = Files.readAllLines(Paths.get(filePath));

            Set<String> filteredWords = new TreeSet<String>();
            for(String word : words)
            {
                if(word.length() != 5)
                {
                    System.out.println("Removing " + word);
                }
                else
                {
                    filteredWords.add(word.toLowerCase());
                }
            }
            List<String> finishedWords = new ArrayList<>(filteredWords);
            // Sort the list alphabetically
            Collections.sort(finishedWords, String.CASE_INSENSITIVE_ORDER);

            // Write the sorted words back to the file
            Files.write(Paths.get(filePath), finishedWords);

            System.out.println("Words sorted and saved successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
