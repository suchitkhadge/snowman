package com.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public abstract class Menu {



     public static void printMenu() throws IOException {
       BufferedReader scannerSports = new BufferedReader(new FileReader(
           "src/main/text-files/snowman-menu.txt"));
       String line = scannerSports.readLine();
       while (scannerSports.readLine()!=null) {
         System.out.println(line);
         line = scannerSports.readLine();
       }
       scannerSports.close();

      System.out.println(" Choose a category: ");
      System.out.println("1. SPORTS");
      System.out.println("2. MOVIES");
      System.out.println("3. GEOGRAPHY");
      System.out.println("4. Exit");



  }



}
