package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

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

}
