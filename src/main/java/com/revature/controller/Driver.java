package com.revature.controller;


import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;

public class Driver {
  public static boolean LoggedIn = false;
  
    //PreparedStatements ppe = new PreparedStatements();
    //System.out.println(ppe.getAllAccounts());
   //
   // System.out.println(ppe.updateBalance(acc, "400.50"));     
  //MainMenu.mainMenu();
    //AccountSetup.createAnAccount();
 
  public static void areWeLogin()throws DuplicateUsernameException, PasswordNotLongEnoughException, InvalidOpeningBalanceException{
    while (!LoggedIn) {
  int welcomeMenuOutput = MainMenu.mainMenu();
//  System.out.println(welcomeMenuOutput);
  if (welcomeMenuOutput == 0) {
     System.exit(0);
  }
}

while (LoggedIn) {
  int menuOutput = FeaturesMenu.featuresMenu();
//System.out.println(menuOutput);
  if(menuOutput == 0) {
  System.exit(0);
  }
}
 
  }



  
  
}
