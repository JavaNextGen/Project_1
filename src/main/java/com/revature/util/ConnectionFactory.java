package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>This ConnectionFactory class follows the Singleton Design Pattern and facilitates obtaining a connection to a Database for the ERS application.</p>
 * <p>Following the Singleton Design Pattern, the provided Constructor is private, and you obtain an instance via the {@link ConnectionFactory#getInstance()} method.</p>
 */

//This Class contains the java logic that gets a connection to our database
//It will have a method called getConnection() which will return a Connection object
//We will need this Connection object in our repository package to interact with our database
public class ConnectionFactory {
	
    private static ConnectionFactory instance;

    private ConnectionFactory() {
        super();
    }

    /**
     * <p>This method follows the Singleton Design Pattern to restrict this class to only having 1 instance.</p>
     * <p>It is invoked via:</p>
     *
     * {@code ConnectionFactory.getInstance()}
     */
    public static ConnectionFactory getInstance() {
        if(instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;
    }

    /**
     * <p>The {@link ConnectionFactory#getConnection()} method is responsible for leveraging a specific Database Driver to obtain an instance of the {@link java.sql.Connection} interface.</p>
     * <p>Typically, this is accomplished via the use of the {@link java.sql.DriverManager} class.</p>
     * @throws SQLException 
     */
   public static Connection getConnection() throws SQLException {
        
    	
    	try {
    		Class.forName("org.postgresql.Driver"); 
    	} catch (ClassNotFoundException e) {
    		System.out.println("CLASS WASN'T FOUND");
    		e.printStackTrace(); 
    	}
    	
    	String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=real_project";
    	String username = "postgres";
    	String password = "password"; 
    	
    	return DriverManager.getConnection(url, username, password);
    	
    }
}
