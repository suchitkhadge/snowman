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
        "SportsWords.txt"));
    Scanner scannerMovies = new Scanner(new File(
        "MoviesWords.txt"));
    Scanner scannerGeography = new Scanner(new File(
        "GeographyWords.txt"));
    Scanner keyboard = new Scanner(System.in);
    //Menu menu = new Menu();

    String guessWord = " ";

    List<String> sportsWords = new ArrayList<>();
    List<String> moviesWords = new ArrayList<>();
    List<String> geographyWords = new ArrayList<>();
    List<Character> playerGuessWord = new ArrayList<>();
    Set<String> usedCharacterSet = new HashSet<>();

    Integer count = 0;

    // User display Main menu category
    //menu.printMenu();
    String chooseCategory = keyboard.nextLine();
    if (chooseCategory.equals("1")) {
      System.out.println(" You have chosen Sports as a category");
      while (scannerSports.hasNext()) {
        System.out.println(scannerSports.nextLine());
        sportsWords.add(scannerSports.next());
        guessWord = sportsWords.get(new Random().nextInt(sportsWords.size()));
        System.out.println(sportsWords);

      }

    }
    else if (chooseCategory.equals("2")) {
      System.out.println(" You have chosen Movies as a category");
      while (scannerMovies.hasNext()) {
        System.out.println(scannerMovies.nextLine());
        moviesWords.add(scannerMovies.next());
        guessWord = moviesWords.get(new Random().nextInt(moviesWords.size()));
        System.out.println(moviesWords);

      }
    }
    else if (chooseCategory.equals("3")) {
      System.out.println(" You have chosen Geogrpahy as a category");
      while (scannerGeography.hasNext()) {
        System.out.println(scannerGeography.nextLine());
        geographyWords.add(scannerGeography.next());
        guessWord = geographyWords.get(new Random().nextInt(geographyWords.size()));
        System.out.println(geographyWords);

      }
    } else if (chooseCategory.equals("4")) {
      System.out.println(" You have exited the game. ");


    } else {
      throw new IllegalArgumentException();
      //System.out.println("out of bounds");
    }

    System.out.println(guessWord);

    // Show it to the player
    Integer wrongCount = 0;

    while (true) {

      //printSnowman method
      SnowManClient.printSnowman(wrongCount);

      if (wrongCount >= 10) {
        System.out.println("You lose!");
        System.out.println("The word was: " + guessWord);
        break;
      }

      if (SnowManClient.printWordState(guessWord, playerGuessWord)) {
        System.out.println("You win!");
        break;
      }

      System.out.println(" Guesses left: " + (10 - wrongCount));
      if (!SnowManClient.getPlayerGuess(keyboard, guessWord, playerGuessWord, usedCharacterSet)) {
        wrongCount++;
        System.out.println("Sorry try again!");

      }

    }
  }

}