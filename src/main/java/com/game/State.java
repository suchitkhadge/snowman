package com.game;

import java.util.List;

public class State {

  static boolean checkSolution(String word, List<Character> playerGuesses) {
    int correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (playerGuesses.contains(word.charAt(i)) || word.charAt(i) == '_') {
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



