package com.game;

public class SnowmanPicture {

  public static void main(String[] args) {
    System.out.println("_________________");
    System.out.println("      |   ");
    System.out.print("*");
    System.out.println("     |\"\"|");
    System.out.println("      ('>')");
    System.out.print("*");
    System.out.print("  \\");
    System.out.print("(   :   )");
    System.out.print("/");
    System.out.print("      *");
    System.out.println("\n (      :      )");
  }

  //  private static void printHangedMan(Integer wrongCount) {
//    if (wrongCount >= 1) {
//      System.out.println("_________________");
//    }
//
//    if (wrongCount >= 2) {
//      System.out.println("      |   ");
//      if (wrongCount >= 3) {
//        System.out.print("*");
//      } else {
//        System.out.println("");
//      }
//    }
//
//    if (wrongCount >= 4) {
//      System.out.println("    |\"\"|");
//    }
//
//    if (wrongCount >= 5) {
//      System.out.println("     ('>')");
//      if (wrongCount >= 6) {
//        System.out.print("  \\");
//      } else {
//        System.out.println("");
//      }
//    }
//
//    if (wrongCount >= 7) {
//      System.out.print("(   :   )");
//      if (wrongCount >= 8) {
//        System.out.print("/");
//        if (wrongCount >=9) {
//          System.out.print("      *");
//          if (wrongCount >=10) {
//            System.out.println("\n(      :      )");
//            // should print this :
//            // System.out.println("_________________");
//            //    System.out.println("      |   ");
//            //    System.out.print("*");
//            //    System.out.println("    |\"\"|");
//            //    System.out.println("     ('>')");
//            //    System.out.print("  \\");
//            //    System.out.print("(   :   )");
//            //    System.out.print("/");
//            //    System.out.print("      *");
//            //    System.out.println("\n(      :      )");
//          }
//        }
//      }
//    }
//  }

  //wrongCount is how many lives are left.
  public static void printHangedMan(Integer wrongCount) {
    if (wrongCount == 10) {
      System.out.println("_________________");
    } else if (wrongCount == 9) {
      System.out.println("_________________");
      System.out.println("      |   ");
    } else if (wrongCount == 8) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
    } else if (wrongCount == 7) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
    } else if (wrongCount == 6) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
    } else if (wrongCount == 5) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
    } else if (wrongCount == 4) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
    } else if (wrongCount == 3) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
    } else if (wrongCount == 2) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.print("/");
    } else if (wrongCount == 1) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.print("/");
      System.out.print("      *");
    } else if (wrongCount == 0) {
      System.out.println("_________________");
      System.out.println("      |   ");
      System.out.print("*");
      System.out.println("    |\"\"|");
      System.out.println("      ('>')");
      System.out.print("*");
      System.out.print("  \\");
      System.out.print("(   :   )");
      System.out.print("/");
      System.out.print("      *");
      System.out.println("\n (      :      )");
    }
  }
}
