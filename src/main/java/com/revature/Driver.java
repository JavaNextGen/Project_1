package com.revature;

import java.security.AccessController;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;
import com.revature.models.welcomePage;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Driver {

    public static void main(String[] args) {
    	
   /* 
     	try (
        Connection conn = ConnectionFactory.getConnection()){
			System.out.println("You did the connection thing. Good job, here's a cookie!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("OoOoOf. That Connection ain't happening, you done screwed up!");
		}
    	 
    	welcomePage newWelP = new welcomePage();
    	newWelP.welcom();
    	
    
    	UserController ec = new UserController();
	
    	*/
    	
		//Testing Database Connectivity - just testing whether our Connection (from ConnectionFactory) is successful
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
    	UserController uc = new UserController();
    ReimbursementController rc = new ReimbursementController();
	AuthController ac = new AuthController();


		
		Javalin app = Javalin.create(
					config -> {
						config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
					}
				).start(3004);
		
		app.get("/user", uc.getUsersHandler);
		app.get("/usern/{ers_username}", uc.getUsernamesHandler);
	
		app.get("/userp/{ers_password}", uc.getPasswordHandler);
		
		
		app.post("/userinsert", uc.insertUsersHandler);
		
		app.get("/Reimbursement", rc.getReimbursementHandler);
		app.get("/Reimbursement/{reimb_status_id}", rc.ReimbursementbyStatusIdntroller);
		
		app.post("/Reimbursementinsert", rc.insertReimbursementHandler);
		
		
		
		app.get("/ReimByType", rc.getReimbursementHandler);
		
		
		app.get("/login/{ers_username}/{ers_password}", ac.loginHandler);
		
		
		}
}

		
    

















