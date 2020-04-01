package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import com.revature.model.Account;

public class PreparedStatements {

  public List<Account> getAllAccounts() throws DuplicateUsernameException, PasswordNotLongEnoughException, InvalidOpeningBalanceException {
    try(Connection conn = ConnectionUtil.connect()){
     String sql = " select * from accounts";
     PreparedStatement ps = conn.prepareStatement(sql);
     ResultSet rs = ps.executeQuery();
     List<Account> list = new ArrayList<>();
     while(rs.next()) {
       list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
     }
     rs.close();
     ps.close();
     return list;
    }catch(SQLException e) {
//      e.printStackTrace();
    }
    return null;
  }
  
  public  void insertAccount(Account a) {
    try(Connection conn = ConnectionUtil.connect()){
      String sql = "insert into public.accounts values(?,?,?,?)";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, a.getUsername());
      ps.setString(2, a.getPassword());
      ps.setString(3, a.getAccountName());
      ps.setString(4, a.getBalance());
      ps.execute();
      ps.close();
      
    }catch(SQLException e) {
      e.printStackTrace();
    }
  }
  
  public int updateBalance(String username , String balance) {
    
    try(Connection conn = ConnectionUtil.connect()){
      String sql = "update accounts set balance = ? where username = ? ";
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, username);
      ps.setString(2, balance);
      int updated = ps.executeUpdate();
      ps.close();
      return updated;
    }catch(SQLException e) {
      e.printStackTrace();
    }
    
    return -1;
  }  
  
}
