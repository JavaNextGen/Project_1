package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.AbstractReimbursement;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class AuthorizationController {
	
	AuthService as = new AuthService();

	public Handler loginHandler = (ctx) -> {
		
		
		String body = ctx.body();
		Gson gson = new Gson(); 
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		
		if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
		
			ctx.req.getSession(); 
			
			
			ctx.status(202); 
			
		
			ctx.result("Login Success!");
			
		} else {
			
			ctx.status(401); 
			ctx.result("Login Failed! :(");
			
		}
		
	};
	
	public String username ="";
	public String password ="";
	
	UserService us = new UserService();
	
	public Handler getUsernametHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { 
			
			String storedUsername = us.getUserId(username, password);
		
			Gson gson = new Gson();
		
			String JSONUserName = gson.toJson(storedUsername);
			
		
			ctx.result(JSONUserName);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	

}
