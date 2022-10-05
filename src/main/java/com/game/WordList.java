package com.game;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public abstract class WordList {


  public static final String SPORTS_ROOT_DIRECTORY = "src/main/text-files/sports_words.txt";
  public static final String MOVIES_ROOT_DIRECTORY = "src/main/text-files/movies_words.txt";
  public static final String GEOGRAPHY_ROOT_DIRECTORY = "src/main/text-files/geography_words.txt";
  public static final String EXIT = "4";
  public static String guessWord = " ";

  public static void words() throws FileNotFoundException {
    Scanner scannerSports = new Scanner(new File(
        SPORTS_ROOT_DIRECTORY));
    Scanner scannerMovies = new Scanner(new File(
        MOVIES_ROOT_DIRECTORY));
    Scanner scannerGeography = new Scanner(new File(
        GEOGRAPHY_ROOT_DIRECTORY));
    Scanner keyboard = new Scanner(System.in);

    List<String> genericWords = new ArrayList<>();
    List<Character> playerGuessWord = new ArrayList<>();
    Set<String> usedCharacterSet = new HashSet<>();

    String chooseCategory = keyboard.nextLine();

    if (chooseCategory.equals("1")) {
      System.out.println(" You have chosen Sports as a category");
      generateWord(scannerSports, genericWords);
    }
    else if (chooseCategory.equals("2")) {
      System.out.println(" You have chosen Movies as a category");
      generateWord(scannerMovies, genericWords);
    }
    else if (chooseCategory.equals("3")) {
      System.out.println(" You have chosen Geography as a category");
      generateWord(scannerGeography, genericWords);
    } else if (chooseCategory.equals(EXIT)) {
      System.out.println(" You have exited the game. ");


    } else {
      throw new IllegalArgumentException(" Invalid number. Please enter again: ");
      //System.out.println("out of bounds");
    }

    System.out.println(guessWord);

    // Show it to the player
    int wrongCount = 0;

    while (!chooseCategory.equals(EXIT)) {

      //printSnowman method
      SnowmanPicture.printSnowman(wrongCount);

      if (wrongCount >= 10) {
        System.out.println("You lose!");
        System.out.println("The word was: " + guessWord);
        break;
      }

      if (Player.printWordState(guessWord, playerGuessWord)) {
        System.out.println("You win!");
        break;
      }

      System.out.println("**********************************");
      System.out.println("Guesses left: " + (10 - wrongCount));
      if (!Player.getPlayerGuess(keyboard, guessWord, playerGuessWord, usedCharacterSet)) {
        wrongCount++;
        System.out.println("Sorry try again!");
        System.out.println("**********************************");
      }
    }
  }

  private static void generateWord(Scanner scannerSports, List<String> sportsWords) {
    while (scannerSports.hasNext()) {
      sportsWords.add(scannerSports.next());
      guessWord = sportsWords.get(new Random().nextInt(sportsWords.size()));
    }
  }
}