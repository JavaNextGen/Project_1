package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.AbstractUser;
import com.revature.models.User;
import com.revature.models.userRegistration;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {
	
	UserService us = new UserService();


	public Handler getUsersHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			List<User> allUsers = us.getNewUsers();
			
			Gson gson = new Gson();
			
			String JSONUsers = gson.toJson(allUsers);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	userRegistration newUsR = new userRegistration();
	
	public Handler insertUsersHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User newUser = gson.fromJson(body, User .class);
			
			AbstractUser newA = new AbstractUser();
			
			us.registerNewUsers(newUser,  newA, newUsR.userId, newUsR.role, newUsR.roleId );
			
			ctx.result("User was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert an users!!!!");
			ctx.status(404);
		}
		
		
	};
}