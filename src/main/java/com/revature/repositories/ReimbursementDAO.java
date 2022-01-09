package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.revature.models.AbstractReimbursement;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;




public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
    
    /*
     * *****************
     * **************
     * */
    
    
    
// public void insertRemRq(double amount , String author, int typeId , int reimbus_id){

     
  public void insertRemRq(AbstractReimbursement newRe){

       try{
    	   Connection conn = ConnectionFactory.getConnection();
    	   conn.setAutoCommit (false);
    	   
       
          
          String sql3 = "INSERT INTO ers_reimbursement_status(reimb_Status_id, reimb_Status )"
    				+ "VALUES(?,?)";
    				
          PreparedStatement newUserSt2 = conn.prepareStatement(sql3);
          
          newUserSt2.setInt(1, newRe.getNewid() );
          newUserSt2.setString(2, "PENDING");
          
          
          String sql2 = "INSERT INTO ers_reimbursement(reimb_id, reimb_type_id, reimb_author, reimb_amount )"
          				+ "VALUES(?, ?,?,?)";
          				
          PreparedStatement newUserSt = conn.prepareStatement(sql2);
          
          newUserSt.setInt(1, newRe.getId());
          newUserSt.setInt(2, newRe.getNewid());
          newUserSt.setInt(3, newRe.getId());
          newUserSt.setDouble(4, newRe.getAmount());
      
          
          newUserSt.executeUpdate();
          
     
          newUserSt2.executeUpdate();   
     
          conn.setAutoCommit (true);

          System.out.println("New Reimb. Request for $" + newRe.getAmount() + " was logged");
          }catch(Exception e) {
         //	 System.out.println("Unable to add new Request");
         	 e.printStackTrace();
          }
          }
    
   
   public void UpdateRemRq(String newStatus, int requst_id, int new_Status_id){
   	
      try{Connection conn = ConnectionFactory.getConnection();
	   conn.setAutoCommit (false);

         String sql3 = "UPDATE ers_reimbursement SET  )"
         				+ "reimb_status_id = ?, WHERE reimb_id = ?; ";
         				
         PreparedStatement newAppr = conn.prepareStatement(sql3);
         
         newAppr.setInt(1, new_Status_id);
         newAppr.setInt(2, requst_id);
         
        
         
         String sql4 = "UPDATE ers_reimbursement_status SET  )"
  				+ "reimb_status = ?, WHERE reimb_id = ? ; ";
  				
         PreparedStatement newAppr2 = conn.prepareStatement(sql4);
  
         newAppr2.setString(1, newStatus);
         newAppr2.setInt(2, requst_id);
         
        // newAppr2.executeUpdate();
        // newAppr.executeUpdate();
  
         conn.setAutoCommit (true);
  
         System.out.println("Reimburement" + requst_id + " was " + newStatus);
         
         }catch(Exception e) {
        	 System.out.println("Unable to update info");
         	 e.printStackTrace();

         }
      }
   /*
    * ******************
    */
   
   
public List<AbstractReimbursement> GetReimbursementsbyId(int reim_id) {
	
		try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet Reim = null;	
			Statement statement = conn2.createStatement();

			String sql = "SELECT reimb_id,reimb_status_id, reimb_Author,reimb_amount FROM ers_reimbursement " +
			"WHERE reimb_id = '"+reim_id+"';";		
			
			Reim = statement.executeQuery(sql);	
			List<AbstractReimbursement> searchReim = new ArrayList<>();

			while(Reim.next()) {
				 
				//result = Reim.getInt("reimb_id");
				AbstractReimbursement newSearchA = new AbstractReimbursement(
						Reim.getDouble("reimb_amount"),
						Reim.getInt("reimb_Author"),
						Reim.getInt("reimb_id"),
						Reim.getInt("reimb_status_id")
						);
						
						
				searchReim.add(newSearchA);
			}
			
			return searchReim;
			
		} catch (SQLException e) {
			System.out.println("Unable to retrive infomation!");
			e.printStackTrace();
		}
	return null;
}



public List<AbstractReimbursement> GetReimbursementsbyStatus(int reim_status) {
	
	try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet Reim = null;	
			Statement statement = conn2.createStatement();

			String sql = "SELECT reimb_id,reimb_status_id, reimb_Author,reimb_amount FROM ers_reimbursement " +
			"WHERE reimb_status_id = '"+reim_status+"';";		
			
			Reim = statement.executeQuery(sql);	
			
			List<AbstractReimbursement> searchReim = new ArrayList<>();

			while(Reim.next()) {
				 
					
					AbstractReimbursement newSearchA = new AbstractReimbursement(
							Reim.getDouble("reimb_amount"),
							Reim.getInt("reimb_Author"),
							Reim.getInt("reimb_id"),
							Reim.getInt("reimb_status_id")
							);
							
							
							
					searchReim.add(newSearchA);
				}
				
				return searchReim;
			
		} catch (SQLException e) {
			System.out.println("unable to retrive infomation!");
			e.printStackTrace();
		}
	return null;
}



public void GetReimbursementsAll2() {


	try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet Reim = null;	
			Statement statement = conn2.createStatement();

			String sql = "SELECT reimb_id,reimb_status_id, reimb_Author,reimb_amount FROM ers_reimbursement " +
			"WHERE reimb_status_id = 1 ;";		
			
			Reim = statement.executeQuery(sql);	
			
			List<AbstractReimbursement> searchReim = new ArrayList<>();

			while(Reim.next()) {
				 
					
					AbstractReimbursement newSearchA = new AbstractReimbursement(
							Reim.getDouble("reimb_amount"),
							Reim.getInt("reimb_Author"),
							Reim.getInt("reimb_id"),
							Reim.getInt("reimb_status_id")
							);
							
					searchReim.add(newSearchA);
				}
				
				//return searchReim;
			
		} catch (SQLException e) {
			System.out.println("unable to retrive infomation!");
			e.printStackTrace();
		}
	//return null;
}



public List<AbstractReimbursement> GetReimbursementsAll() {


	try {
			Connection conn2 = ConnectionFactory.getConnection();
			
			ResultSet Reim = null;	
			Statement statement = conn2.createStatement();

			String sql = "SELECT reimb_id,reimb_status_id, reimb_Author,reimb_amount FROM ers_reimbursement " +
			"WHERE reimb_status_id = 1 ;";		
			
			Reim = statement.executeQuery(sql);	
			
			List<AbstractReimbursement> searchReim = new ArrayList<>();

			while(Reim.next()) {
				 
					
					AbstractReimbursement newSearchA = new AbstractReimbursement(
							Reim.getDouble("reimb_amount"),
							Reim.getInt("reimb_Author"),
							Reim.getInt("reimb_id"),
							Reim.getInt("reimb_status_id")
							);
							
							
							
					searchReim.add(newSearchA);
				}
				
				return searchReim;
			
		} catch (SQLException e) {
			System.out.println("unable to retrive infomation!");
			e.printStackTrace();
		}
	return null;
}




public int maximumReimbId() {
	int resultz = 0; 

		try {
		Connection conn2 = ConnectionFactory.getConnection();
		
		ResultSet rs = null;	
		Statement statement = conn2.createStatement();
		
		String sql = "SELECT max(reimb_id) as reimbus_id FROM ers_reimbursement;";		
		
		rs = statement.executeQuery(sql);	

		while(rs.next()) {
			resultz = rs.getInt("reimbus_id");
		}

		return resultz;

	} catch (SQLException e) {
		System.out.println("Something went wrong selecting employees!");
		e.printStackTrace();
	}

return resultz;
}

    
}






  

