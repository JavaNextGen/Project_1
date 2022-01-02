package com.revature.models;

import java.util.Scanner;

import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class userReimbursement {
	
	ReimbursementService newReS = new ReimbursementService();
	UserService newUs = new UserService();
	//apply for reimbursement : lodging, travel, food, other;
	
	public void applyForReimbursement() {
		Scanner newReimbSc = new Scanner(System.in);
		
		try {
		System.out.println("Enter username");
		String username = newReimbSc.nextLine();
		System.out.println("Enter Password");
		String password = newReimbSc.nextLine();
		int re_imb_auth = newUs.getUserRole(username, password);
		
		System.out.println("Select reimbursement type");
		System.out.println("1: lodging");
		System.out.println("2: Travel");
		System.out.println("3: Food");
		System.out.println("4: Other");
		
		int reimbId = newReimbSc.nextInt();
		
		System.out.println("Enter amount");
		double amount = newReimbSc.nextDouble();
		
		int reimbus_id = newReS.maximumReimbId() + 1;
		
		Reimbursement newReqst = new Reimbursement();
		newReqst.insertRemRq(amount  , re_imb_auth,  reimbId , reimbus_id);

		//System.out.println( reimbId + " " +  Name  + " "+ amount);
		
	}catch(Exception e) {
		System.out.println("there is an error");
		e.printStackTrace();
	
	//:::::::::::::::::::::::::::	
	//:::::::::::::::::::::	
		
	}
}

	

	
}