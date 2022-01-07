package com.revature.repositories;

import com.revature.models.User;

import java.util.Optional;

import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.AbstractUser;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;





public class UserDAO {

	UsernameNotUniqueException unexc = new UsernameNotUniqueException();
	
    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
    	
    

   // public List<User> searchUserByName(String name) {
    	List<User> userSelect = new ArrayList<>();
    	
    		try {
    			Connection conn2 = ConnectionFactory.getConnection();
    			
    			ResultSet rs = null;	
    			Statement statement = conn2.createStatement();
    			
    			String sql = "SELECT * FROM ers_users " +
    			"WHERE ers_username = '"+username+"';";		
    			
    			rs = statement.executeQuery(sql);	
    	
    			while(rs.next()) {

    				User newSearchP = User(
        					rs.getString("ers_first_name"),
			//	rs.getInt("ers_newrole"),
        					rs.getString("ers_last_name"),

    					rs.getString("ers_email"),
    					rs.getString("ers_address")
    					

    					);
    				
    				userSelect.add(newSearchP);

    				}
    						
    					///return null;

    		} catch (SQLException e) {
    		System.out.println("Something went wrong selecting employees!");
    		e.printStackTrace();
    	}

    //	return null;
  //  }
      
        return Optional.empty();
    }

    private User User(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		return User(string, string, string, string);
	}

		
	/**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     *
     * Note: The userToBeRegistered will have an id=0, and username and password will not be null.
     * Additional fields may be null.
     */
    public User create(User userToBeRegistered) {
        return userToBeRegistered;
    }

   /*
    **********************************
   */

   public List<User> getNewUsers()
   {
      try{
    	  Connection conn = ConnectionFactory.getConnection();
    	  
         ResultSet userRs = null;
/*
        String sql1 = " SELECT ers_username, ers_password " +
			"ers_first_name, ers_last_name, ers_email, ers_address " +
                	       "ers_role_id FROM  ers_users;";
*/
         String sql1 = " SELECT * FROM  ers_users;";
         

         Statement statement = conn.createStatement();

         userRs = statement.executeQuery(sql1);

         List<User> userlist = new ArrayList<>();

         while(userRs.next()) {

        	 
            User newuserDetails =  new User(
            	
                 	 userRs.getString("ers_username"),
                     userRs.getString("ers_password"),
               userRs.getString("ers_first_name"),
               userRs.getString("ers_last_name"),
               userRs.getString("ers_email"),
             userRs.getInt("ers_role_id"),
            userRs.getString("ers_address"));

            
            userlist.add(newuserDetails);
	//		System.out.println("Records were retrived");

         }
         return userlist;
         
      }catch(Exception e) {
			e.printStackTrace();
      }
      return null;
   }

   /*
    * ****************************
    */
   
   public void registerNewUsers(User newUser, AbstractUser newUsA, int userroleid, String role, int rolz) throws UsernameNotUniqueException
   {

      try{
    	  Connection conn = ConnectionFactory.getConnection();
    	  
  	    conn.setAutoCommit(false);   


        String sql3 = "INSERT INTO ers_user_roles(ers_user_role_id, user_role) "
        				+ " VALUES(?, ?);";
        				
        PreparedStatement newUserSt2 = conn.prepareStatement(sql3);

        newUserSt2.setInt(1, userroleid);
        newUserSt2.setString(2, role);
        
        newUserSt2.executeUpdate();

         String sql2 = "INSERT INTO ers_users(ers_user_id, ers_username,ers_password,"
        		 + "ers_first_name,ers_last_name, ers_email, " + 
        		 "  ers_role_id,  ers_address)"
         				+ "VALUES(?, ?, ?, ?, ? ,? ,?, ?);";
         				
         
         PreparedStatement newUserSt = conn.prepareStatement(sql2);
 
         newUserSt.setInt(1,  userroleid);
         newUserSt.setString(2, newUsA.getUsername());
         newUserSt.setString(3, newUsA.getPassword());
         newUserSt.setString(4, newUser.getFirstname());
         newUserSt.setString(5, newUser.getLastname());
         newUserSt.setString(6, newUser.getEmail());
         newUserSt.setInt(7, rolz);
         newUserSt.setString(8, newUser.getAddress());
	 

         
         newUserSt.executeUpdate();
         
         conn.commit();
         System.out.println("New user " + newUser.getUsername() + " was added to the database");
          
         }catch(UsernameNotUniqueException une) {
        	 throw new UsernameNotUniqueException();
         } catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         }
      
   

   public String authuenticateUser(String name, String password) {
		String resultz = new String(); 

			try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet rs = null;	
			Statement statement = conn2.createStatement();
			
			String sql = "SELECT DISTINCT ers_username FROM ers_users " +
			"WHERE ers_username = '"+name+"' AND ers_password= '"+password+"';";		
			
			rs = statement.executeQuery(sql);	

			while(rs.next()) {
				resultz = rs.getString("ers_username");
			}
	
			return resultz;

		} catch (SQLException e) {
			
			System.out.println(" employees LOGIN details not found!");
			e.printStackTrace();
		}

	return resultz;
}





	public List<AbstractUser> searchUserByName(String name) {
	List<AbstractUser> userSelect = new ArrayList<>();
	
		try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet rs = null;
			
		
			
			String sql = "SELECT * FROM ers_users " +
			"WHERE ers_username = ? ;";		
			
			PreparedStatement ps = conn2.prepareStatement(sql);

			ps.setString(1, name);	
			
			rs = ps.executeQuery(sql);		

	
			while(rs.next()) {

				AbstractUser newSearchP = new AbstractUser(
					rs.getString("ers_username"),
					rs.getString("ers_password"));
				
				userSelect.add(newSearchP);
			}
					return userSelect;

		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}

	return null;
}
  

/*
 * *************************************
 */
	
	
public List<AbstractUser> searchUserByNamePassword(String name, String password) {
	List<AbstractUser> userSelect = new ArrayList<>();
	
		try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet rs = null;	
		

			String sql = "SELECT * FROM ers_users " +
			"WHERE  ers_name = ? AND ers_password = ? ;";		
		
			PreparedStatement ps = conn2.prepareStatement(sql);

			ps.setString(1, name);		
			ps.setString(2, password);
			
			rs = ps.executeQuery(sql);		
		
			while(rs.next()) {
				System.out.println(rs.getString("ers_username"));
				
				AbstractUser newSearchP = new AbstractUser(
					rs.getString("ers_username"),
					rs.getString("ers_password"));
				
				userSelect.add(newSearchP);
				
			}
			
			return userSelect;
			
		} catch (SQLException e) {
			System.out.println("No records were found");
			e.printStackTrace();
		}
	return null;
}


/* 
 * ******************************
 */

public List<AbstractUser> searchUserByPassword(String password) {
	List<AbstractUser> userSelect = new ArrayList<>();
	
		try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet rs = null;	
	
			String sql = "SELECT * FROM urs_users " +
			"WHERE ers_user_password = ? ;";		
		
			
			PreparedStatement ps = conn2.prepareStatement(sql);

			ps.setString(1, password);	
			
			rs = ps.executeQuery(sql);
			
			
			while(rs.next()) {
				System.out.println(rs.getString("ers_username"));
				
				AbstractUser newSearchI = new AbstractUser(
					rs.getString("ers_username"),
					rs.getString("ers_password"));
			
			userSelect.add(newSearchI);
			}
			System.out.println("Records were found, apply for ur reimbursement " + userSelect );

			return userSelect;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting employees!");
			e.printStackTrace();
		}
	return null;
}


public int maximumUserId() {
	int resultz = 0; 

		try {
		Connection conn2 = ConnectionFactory.getConnection();
		
		ResultSet rs = null;	
	
		
		String sql = "SELECT max(ers_user_id) as Max_Id FROM ers_users;";	
		
		Statement ps = conn2.createStatement();

		//PreparedStatement ps = conn2.prepareStatement(sql);
		
		rs = ps.executeQuery(sql);
	

		while(rs.next()) {
			resultz = rs.getInt("Max_Id");
		}

		return resultz;

	} catch (SQLException e) {
		System.out.println("Something went wrong selecting employees!");
		e.printStackTrace();
	}

return resultz;
}

/*
public String CheckUserRole(String username, String password) throws UsernameNotUniqueException {
	String resultz = ""; 

		try {
		Connection conn2 = ConnectionFactory.getConnection();
		
		ResultSet rs = null;	
		Statement statement = conn2.createStatement();
		
		String sql = "SELECT ers_role FROM ers_user_roles AS ur inner join ers_users AS u on " +
				" ur.ers_user_role_id = u.ers_role_id  " +
				"WHERE ers_username = '"+username+"' AND ers_password= '"+password+"';";
		

		rs = statement.executeQuery(sql);	

		while(rs.next()) {
			resultz = rs.getString("ers_role");
		}

		return resultz;

	} catch (UsernameNotUniqueException | SQLException e) {
		throw new UsernameNotUniqueException("Something went wrong selecting employees!");
	
	}
		return resultz;

}

*/

public String CheckUserRole(String username, String password) throws UsernameNotUniqueException {
	String resultz = ""; 

		try {
		Connection conn2 = ConnectionFactory.getConnection();
		
		ResultSet rs = null;	
		Statement statement = conn2.createStatement();
		
		String sql = "SELECT user_role FROM ers_user_roles AS ur join ers_users AS u on " +
				" ur.ers_user_role_id = u.ers_role_id  " +
				"WHERE u.ers_username = '"+username+"' AND u.ers_password= '"+password+"';";
	
				
		rs = statement.executeQuery(sql);	

		while(rs.next()) {
			resultz = rs.getString("user_role");
		}

		return resultz;

	} catch ( SQLException e) {
		System.out.println("Something went wrong verfying role!");
	
	}
		return resultz;

}

public int getUserRole(String username, String password) {
	int resultz = 0; 

		try {
		Connection conn2 = ConnectionFactory.getConnection();
		
		ResultSet rs = null;	
		Statement statement = conn2.createStatement();
		
		String sql = "SELECT ers_role_id FROM ers_users " +
		"WHERE ers_username = '"+username+"' AND ers_password= '"+password+"';";		
		
		rs = statement.executeQuery(sql);	

		while(rs.next()) {
			resultz = rs.getInt("ers_role_id");
		}

		return resultz;

	} catch (SQLException e) {
		System.out.println("Something went wrong selecting employees!");
		e.printStackTrace();
	}

return resultz;
}

public void getByUserName(String name) {
	// TODO Auto-generated method stub
	
}



public int getUserId(String username, String password) {
	int resultz = 0; 

		try {
		Connection conn2 = ConnectionFactory.getConnection();
		
		ResultSet rs = null;	
		Statement statement = conn2.createStatement();
		
		String sql = "SELECT ers_user_id FROM ers_users " +
		"WHERE ers_username = '"+username+"' AND ers_password= '"+password+"';";		
		
		rs = statement.executeQuery(sql);	

		while(rs.next()) {
			resultz = rs.getInt("ers_user_id");
		}

		return resultz;

	} catch (SQLException e) {
		System.out.println("Something went wrong selecting employees!");
		e.printStackTrace();
	}

return resultz;
}

}
