package com.game;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SnowManClient {


  public static void main(String[] args) throws FileNotFoundException, InvalidCharacterException {
    Menu menu = new Menu();

    menu.printMenu();
    WordList.words();

    SnowmanPicture.printSnowman(0);

    }


    static boolean getPlayerGuess(Scanner keyboard, String word,
        List<Character> playerGuesses, Set<String> usedCharacterSet) throws
    InvalidCharacterException {
      System.out.println("**********************************");
      System.out.println("Please enter a letter:");
      String letterGuess = keyboard.nextLine();
      usedCharacterSet.add(letterGuess);
      System.out.println(usedCharacterSet);
      playerGuesses.add(letterGuess.charAt(0));
      return word.contains(letterGuess);
    }

    // Print the state of the word with user's guesses.
    static boolean printWordState(String word, List<Character> playerGuesses)
      throws InvalidCharacterException {
      int correctCount = 0;
      for (int i = 0; i < word.length(); i++) {
        if (playerGuesses.contains(word.charAt(i))) {
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

  

