package com.revature.service;

import java.util.HashSet;


import java.util.Scanner;
import java.util.Set;
import com.revature.Main;
import com.revature.controller.MainMenu;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import com.revature.model.Account;
import com.revature.repository.PreparedStatements;

public class AccountCreation {
  public static Scanner sc = new Scanner(System.in);
  public static Set<Account> accounts = new HashSet<Account>();
  public static Set<String> usernames = new HashSet<String>();
  public static Set<Account> employeeAccounts = new HashSet<Account>();
  public static String accountAllowedCreation = "false";

  public static void createAnAccount() throws DuplicateUsernameException, PasswordNotLongEnoughException, InvalidOpeningBalanceException  {
   Main.logger.info("Asking for account info");
 System.out.println("\nWe're creating accounts so welcome!!!");
    int createRetrycount = 0;
    while (createRetrycount < 5) {
      System.out.println("Please provide a username.");
      String username = sc.nextLine();
      System.out.println(username);
      System.out.println("Provide a password.");
      String password = sc.nextLine();
      System.out.println(password);
      System.out.println("Provide a name for account.");
      String accountName = sc.nextLine();
      System.out.println(accountName);
      System.out.println("Provide a opening balance .");
      String balance = sc.nextLine();



      System.out.println(balance);
      System.out.println("Is "
          + "the account allowed to be created: True or False ");
      accountAllowedCreation = sc.nextLine().toUpperCase();
      System.out.println(accountAllowedCreation);

      if (accountAllowedCreation.equals("TRUE")) {
        
        try {
      Account  account = new Account(username, password, accountName, balance);
          accounts.add(account);
          usernames.add(username);
          PreparedStatements ppe = new PreparedStatements();
          ppe.insertAccount(account);
        } catch (PasswordNotLongEnoughException e) {
          Main.logger.error("this is an error message");
          System.out.println("Password Requires 8 characters: You did not provide enough characters for password .");
          createRetrycount++;
        } catch (DuplicateUsernameException e) {
          System.out.println("The username is already in the system provide a new username.");
          createRetrycount++;
        } catch (InvalidOpeningBalanceException e) {
          System.out.println("Balance can only be numeric or have two digits after the decimal");
        }

//        break;
      } else if (accountAllowedCreation.equals("FALSE")) {
        System.out.println("Account couldnt be created because the employee denied it.");
      }else {System.out.println("employee made an error");}
      break;
    }
    if (createRetrycount >= 5) {
      System.out.println("You're now exiting");
      MainMenu.mainMenu();


    }
  }
}


