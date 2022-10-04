package com.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MoviesWords extends WordList{

  public MoviesWords(String guessWord) {
    this.guessWord = guessWord;
  }

  String guessWord;

  public String MoviesWords() throws FileNotFoundException {
    Scanner scannerMovies = new Scanner(new File(
        "src/main/text-files/movies_words.txt"));
    List<String> moviesWords = new ArrayList<>();
    while (scannerMovies.hasNext()) {
      System.out.println(scannerMovies.nextLine());
      moviesWords.add(scannerMovies.next());
      guessWord = moviesWords.get(new Random().nextInt(moviesWords.size()));
      System.out.println(moviesWords);

    }
    return guessWord;
  }
}
