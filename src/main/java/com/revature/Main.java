package com.revature;
import org.apache.log4j.Logger;

import com.revature.controller.Driver;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;

/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {
  public static final Logger logger = Logger.getLogger(Main.class);
  

	public static void main(String[] args) throws DuplicateUsernameException, PasswordNotLongEnoughException, InvalidOpeningBalanceException {
	   Driver.areWeLogin();
	   
	   
      
	   	   
	}
}
