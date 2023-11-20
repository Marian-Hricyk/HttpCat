package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
  public static void askStatus() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter HTTP status code: ");
    String input = scanner.nextLine();

    try {
      int statusCode = Integer.parseInt(input);
      processStatusCode(statusCode);
    } catch (NumberFormatException e) {
      System.out.println("Please enter a valid number.");
    }
  }

  private static void processStatusCode(int code) {
    try {
      HttpStatusImageDownloader.downloadStatusImage(code);
      System.out.println("Image downloaded successfully.");
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
