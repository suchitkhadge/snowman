package com.game.controller;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Management of user interaction after menu selection.
 */
public class Guesses {

  /**
   * Method used to decide if the user's attempt is valid
   * @param keyboard scans for user input.
   * @param word the word that the user is attempting to guess.
   * @param playerGuesses holds the users attempt as a list of characters.
   * @param usedCharacterSet stores users attempts as a set of Strings.
   * @return
   */
  static boolean getPlayerGuess(Scanner keyboard, String word,
      List<Character> playerGuesses, Set<String> usedCharacterSet) {
    System.out.println("**********************************");
    System.out.println("Please enter a letter:");
    String letterGuess = keyboard.nextLine().toLowerCase();
    char charGuess;
    charGuess = letterGuess.charAt(0);
    while ((usedCharacterSet.contains(letterGuess)) || (!Character.isAlphabetic(charGuess))) {
      System.out.println("Invalid attempt. Please try again");
      letterGuess = keyboard.nextLine().toLowerCase();;
      charGuess = letterGuess.charAt(0);
    }

    usedCharacterSet.add(letterGuess);
    System.out.println(usedCharacterSet);
    playerGuesses.add(letterGuess.charAt(0));
    return word.contains(letterGuess);
  }



}


