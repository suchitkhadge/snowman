package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeographyWords extends WordList {


  String guessWord;

  public GeographyWords(String guessWord) {
    super();
    this.guessWord = guessWord;
  }

  public String GeographyWords() throws FileNotFoundException {
    Scanner scannerGeography = new Scanner(new File(
        "SportsWords.txt "));
    List<String> geographyWords = new ArrayList<>();



    while (scannerGeography.hasNext()) {
      System.out.println(scannerGeography.nextLine());
      geographyWords.add(scannerGeography.next());
      guessWord = geographyWords.get(new Random().nextInt(geographyWords.size()));
      System.out.println(geographyWords);

    }
    return guessWord;
  }

}
