package com.game.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Constructs the game menu along with the snowman picture at the launch of the application.
 */
public abstract class Menu {


  public static final String SNOWMAN_MENU = "src/main/resources/text-files/snowman-menu.txt";


  // Display the first screen when the app is launched
  public static void printMenu() throws IOException {

      printSnowManMenu();

      System.out.println(" Choose a category: ");
      System.out.println("1. SPORTS");
      System.out.println("2. MOVIES");
      System.out.println("3. GEOGRAPHY");
      System.out.println("4. Exit");
  }

  // Displays the snow man in the first screen
  private static void printSnowManMenu() {
    try {
      BufferedReader snowManText = new BufferedReader(new FileReader(
          SNOWMAN_MENU));
      String line = snowManText.readLine();
      while (snowManText.readLine()!=null) {
        System.out.println(line);
        line = snowManText.readLine();
      }
      snowManText.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
