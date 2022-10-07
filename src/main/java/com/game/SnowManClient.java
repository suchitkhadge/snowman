package com.game;


import com.game.controller.Menu;
import com.game.controller.WordList;
import java.io.IOException;

/**
 * Main Client class that calls in other class to start the Snowman application, a word guessing
 * game with multiple categories of Geography, Sports and Movies.
 */
public class SnowManClient {


  public static void main(String[] args) {

    try {
      Menu.printMenu();
      WordList.words();


    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}




  

