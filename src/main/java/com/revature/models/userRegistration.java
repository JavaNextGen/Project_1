

package com.revature.models;

import java.util.Scanner;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

public class userRegistration  {
	



   //collect the username, password and role of new user while the database table will assign a user id
	
   public void registerNewUsers() throws NewUserHasNonZeroIdException{
	      UserDAO newUsrService = new UserDAO();

	try {  Scanner newUserSc = new Scanner(System.in);

      System.out.println("choose a username :");
      String username = newUserSc.nextLine();

      System.out.println("choose a password :");
      String password = newUserSc.nextLine();
      
      System.out.println("enter first name :");
      String firstname = newUserSc.nextLine();

      System.out.println("Enter last name :");
      String lastname = newUserSc.nextLine();

      System.out.println("Enter email address:");
      String rawEmail = newUserSc.nextLine();
      String email = "";
      
      String emailPattern = "^[a-zA-Z0-9_#$%&’*+/=?^.-]+(?:\\\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$\r\n";	
      if(rawEmail.matches(emailPattern)) {
    	  email = rawEmail;
      }
      else
    	  System.out.println("Wrong Email format");
     

      System.out.println("Enter address :");
      String address = newUserSc.nextLine();
     
      int userId = newUsrService.maximumUserId() + 1;
System.out.println("user id =: "+ userId);
System.out.println("****************************************************");


      System.out.println("Select  Role ID: ");
      System.out.println("1 for employee");
      System.out.println("2 for finance manager");

      int roleId = newUserSc.nextInt();
    //  newUserSc.close();
      //  generate new user object
String role = "";

      switch(roleId) {
      case 1:role = "Employee";
      case 2: role = "Fin_Mngr";
    	  
      }
    //  System.out.println("newUser");
	  User newUser = new User( username, password, firstname, lastname, email, userId, address, userId);
	  AbstractUser newUsA = new AbstractUser(username, password);

      //create a new user for the service layer
      
      newUsrService.getNewUsers();
      newUsrService.registerNewUsers(newUser, newUsA, userId, role);
      
	}catch(NewUserHasNonZeroIdException e) {
		throw new NewUserHasNonZeroIdException("Name does not exist");
	}

   }

   
}


//+------------------------------------------------------------------+
