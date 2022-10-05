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

  public static String guessWord = " ";

  public static void words() throws FileNotFoundException, InvalidCharacterException {
    Scanner scannerSports = new Scanner(new File(
        "src/main/text-files/sports_words.txt"));
    Scanner scannerMovies = new Scanner(new File(
        "src/main/text-files/movies_words.txt"));
    Scanner scannerGeography = new Scanner(new File(
        "src/main/text-files/geography_words.txt"));
    Scanner keyboard = new Scanner(System.in);

    List<String> genericWords = new ArrayList<>();
    List<Character> playerGuessWord = new ArrayList<>();
    Set<String> usedCharacterSet = new HashSet<>();

    Integer count = 0;

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
    } else if (chooseCategory.equals("4")) {
      System.out.println(" You have exited the game. ");


    } else {
      throw new IllegalArgumentException();
      //System.out.println("out of bounds");
    }

    System.out.println(guessWord);

    // Show it to the player
    Integer wrongCount = 0;

    while (!chooseCategory.equals("4")) {

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

      System.out.println(" Guesses left: " + (10 - wrongCount));
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

  static boolean getPlayerGuess(Scanner keyboard, String word,
      List<Character> playerGuesses, Set<String> usedCharacterSet) throws
      InvalidCharacterException {
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
  public static String generateWord(String category, Scanner scan, List<String> wordScanText){
    String guessWord = "";
    while (scan.hasNext()) {
      System.out.println(scan.nextLine());
      wordScanText.add(scan.next());
      guessWord = wordScanText.get(new Random().nextInt(wordScanText.size()));
      System.out.println(wordScanText);
    }
    System.out.println(guessWord);
    return guessWord;

  }
}