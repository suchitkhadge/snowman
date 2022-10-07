package com.game.controller;

/**
 * Implements the method used to print out segments of the snowman if a conditional statement
 * is found to be true.
 */
public abstract class SnowmanPicture {

  /**
   * This method is used to print out segments of the snowman if a conditional statement
   * is found to be true.
   * @param wrongCount used to hold the number of wrong number of guesses.
   */
  public static void printSnowman(Integer wrongCount) {
    if (wrongCount == 0) {
      System.out.println("");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 1) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 2) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 3) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("      |\"\"|");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 4) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 5) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 6) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 7) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 8) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.print("/");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 9) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.print("/");
      System.out.print("      *");
      System.out.println("");
      System.out.println("");
    }
    if (wrongCount == 10) {
      System.out.println("_________________");
      System.out.println("        |   ");
      System.out.print("* ");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.print("/");
      System.out.print("      *");
      System.out.println("\n (      :      )");
      System.out.println("");
      System.out.println("");
    }
  }

}
