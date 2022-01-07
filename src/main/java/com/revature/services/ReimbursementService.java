
package com.revature.services;

import com.revature.models.AbstractReimbursement;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;

import java.util.Collections;
import java.util.List;

/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */
public class ReimbursementService {

   /**
    * <ul>
    *     <li>Should ensure that the user is logged in as a Finance Manager</li>
    *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
    *     <li>Should ensure that the reimbursement request exists</li>
    *     <li>Must throw exception if the reimbursement request is not found</li>
    *     <li>Should persist the updated reimbursement status with resolver information</li>
    *     <li>Must throw exception if persistence is unsuccessful</li>
    * </ul>
    *
    * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
    * The Resolver should be null. Additional fields may be null.
    * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
    */
   public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, User resolver) {
      return null;
   }

   /**
    * Should retrieve all reimbursements with the correct status.
    */
   public List<Reimbursement> getReimbursementsByStatus(Status status) {
      return Collections.emptyList();
   }

   public void getReimRqst(Reimbursement newRqst) {

   }
   
   /*
    * ***********
    */

   ReimbursementDAO newReDAO = new ReimbursementDAO();
   AbstractReimbursement newAdd  = new AbstractReimbursement();


 //  public void insertRemRq(double amount, String username1, int reimbId, int reimbus_id) {

   public void insertRemRq(AbstractReimbursement newAb) {
	   
      newReDAO.insertRemRq(newAb);
   }


   public void UpdateReimbursement(String newStatus, int requst_id, int newStatusId) {
     
	   newReDAO.UpdateRemRq(newStatus, requst_id, newStatusId);
   }

   public void GetReimbursementsbyStatus(int reim_id ) {
      newReDAO.GetReimbursementsbyId(reim_id);
   }

   public void GetReimbursementsAll2() {
      newReDAO.GetReimbursementsAll();
   }

   public List<AbstractReimbursement> GetReimbursementsAll() {
	     return  newReDAO.GetReimbursementsAll();
	   }


   public int maximumReimbId() {
      return newReDAO.maximumReimbId();
   }




   

   
}
//+------------------------------------------------------------------+
