package com.game;

import java.util.List;

public class State {

  // Print the state of the word with user's guesses.
  static boolean printWordState(String word, List<Character> playerGuesses) {
    int correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (playerGuesses.contains(word.charAt(i))|| word.charAt(i) == '_') {
        System.out.print(word.charAt(i));
        correctCount++;
      } else {
        System.out.print("- ");
      }
    }
    System.out.println();

    return (word.length() == correctCount);
  }

}
