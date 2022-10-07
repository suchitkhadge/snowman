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
      System.out.println("Please choose a valid category (1- 4). ");
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

    }
    // Scan the file from proper category and copy it to the list.
    copyWordToList(category, genericWords);

    // Generate a random word from the list and display it to the user.
    guessWord = getRandomWord( genericWords);
    System.out.println(guessWord);

    // Initialize the counter for wrong guesses.
    int wrongCount = 0;

    // while loop to go through the validation of whether the user is winning or losing.
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
      if (!Guesses.isGuessLetterInWord(keyboard, guessWord, playerGuessWord, usedCharacterSet)) {
        wrongCount++;
        System.out.println("Sorry try again!");
        System.out.println("**********************************");
      }
    }
  }

  // Copy word from the text files in to the list.
  private static void copyWordToList(Scanner category, List<String> genericWords) {
    while (category.hasNext()) {
      genericWords.add(category.next());
    }

  }
  // Generate a random word from the category of text files
  private static String getRandomWord(List<String> listWords ){
    guessWord = listWords.get(new Random().nextInt(listWords.size()));
    return guessWord;
  }

}