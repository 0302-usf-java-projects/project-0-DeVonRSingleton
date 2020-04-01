package com.revature.service;

import com.revature.controller.Driver;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidBalanceException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import com.revature.model.Account;
import com.revature.repository.PreparedStatements;
import static com.revature.model.Account.*;

public class AccountFunctionality {
  public static void runLogin() throws DuplicateUsernameException, PasswordNotLongEnoughException, InvalidOpeningBalanceException{
    System.out.println("Please login. Provide username : ");
    usernameInput = sc.nextLine();
    System.out.println("Please provide your password ");
    String passwordInput = sc.nextLine();
    
   PreparedStatements ppe = new PreparedStatements();
  storedAccounts =  ppe.getAllAccounts();


    
   for(Account a: storedAccounts ) {
     
     if(a.authenticate(usernameInput, passwordInput)){
       Driver.LoggedIn = true;
     }
   }
   if (!Driver.LoggedIn) {
     System.out.println("Failed to log in with your username and password.");
   }
    }

  public static void viewBalance(){
    System.out.println("Your balance is : ");
    System.out.println(usrBalance);
    System.out.println("Thank you!!");
  }

  public static void withdrawal(Double withdrawalAmount) throws InvalidBalanceException {
    Double currentBalance = Double.parseDouble(usrBalance);
    if(currentBalance < withdrawalAmount) {
    
      throw new InvalidBalanceException();
      
    }else {
    String newBalance = String.format("%.2f", (currentBalance-withdrawalAmount));
    System.out.println("The withdrawal amount is: " + withdrawalAmount + " Bringing the new balance to : " + newBalance);
    usrBalance = (newBalance);
    
    
    }
  }

  public static void deposit(Double depositAmount) {
    
    Double currentBalance =  Double.parseDouble(usrBalance);
    String newBalance = String.format("%.2f", (currentBalance + depositAmount));
    System.out.println("The deposited amount is: " + depositAmount + " Bringing the new balance to : " + newBalance );
    usrBalance =  (newBalance) ;  
   PreparedStatements ppe = new PreparedStatements();
   System.out.println( usernameInput + usrBalance);
    ppe.updateBalance(usernameInput, usrBalance);
    

  }
}
