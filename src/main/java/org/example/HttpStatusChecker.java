package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;

public class HttpStatusChecker {
  public static String getStatusImage(int code) throws IOException {
    String imageUrl = "https://http.cat/" + code + ".jpg";
    URL url = new URL(imageUrl);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("HEAD");

    int responseCode = connection.getResponseCode();
    if (responseCode == 404) {
      throw new IOException("Image not found for status code " + code);
    }

    return imageUrl;

  }
}
