package com.revature.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileConfig {

  private static String url ;
  private static String username;
  private static String password;
  
  static {
    try {
      FileInputStream file = new FileInputStream("src/main/resources/connection.properties");
      Properties property = new Properties();
      property.load(file);
      username = property.getProperty("username");
      password = property.getProperty("password");
      url = property.getProperty("url");
      file.close();
    }catch(IOException e) {
      e.printStackTrace();
    }
    
    
  }

  public static String getUrl() {
    return url;
  }

  
  public static String getUsername() {
    return username;
  }

    public static String getPassword() {
    return password;
  }

  
  
  
}
