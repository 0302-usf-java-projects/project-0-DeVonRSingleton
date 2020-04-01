package com.revature.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidBalanceException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import static com.revature.service.AccountFunctionality.*;

public class FeaturesMenu  {
private static Scanner sc = new Scanner(System.in);

public static int featuresMenu()throws InvalidOpeningBalanceException,PasswordNotLongEnoughException,DuplicateUsernameException,InputMismatchException {
  System.out.println("Thank you for signing in.");
  System.out.println("Choose from an option below to continue: \n0 : To exit \n1 : View Balance \n2 : Withdrawal\n3 : Deposit \n4: Go back to main menu");
  String userOption = sc.nextLine();
  switch(userOption) {
    case "1" : 
      viewBalance();
      return 1;
    case "2" :
      System.out.println("Withdrawal: Please enter how much money in numeric form you want to withdrawal");
      Double withDrawalAmount = sc.nextDouble();
      try {
        withdrawal(withDrawalAmount);
      } catch (InvalidBalanceException e) {
        System.out.println("Returning you to main menu your balance is too low.");
        MainMenu.mainMenu();
      }
      return 1;
    case "3" :
      System.out.println("Depositing: Please enter how much money in numeric form you want to deposit");
      Double depositAmount = sc.nextDouble();
      deposit(depositAmount);
      
    case "4" :
      
      MainMenu.mainMenu();
      return 1;
    case "0":
        System.exit(0);
      return  0;
    default:
      System.out.println("Failed to recognized option.");
      return 1;
  }
}

}