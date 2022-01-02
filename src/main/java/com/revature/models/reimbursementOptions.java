

package com.revature.models;

import java.util.Scanner;

import com.revature.repositories.UserDAO;

public class reimbursementOptions
{
   Scanner newWelcSc = new Scanner(System.in);
   userReimbursement newRE = new userReimbursement();
   userRegistration newUser = new userRegistration();
   UserDAO newSearch = new UserDAO();
Reimbursement neReim = new Reimbursement();
   userReimbursement newRest2 = new userReimbursement();


   public void accessedByManager()
   {
      System.out.println("SELECT FROM THE OPTIONS:");
      System.out.println("1: Apply for reimbursement");
      System.out.println("2: Check the status of your application");
      System.out.println("3: Approve Applications");
      System.out.println("****************");

      int choice2 = newWelcSc.nextInt();

      switch(choice2) {
      case 1: {
         System.out.println("Enter Request Details");
         System.out.println("****************");
         newRE.applyForReimbursement();
         break;
      }

      case 2: {
         System.out.println("****************");
         System.out.println("SELECT AN OPTION");
         System.out.println("1:Search by ID");
         System.out.println("2: Search by Status");
         System.out.println("3: Search by all entries");

         int choice3 = newWelcSc.nextInt();

         switch(choice3) {
         case 1: {
            System.out.println("Enter requestID:");
            int requestid = newWelcSc.nextInt();

            System.out.println( neReim.GetReimbursementsbyId(requestid));
            break;
         }
         case 2: {
            System.out.println("****************");
            System.out.println("SELECT AN OPTION");
            System.out.println("1: Pending");
            System.out.println("2: Denied");
            System.out.println("3:  Approved");

            int requeststatus = newWelcSc.nextInt();

            System.out.println( neReim.GetReimbursementsbyStatus(requeststatus ));
            break;
         }
         case 3: {
            System.out.println(neReim.GetReimbursementsAll());
            break;
         }
         }
      }

      case 3: {

      System.out.println(neReim.GetReimbursementsbyStatus(1));

      System.out.println("SELECT AN OPTION");
      System.out.println("1:  Pending");
      System.out.println("2: Denial");
      System.out.println("3: Approved");
      int decision = newWelcSc.nextInt();

      System.out.println("Enter request ID");
      int requestid = newWelcSc.nextInt();
      
 

      switch(decision) {
      case 1:
    	  neReim.UpdateRemRq("Approved",requestid, decision );
         break;
      case 2:
    	  neReim.UpdateRemRq("Denied",requestid, decision );
         break;
      case 3:

    	  neReim.UpdateRemRq("PENDING",requestid, decision );
         break;
      }
      break;
      }
      }
   }


   public void accessedByEmployee()
   {
      System.out.println("SELECT FROM THE OPTIONS:");
      System.out.println("1: Apply for reimbursement");
      System.out.println("2: Check the status of your application");
      System.out.println("****************");

      int choice2 = newWelcSc.nextInt();

      switch(choice2) {
      case 1: {
         System.out.println("Enter Request Details");
         System.out.println("****************");
         newRE.applyForReimbursement();
         break;
      }
      case 2: {
         System.out.println("****************");
         System.out.println("SELECT AN OPTION");
         System.out.println("1:Search by ID");
         System.out.println("2: Search by Status");
         System.out.println("3: Search by all entries");

         int choice3 = newWelcSc.nextInt();

         switch(choice3) {
         case 1: {
            System.out.println("ENTER REQUEST ID:");
            int requestid = newWelcSc.nextInt();

            System.out.println( neReim.GetReimbursementsbyId(requestid));
            break;
         }
         case 2: {
            System.out.println("****************");
            System.out.println("SELECT REIMBURSEMNT STATUS");
            System.out.println("1: Pending ");
            System.out.println("2: Denied");
            System.out.println("3: Approved ");

            int requeststatus = newWelcSc.nextInt();

           System.out.println( neReim.GetReimbursementsbyStatus(requeststatus));
            break;
         }
         case 3: {
            System.out.println(neReim.GetReimbursementsAll());
            break;
         }
         }
      }
break;

      }
   }

}
//+------------------------------------------------------------------+
