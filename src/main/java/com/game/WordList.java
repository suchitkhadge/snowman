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



  public static void words() throws FileNotFoundException, InvalidCharacterException {
    Scanner scannerSports = new Scanner(new File(
        "src/main/text-files/sports_words.txt"));
    Scanner scannerMovies = new Scanner(new File(
        "src/main/text-files/movies_words.txt"));
    Scanner scannerGeography = new Scanner(new File(
        "src/main/text-files/geography_words.txt"));
    Scanner keyboard = new Scanner(System.in);


    String guessWord = " ";

    List<String> sportsWords = new ArrayList<>();
    List<String> moviesWords = new ArrayList<>();
    List<String> geographyWords = new ArrayList<>();
    List<Character> playerGuessWord = new ArrayList<>();
    Set<String> usedCharacterSet = new HashSet<>();

    Integer count = 0;

    String chooseCategory = keyboard.nextLine();
    if (chooseCategory.equals("1")) {
      System.out.println(" You have chosen Sports as a category");
      while (scannerSports.hasNext()) {
        sportsWords.add(scannerSports.next());
        guessWord = sportsWords.get(new Random().nextInt(sportsWords.size()));
      }

    }
    else if (chooseCategory.equals("2")) {
      System.out.println(" You have chosen Movies as a category");
      while (scannerMovies.hasNext()) {
        moviesWords.add(scannerMovies.next());
        guessWord = moviesWords.get(new Random().nextInt(moviesWords.size()));
      }
    }
    else if (chooseCategory.equals("3")) {
      System.out.println(" You have chosen Geography as a category");
      while (scannerGeography.hasNext()) {
        geographyWords.add(scannerGeography.next());
        guessWord = geographyWords.get(new Random().nextInt(geographyWords.size()));
      }
    } else if (chooseCategory.equals("4")) {
      System.out.println(" You have exited the game. ");


    } else {
      //throw new IllegalArgumentException();
      System.out.println("Invalid number. Please choose between 1-4");
    }

    System.out.println(guessWord);

    // Show it to the player
    Integer wrongCount = 0;

    while (true) {

      //printSnowman method
      SnowmanPicture.printSnowman(wrongCount);

      if (wrongCount >= 10) {
        System.out.println("You lose!");
        System.out.println("The word was: " + guessWord);
        break;
      }

      if (State.printWordState(guessWord, playerGuessWord)) {
        System.out.println("You win!");
        break;
      }

      System.out.println(" Guesses left: " + (10 - wrongCount));
      if (!Guesses.getPlayerGuess(keyboard, guessWord, playerGuessWord, usedCharacterSet)) {
        wrongCount++;
        System.out.println("Sorry try again!");

      }

    }
  }

}