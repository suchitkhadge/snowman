package com.game.controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Method to check to see if the user character is in the hidden word or not. It uses the while loop
 * to validate the input and ask user to enter again if the input is not valid.
 */

public class Guesses {


  public static boolean isGuessLetterInWord(Scanner keyboard, String word,
      List<Character> playerGuesses, Set<String> usedCharacterSet) {
    System.out.println("**********************************");
    System.out.println("Please enter a letter:");
    String letterGuess = keyboard.nextLine().toLowerCase();
    char charGuess;
    charGuess = letterGuess.charAt(0);
    while ((usedCharacterSet.contains(letterGuess)) || (!Character.isAlphabetic(charGuess))) {
      System.out.println("Invalid attempt. Not a letter or letter already used. Please try again");
      letterGuess = keyboard.nextLine();
      charGuess = letterGuess.charAt(0);
    }
    usedCharacterSet.add(letterGuess);
    System.out.println(usedCharacterSet);
    playerGuesses.add(letterGuess.charAt(0));
    return word.contains(letterGuess);
  }

}
