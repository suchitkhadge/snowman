package com.game;
import java.io.IOException;


public class SnowManClient {


  public static void main(String[] args) throws IOException {

    try {
      Menu.printMenu();
      WordList.words();
      SnowmanPicture.printSnowman(0);

    } catch (IOException e)
    {
      e.printStackTrace();
    }

  }
  }

  

