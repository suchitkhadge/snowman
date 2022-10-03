package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnowManClient {


    public static void main(String[] args) throws FileNotFoundException {

      //Scan the word list file
      Scanner scanner = new Scanner(new File(
          "C:\\Users\\skhadge\\Desktop\\Java\\Course Materials\\Java-Part2\\Snowman-Project\\wordlist.txt "));
      Scanner keyboard = new Scanner(System.in);
      Menu menu = new Menu();


      //Store it in the array list
      List<String> word = new ArrayList<>();

      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
        word.add(scanner.next());
      }
        System.out.println(word);

      // User display Main menu category
        menu.printMenu();
        String chooseCategory = keyboard.nextLine();
        if (chooseCategory == "1"){
          System.out.println(" You have chosen Sports as a category");
        } else{
          System.out.println(" You have chosen Movies as a category");
        }

        String guessWord = word.get(new Random().nextInt(word.size()));
        System.out.println(guessWord);

        // Show it to the player
      for(int i = 0; i < guessWord.length(); i++)
      {
        System.out.print(" _ ");
      }

      while(true) {
        System.out.println("\n Please enter a letter: ");
        List<Character> playerGuess = new ArrayList<>();

        String letterGuess = keyboard.nextLine();
        playerGuess.add(letterGuess.charAt(0));
        printWordState(guessWord, playerGuess);
      }
  }

  // Print the state of the word with user's guesses.
  private static boolean printWordState(String word, List<Character> playerGuesses) {
    int correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (playerGuesses.contains(word.charAt(i))) {
        System.out.print(word.charAt(i));
        correctCount++;
      }
      else {
        System.out.print("-");
      }
    }
    System.out.println();

    return (word.length() == correctCount);
  }
}
