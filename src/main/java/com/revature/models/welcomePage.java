
package com.revature.models;

import java.util.Scanner;
import com.revature.repositories.UserDAO;


public class welcomePage {

   Scanner newWelcSc = new Scanner(System.in);
   userReimbursement newRE = new userReimbursement();
   userRegistration newUser = new userRegistration();
   UserDAO newSearch = new UserDAO();

   userReimbursement newRest2 = new userReimbursement();
   reimbursementOptions newCheck = new reimbursementOptions();

   
   
   public void welcom() {
	   
	   
	   while(true) {

      System.out.println("*******DUSTY CRUMBS*******");
      System.out.println("**************************");
      System.out.println("         WELCOME          ");
      System.out.println("**************************");

      System.out.println("Select");
      System.out.println("1: New User");
      System.out.println("2: Returning User");
      int choice = newWelcSc.nextInt();


      switch(choice) {
      case 1: {
         System.out.println("Enter login Details");
         System.out.println("   and Biodata");

         System.out.println("****************");

         newUser.registerNewUsers();
      }

      case 2: {
         System.out.println("****************");
         System.out.println("welcome back");
         
      }
      }
      System.out.println("You may login");
      System.out.println("****************");


      Scanner authSc = new Scanner(System.in);

      System.out.println("Enter Username:");
      String userinputU = authSc.nextLine();
          
      System.out.println("Enter password:");
      String userinputP = authSc.nextLine();

     String nameSearch = newSearch.authuenticateUser(userinputU, userinputP);
    
      System.out.println(nameSearch);

      if(nameSearch.toUpperCase().equals(userinputU.toUpperCase())) {
          System.out.println("****************");

  	  System.out.println(" Thanks for your patience, " + nameSearch );
      System.out.println("****************");
  	  System.out.println("You may proceed " + nameSearch );
      }
     
      String roleSearch =  newSearch.CheckUserRole(userinputU, userinputP);
      System.out.println(roleSearch);
      
    if(roleSearch.toUpperCase().equals("EMPLOYEE")) 
      //    if(roleSearch == 1)
    
    	newCheck.accessedByEmployee();
    	
     if(roleSearch.toUpperCase().equals("FIN_MNGR")) 
      //    if(roleSearch == 2)
  
    	newCheck.accessedByManager();
   	
      
      
      System.out.println("DO YOU NEED ANYMORE HELP? ");

      System.out.println("1: NO, THANKS");
      System.out.println("2: YES");
      
       int answer = newWelcSc.nextInt();
       
       switch(answer) {
       case 1: break;
       case 2: break;
       }
      
      
         if(nameSearch.equals(userinputU.toUpperCase()) == false) {

            System.out.println("User Details not found");
          
         }
         System.out.println("");

      }
   }
   }

   

//+------------------------------------------------------------------+2


//+------------------------------------------------------------------+

   //+------------------------------------------------------------------+
   
