package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.exceptions.NewUserHasNonZeroIdException;
import com.revature.exceptions.RegistrationUnsuccessfulException;
import com.revature.exceptions.UsernameNotUniqueException;
import com.revature.models.AbstractUser;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {

	UserDAO newAdd = new UserDAO();

	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}
	
	public void getUserRegistration() {
		newAdd.getNewUsers();		
	}
	
	
	
	public List<User> getNewUsers() {
		
		List<User> users = newAdd.getNewUsers();
	
		return users;		
	}

	
	public void registerNewUsers(User newUser, AbstractUser newUsA, int useroleid, String  role, int rolz) throws RegistrationUnsuccessfulException {
		try{newAdd.registerNewUsers(newUser, newUsA, useroleid, role, rolz);
		}catch(RegistrationUnsuccessfulException re) {
			throw new RegistrationUnsuccessfulException();
		}catch(Throwable te){
			te.printStackTrace();  
		}
	}
	
	public void AuthenticateUser(String name, String password) {
		//try {
		newAdd.authuenticateUser(name, password);
	//	}catch(){
			
	//	}
		}


	/*public void getByUserName(String name) throws NewUserHasNonZeroIdException {
		try {newAdd.getByUserName(name);
		}catch(NewUserHasNonZeroIdException e) {
			throw new NewUserHasNonZeroIdException(); 	
		}catch(Throwable e) {
			 e.printStackTrace();  
		}
	}*/
	
	public List<User> getByUserName(String name) throws NewUserHasNonZeroIdException {
		try {newAdd.getByUserName(name);
		}catch(NewUserHasNonZeroIdException e) {
			throw new NewUserHasNonZeroIdException(); 	
		}catch(Throwable e) {
			 e.printStackTrace();  
		}
		return newAdd.getByUserName(name);
	}
	public void searchUserByNamePassword( String name, String password ) {
		newAdd.searchUserByNamePassword(name, password);
	}
	
	public List<User> searchUserByPassword(String password) {
		return newAdd.searchUserByPassword(password);
	}

	public int maximumUserId() {
		return newAdd.maximumUserId();
	}

public int getUserId(String username, String password) {
	return newAdd.getUserId(username, password);
	
}

	public String CheckUserRole(String name,  String password) {
		return newAdd.CheckUserRole(name, password);
	}


	   public int getUserRole(String username, String password) {
	      return newAdd.getUserRole(username, password);
	   }

	public List<User> searchUserByName(String name) throws  UsernameNotUniqueException {
		 try { newAdd.searchUserByName(name);
		 }catch(UsernameNotUniqueException ue) {
			 throw new UsernameNotUniqueException();
			 }catch(Throwable te) {
			 te.printStackTrace();
		 }
		 return newAdd.searchUserByName(name);
	}   
	
	public String getByUserNameAU(String username) throws  UsernameNotUniqueException {
		 try { newAdd.searchUserByName(username);
		 }catch(UsernameNotUniqueException ue) {
			 throw new UsernameNotUniqueException();
			 }catch(Throwable te) {
			 te.printStackTrace();
		 }
		 return newAdd.getByUserNameAU(username);
	}   
	public String getByPasswordAU(String password) throws  UsernameNotUniqueException {
		 try { newAdd.searchUserByName(password);
		 }catch(UsernameNotUniqueException ue) {
			 throw new UsernameNotUniqueException();
			 }catch(Throwable te) {
			 te.printStackTrace();
		 }
		 return newAdd.getByPasswordAU(password);
	}   
	
  }


