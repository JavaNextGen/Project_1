package com.revature.controllers;

import java.util.Objects;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	
	AuthService as = new AuthService();

	public Handler loginHandler = (ctx) -> {	
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		LoginDTO LDTO1 = new LoginDTO();
		
		
		 String Username = Objects.requireNonNull(ctx.pathParam("ers_username"));
		 String Password = Objects.requireNonNull(ctx.pathParam("ers_password"));
		 
		 LDTO1.setUsername(Username);
		 LDTO1.setPassword(Password);
		 
		 
		Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
		
		if(as.login(LDTO.getUsername(), LDTO.getPassword(), Username, Password)) {
			ctx.req.getSession(); 	
	
			ctx.status(202);
			ctx.result("Login Success!");
			
		} else {
			
			ctx.status(401); //"unauthorized" status code
			ctx.result("Login Failed! :(");
			
		}
		
	};

}
