/*
 * File: Wordle.java
 * Name: ___________
 * Date: 5/15/2025
 * -----------------
 * This module is the starter file for the Wordle assignment.
 */

import UIFiles.WordleDictionary;
import UIFiles.WordleGWindow;

public class Wordle
{
    private WordleGWindow wordleGame;
    String[] dictionaryArray = WordleDictionary.FIVE_LETTER_WORDS; //This String array contains all the words in the dictionary
    String[] testArray = WordleDictionary.TEST_WORDS; //This String array is used for testing if needed. Modify the test-words.txt file to change it.
    private String correctWord;
    

    /* Sets correctWord to a word randomly choosen from the dictionary */
    public void setCorrectWord()
    {
        System.out.println("No correct word choosen");

    }

    /* Send in a guess and this returns if that guess is in the dictionary. You will call this method in enterAction */
    public boolean isInDictionary(String guess)
    {
        return false;
    }

    /* Almost everything you do will be inside of this enterAction method.
    * Called when the user hits the RETURN key or clicks the ENTER button,
    * passing in the string of characters on the current row.  */

    public void enterAction(String guess) 
    {
        wordleGame.setSquareColor(0, 0, WordleGWindow.CORRECT_COLOR);
        wordleGame.showMessage("You have to implement this method.");
        
    }
    
    
    

    /* Startup code. You do not need to edit anything about this! */

    public void run() 
    {
        wordleGame = new WordleGWindow();
        wordleGame.addEnterListener((s) -> enterAction(s)); //Arrow function, learn more about how it works in the documentation
        setCorrectWord(); //Runs the setCorrectWord method that you are making
    }

    public static void main(String[] args) 
    {
        new Wordle().run();
    }  

}
