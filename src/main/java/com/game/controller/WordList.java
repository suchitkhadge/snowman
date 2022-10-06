package com.game.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public abstract class WordList {


  public static final String SPORTS_ROOT_DIRECTORY = "src/main/resources/text-files/sports_words.txt";
  public static final String MOVIES_ROOT_DIRECTORY = "src/main/resources/text-files/movies_words.txt";
  public static final String GEOGRAPHY_ROOT_DIRECTORY = "src/main/resources/text-files/geography_words.txt";
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
    Scanner category = null;

    List<String> genericWords = new ArrayList<>();
    List<Character> playerGuessWord = new ArrayList<>();
    Set<String> usedCharacterSet = new HashSet<>();

    String chooseCategory = keyboard.nextLine();

    // Loop until the user exits out
    while (!chooseCategory.equals("1") && !chooseCategory.equals("2")&& !chooseCategory.equals("3")&& !chooseCategory.equals("4"))
    {
      System.out.println("Please choose a valid category ( 1- 4). ");
      chooseCategory = keyboard.nextLine();
    }
    // If statement for correct input from user
    switch (chooseCategory) {
      case "1":
        System.out.println(" You have chosen Sports as a category");
        category = scannerSports;
        break;
      case "2":
        System.out.println(" You have chosen Movies as a category");
        category = scannerMovies;
        break;
      case "3":
        System.out.println(" You have chosen Geography as a category");
        category = scannerGeography;
        break;
      case EXIT:
        System.out.println(" You have exited the game. ");

        break;
      default:
        throw new IllegalArgumentException(" Invalid number. Please enter again: ");
        //System.out.println("out of bounds");
    }

    copyWordToList(category, genericWords);
    guessWord = getRandomWord(category, genericWords);
    System.out.println(guessWord);


    int wrongCount = 0;

    while (!chooseCategory.equals(EXIT)) {

      //printSnowman method
      SnowmanPicture.printSnowman(wrongCount);

      if (wrongCount >= 10) {
        System.out.println("You lose!");
        System.out.println("The word was: " + guessWord);
        break;
      }

      if (State.checkSolution(guessWord, playerGuessWord)) {
        System.out.println("You win!");
        break;
      }

      System.out.println("**********************************");
      System.out.println("Guesses left: " + (10 - wrongCount));
      if (!Guesses.getPlayerGuess(keyboard, guessWord, playerGuessWord, usedCharacterSet)) {
        wrongCount++;
        System.out.println("Sorry try again!");
        System.out.println("**********************************");
      }
    }
  }

  // Generate a random word from the category of text files
  private static void copyWordToList(Scanner category, List<String> genericWords) {
    while (category.hasNext()) {
      genericWords.add(category.next());
    }
    guessWord = genericWords.get(new Random().nextInt(genericWords.size()));
  }

  private static String getRandomWord(Scanner category, List<String> listWords ){
    guessWord = listWords.get(new Random().nextInt(listWords.size()));
    return guessWord;
  }

}