package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
  private static final String DOWNLOAD_FOLDER = "./";

  public static void downloadStatusImage(int code) {
    try {
      String imageUrl = HttpStatusChecker.getStatusImage(code);
      if (imageUrl != null) {
        downloadImage(imageUrl, code);
        System.out.println("Image downloaded successfully.");
      } else {
        throw new Exception("Image not found for status code: " + code);
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

  private static void downloadImage(String imageUrl, int code) throws IOException {
    URL url = new URL(imageUrl);
    HttpURLConnection connectio = (HttpURLConnection) url.openConnection();

    try (InputStream inputStream = connectio.getInputStream();
         FileOutputStream fileOutputStream = new FileOutputStream(DOWNLOAD_FOLDER + "image_" + code + ".jpg")) {

      byte[] buffer = new byte[1024];
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        fileOutputStream.write(buffer, 0, bytesRead);
      }
    }
  }
}
