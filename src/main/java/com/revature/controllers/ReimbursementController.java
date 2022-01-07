package com.revature.controllers;





import java.util.List;

import com.google.gson.Gson;
import com.revature.models.AbstractReimbursement;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();

	public Handler getReimbursementHandler = (ctx) -> {
		if(ctx.req.getSession() != null) { 
			
			List<AbstractReimbursement> allReimbursement = rs.GetReimbursementsAll();		
		
			Gson gson = new Gson();
		
			String JSONAbstractReimbursement = gson.toJson(allReimbursement);
			
		
			ctx.result(JSONAbstractReimbursement);
			ctx.status(200);
			

		} else {
			ctx.result("Oh no you failed to get the employees!!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertReimbursementHandler = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			AbstractReimbursement newAb = gson.fromJson(body, AbstractReimbursement .class);
			
			rs.insertRemRq(newAb);
			
			ctx.result("User was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to insert an users!!!!");
			ctx.status(404);
		}
		
		
	};
}