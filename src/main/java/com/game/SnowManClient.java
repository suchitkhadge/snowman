package com.game;


import com.game.controller.Menu;
import com.game.controller.SnowmanPicture;
import com.game.controller.WordList;
import java.io.IOException;

/**
 * Entry point for initialization of the application
 */
public class SnowManClient {


  public SnowManClient() {
  }

  public static void main(String[] args){

    try {
      Menu.printMenu();
      WordList.words();
      SnowmanPicture.printSnowman(0);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}




  

