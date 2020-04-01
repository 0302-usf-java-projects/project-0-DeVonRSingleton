package com.revature.controller;

import java.util.Scanner;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import com.revature.model.Account;
import com.revature.repository.PreparedStatements;
import com.revature.service.AccountCreation;
import static com.revature.service.AccountFunctionality.*;

public class MainMenu {
  private static Scanner sc = new Scanner(System.in);
  public static int mainMenu()   {
    System.out.println("Welcome to the banking app");
    System.out.println("Please select one of the options provided in the menu: ");
    System.out.println("1 : Create an Account \n2 : Login to an account\n3 : Type accounts to view all accounts.\n0 : to exit: ");
   
  String  mainMenuChoice = sc.nextLine();
    
    switch(mainMenuChoice) {
      case "1" :
        System.out.println("You chose to create a new account\n");
        try {
          AccountCreation.createAnAccount();
        } catch (DuplicateUsernameException | PasswordNotLongEnoughException
            | InvalidOpeningBalanceException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return 1;
      case "2" :
        System.out.println("You have decided to login");
        try {
          runLogin();
        } catch (DuplicateUsernameException | PasswordNotLongEnoughException
            | InvalidOpeningBalanceException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return 1;
        
      case "accounts":
        PreparedStatements ppe = new PreparedStatements();
        try {
          System.out.println(ppe.getAllAccounts());
        } catch (DuplicateUsernameException | PasswordNotLongEnoughException
            | InvalidOpeningBalanceException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        return 1;
      case "0" :
        System.out.println("You have decided to exit the program.");
        return 0;
        default:
          System.out.println("Choose one of the options listed");
          
          return 1;
    }
  }

}
