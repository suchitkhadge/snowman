package com.game;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Guesses {

  static boolean getPlayerGuess(Scanner keyboard, String word,
      List<Character> playerGuesses, Set<String> usedCharacterSet) {
    System.out.println("**********************************");
    System.out.println("Please enter a letter:");
    String letterGuess = keyboard.nextLine();
    if (usedCharacterSet.contains(letterGuess)){
      System.out.println("Letter already used. Please enter a letter again: ");
      letterGuess = keyboard.nextLine();
    }
    usedCharacterSet.add(letterGuess);
    System.out.println(usedCharacterSet);
    playerGuesses.add(letterGuess.charAt(0));
    return word.contains(letterGuess);
  }

}
