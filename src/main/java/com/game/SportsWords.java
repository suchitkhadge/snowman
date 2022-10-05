package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class SportsWords extends WordList{
  String guessWord;


  public static void SportsWords() throws FileNotFoundException {
    Scanner scannerSports = new Scanner(new File(
        "src/main/text-files/sports_words.txt"));

  }
}
