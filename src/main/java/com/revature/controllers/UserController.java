package com.revature.controllers;

import java.util.List;
import java.util.Objects;

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

	public Handler getUserbyUsernamesHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			 String Username = Objects.requireNonNull(ctx.pathParam("ers_username"));

			List<User> allUsers = us.getByUserName(Username);
			
			Gson gson = new Gson();
			
			String JSONUsers = gson.toJson(allUsers);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler getUsernamesHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			 String Username = Objects.requireNonNull(ctx.pathParam("ers_username"));

			String UserN = us.getByUserNameAU(Username);
			
			Gson gson = new Gson();
			
			String JSONUsers = gson.toJson(UserN);
			
			ctx.result(JSONUsers);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler getPasswordHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { //if the session exist
			
			 String Password = Objects.requireNonNull(ctx.pathParam("ers_password"));

			String passW = us.getByPasswordAU(Password);
			
			Gson gson = new Gson();
			
			String JSONUsers = gson.toJson(passW);
			
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