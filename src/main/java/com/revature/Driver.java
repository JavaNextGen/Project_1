package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.welcomePage;
import com.revature.util.ConnectionFactory;

public class Driver {

    public static void main(String[] args) {
    	
    	try (
        Connection conn = ConnectionFactory.getConnection()){
			System.out.println("You did the connection thing. Good job, here's a cookie!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("OoOoOf. That Connection ain't happening, you done screwed up!");
		}
    	 
    	welcomePage newWelP = new welcomePage();
    	newWelP.welcom();
    	
    
		
    }
}
