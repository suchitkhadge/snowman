package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SnowManClient {


  public static void main(String[] args) throws FileNotFoundException, InvalidCharacterException {

    //Scan the word list file
    Scanner scannerSports = new Scanner(new File(
        "SportsWords.txt "));
    Scanner scannerMovies = new Scanner(new File(
        "MoviesWords.txt "));
    Scanner scannerGeography = new Scanner(new File(
        "GeographyWords.txt "));
    Scanner keyboard = new Scanner(System.in);
    Menu menu = new Menu();
    String guessWord = " ";

    //Store it in the array list
    List<String> sportsWords = new ArrayList<>();
    List<String> moviesWords = new ArrayList<>();
    List<String> geographyWords = new ArrayList<>();
    List<Character> playerGuessWord = new ArrayList<>();
    Set<String> usedCharacterSet = new HashSet<>();
    Integer count = 0;


    // User display Main menu category
    menu.printMenu();
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
    if (chooseCategory.equals("2")) {
      System.out.println(" You have chosen Movies as a category");
      while (scannerMovies.hasNext()) {
        System.out.println(scannerMovies.nextLine());
        moviesWords.add(scannerMovies.next());
        guessWord = moviesWords.get(new Random().nextInt(moviesWords.size()));
        System.out.println(moviesWords);

      }
    }
    if (chooseCategory.equals("3")) {
      System.out.println(" You have chosen Geogrpahy as a category");
      while (scannerGeography.hasNext()) {
        System.out.println(scannerGeography.nextLine());
        geographyWords.add(scannerGeography.next());
        guessWord = geographyWords.get(new Random().nextInt(geographyWords.size()));
        System.out.println(geographyWords);

      }
    }
      else if (chooseCategory.equals("4")){
        System.out.println(" You have exited the game. ");


      }


    System.out.println(guessWord);

    // Show it to the player
    Integer wrongCount = 0;

    while (true) {

      if (wrongCount >= 10) {
        System.out.println("You lose!");
        System.out.println("The word was: " + guessWord );
        break;
      }

      if (printWordState(guessWord, playerGuessWord)) {
        System.out.println("You win!");
        break;
      }


        System.out.println(" Guesses left: " + (10 - wrongCount));
      if (!getPlayerGuess(keyboard, guessWord, playerGuessWord, usedCharacterSet)) {
        wrongCount++;
        System.out.println("Sorry try again!");

      }

    }
  }


  private static boolean getPlayerGuess(Scanner keyboard, String word,
      List<Character> playerGuesses, Set<String> usedCharacterSet) throws InvalidCharacterException {
    System.out.println("**********************************");
    System.out.println("Please enter a letter:");
    String letterGuess = keyboard.nextLine();
    usedCharacterSet.add(letterGuess);
    System.out.println(usedCharacterSet);
    playerGuesses.add(letterGuess.charAt(0));
    return word.contains(letterGuess);
  }


  // Print the state of the word with user's guesses.
  private static boolean printWordState(String word, List<Character> playerGuesses)
      throws InvalidCharacterException{
    int correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (playerGuesses.contains(word.charAt(i))) {
        System.out.print(word.charAt(i));
        correctCount++;
      } else {
        System.out.print(" _ ");
      }
    }
    System.out.println();

    return (word.length() == correctCount);
  }
}

  

