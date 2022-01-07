package com.revature.models;

import java.util.Scanner;

import com.revature.repositories.UserDAO;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class userReimbursement {
	UserDAO newUDAO =new UserDAO();
	
	ReimbursementService newReS = new ReimbursementService();
	UserService newUs = new UserService();
	Reimbursement newRe = new Reimbursement();
	//apply for reimbursement : lodging, travel, food, other;
	
	public void applyForReimbursement() {
		Scanner newReimbSc = new Scanner(System.in);
		
		try {
		System.out.println("Enter username");
		String username = newReimbSc.nextLine();
		System.out.println("Enter Password");
		String password = newReimbSc.nextLine();
		int re_imb_auth = newUs.getUserRole(username, password);
		
		String username1 = newUDAO.authuenticateUser(username, password);
		int userid = newUDAO.getUserId(username, password);
		
		System.out.println("Select reimbursement type");
		System.out.println("1: lodging");
		System.out.println("2: Travel");
		System.out.println("3: Food");
		System.out.println("4: Other");
		
		int reimbId = newReimbSc.nextInt();
		
		System.out.println("Enter amount");
		double amount = newReimbSc.nextDouble();
		
		int reimbus_id = newReS.maximumReimbId() + 1;
		
		AbstractReimbursement newReqst = new AbstractReimbursement(amount, userid, reimbId, reimbus_id);
		newRe.insertRemRq(amount , userid,  reimbId , reimbus_id);

		//System.out.println( reimbId + " " +  Name  + " "+ amount);
		
	}catch(Exception e) {
		System.out.println("there is an error");
		e.printStackTrace();
	
	//:::::::::::::::::::::::::::	
	//:::::::::::::::::::::	
		
	}
}

	

	
}