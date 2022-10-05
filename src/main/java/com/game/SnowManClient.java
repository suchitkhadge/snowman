package com.game;


import java.io.FileNotFoundException;


public class SnowManClient {


  public static void main(String[] args) throws FileNotFoundException, InvalidCharacterException {
    Menu menu = new Menu();

    menu.printMenu();
    WordList.words();

    SnowmanPicture.printSnowman(0);

  }


}

  

