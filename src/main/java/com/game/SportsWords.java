package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SportsWords extends WordList{
  String guessWord;


  public String SportsWords() throws FileNotFoundException {
    Scanner scannerSports = new Scanner(new File(
        "src/main/text-files/sports_words.txt"));
    List<String> sportsWords = new ArrayList<>();
    while (scannerSports.hasNext()) {
      System.out.println(scannerSports.nextLine());
      sportsWords.add(scannerSports.next());
      guessWord = sportsWords.get(new Random().nextInt(sportsWords.size()));
     System.out.println(sportsWords);

    }
    return guessWord;
  }
}
