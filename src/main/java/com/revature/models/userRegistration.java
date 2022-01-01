

package com.revature.models;

import java.util.Scanner;

import com.revature.services.UserService;

public class userRegistration  {
	



   //collect the username, password and role of new user while the database table will assign a user id
	
   public void registerNewUsers() {
	      UserService newUsrService = new UserService();

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


      System.out.println("Select  Role ID: ");
      System.out.println("1 for employee");

      int roleId = newUserSc.nextInt();
    //  newUserSc.close();
      //  generate new user object
String role = "";
      switch(roleId) {
      case 1:role = "Employee";
      case 2: role = "Finance_Manager";	  
      }
    //  System.out.println("newUser");
	  User newUser = new User( username, password, firstname, lastname, email, roleId, address, userId);

      //create a new user for the service layer
      
      newUsrService.getUserRegistration(newUser);
      newUsrService.registerNewUsers(newUser, userId, role);
      
	}catch(Exception e) {
		System.out.println("there is an error");
		e.printStackTrace();
	}

   }

   
}


//+------------------------------------------------------------------+
