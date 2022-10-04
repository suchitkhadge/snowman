package com.game;

public class InvalidCharacterException extends Exception {

  public InvalidCharacterException() {
  }

  public InvalidCharacterException(String message) {
    super(message);
  }

  public InvalidCharacterException(Throwable cause) {
    super(cause);
  }

  public InvalidCharacterException(String message, Throwable cause) {
    super(message, cause);
  }
}


