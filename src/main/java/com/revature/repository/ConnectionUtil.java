package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.revature.repository.PlainTextConfig.*;

public class ConnectionUtil {

  public static Connection connect() throws SQLException{
    Connection conn = DriverManager.getConnection(url , username, password);
    return conn;
  }
}
