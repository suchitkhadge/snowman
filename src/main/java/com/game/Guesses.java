package com.game;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Guesses {

  static boolean getPlayerGuess(Scanner keyboard, String word,
      List<Character> playerGuesses, Set<String> usedCharacterSet) {
    System.out.println("**********************************");
    System.out.println("Please enter a letter:");
    String letterGuess = keyboard.nextLine().toLowerCase();
    char charGuess = 0;
    charGuess = letterGuess.charAt(0);
    while ((usedCharacterSet.contains(letterGuess)) || (!Character.isAlphabetic(charGuess))){
      System.out.println("Invalid letter OR letter already used.  Please enter a letter again: ");
      letterGuess = keyboard.nextLine();
      charGuess = letterGuess.charAt(0);
    }


    usedCharacterSet.add(letterGuess);
    System.out.println(usedCharacterSet);
    playerGuesses.add(letterGuess.charAt(0));
    return word.contains(letterGuess);
  }

}
