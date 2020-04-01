package com.revature.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import static com.revature.service.AccountCreation.*;

public class Account {
private String username;
private String password;
private String accountName;
private String balance;
static String mainMenuChoice ;
public static String usrBalance;
public static Scanner sc = new Scanner(System.in);
public static String usernameInput;
private static final int REQUIRED_PASSWORD_LENGTH = 8;
public static List<Account> storedAccounts = new ArrayList<Account>();


public Account(String username, String password,String accountName, String balance) throws DuplicateUsernameException,PasswordNotLongEnoughException,InvalidOpeningBalanceException{
  super();
  this.setAccountName(accountName);
  this.setUsername(username);
  this.setPassword(password);
  this.setBalance(balance);
}

public boolean authenticate(String username, String password) {
  return (username.equals(this.username)) && (password.equals(this.password));
}



public String getUsername() {
  return username;
}

public void setUsername(String username)throws DuplicateUsernameException {

  if( usernames.contains((username))) {
   
   }else {
    this.username = username;
  }
}

public String getPassword() {
  return password;
}
public void setPassword(String password) throws PasswordNotLongEnoughException{
  if(password.length() < REQUIRED_PASSWORD_LENGTH) {
    throw new PasswordNotLongEnoughException();
    }
    {
      this.password = password;
    }}

public String getAccountName() {
  return accountName;
}
public void setAccountName(String accountName) {
  
  this.accountName = accountName;
}

public String getBalance() {
  return balance;
}

public void setBalance(String balance)  {
  //if(balance == format)){
    this.balance = balance;
    this.usrBalance = balance;    ;
  }//else {
  //throw new InvalidOpeningBalanceException();
 // }
  //}


//public static void runLogin() throws DuplicateUsernameException, PasswordNotLongEnoughException, InvalidOpeningBalanceException{
//  System.out.println("Please login. Provide username : ");
//  usernameInput = sc.nextLine();
//  System.out.println("Please provide your password ");
//  String passwordInput = sc.nextLine();
//  
// PreparedStatements ppe = new PreparedStatements();
//storedAccounts =  ppe.getAllAccounts();
//
//
//  
// for(Account a: storedAccounts ) {
//   System.out.println(a);
//   if(a.authenticate(usernameInput, passwordInput)){
//     Driver.LoggedIn = true;
//   }
// }
// if (!Driver.LoggedIn) {
//   System.out.println("Failed to log in with your username and password.");
// }
//  }
//
//public static void viewBalance(){
//  System.out.println("Your balance is : ");
//  System.out.println(usrBalance);
//  System.out.println("Thank you!!");
//}
//
//public static void withdrawal(Double withdrawalAmount) throws InvalidBalanceException {
//  Double currentBalance = Double.parseDouble(usrBalance);
//  if(currentBalance < withdrawalAmount) {
//  
//    throw new InvalidBalanceException();
//    
//  }else {
//  String newBalance = String.format("%.2f", (currentBalance-withdrawalAmount));
//  System.out.println("The withdrawal amount is: " + withdrawalAmount + " Bringing the new balance to : " + newBalance);
//  usrBalance = (newBalance);
//  
//  
//  }
//}
//
//public static void deposit(Double depositAmount) {
//  
//  Double currentBalance =  Double.parseDouble(usrBalance);
//  String newBalance = String.format("%.2f", (currentBalance + depositAmount));
//  System.out.println("The deposited amount is: " + depositAmount + " Bringing the new balance to : " + newBalance );
//  usrBalance =  (newBalance) ;  
// PreparedStatements ppe = new PreparedStatements();
// System.out.println( usernameInput + usrBalance);
//  ppe.updateBalance("usernameInput", "usrBalance");
//  
//
//}

@Override
public String toString() {
  return "username=" + username + " , accountName="
      + accountName + ", balance=" + balance ;
}
  


}
