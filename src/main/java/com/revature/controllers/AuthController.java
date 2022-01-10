package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	
	AuthService as = new AuthService();

	public Handler loginHandler = (ctx) -> {	
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
		
		if(as.login(LDTO.getUsername(), LDTO.getPassword())) {
			ctx.req.getSession(); 	
	
			ctx.status(202);
			ctx.result("Login Success!");
			
		} else {
			
			ctx.status(401); //"unauthorized" status code
			ctx.result("Login Failed! :(");
			
		}
		
	};

}
