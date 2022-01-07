package com.revature.models;

import java.util.Objects;

/**
 * This AbstractReimbursement class defines a minimum functionality for
 * interacting with reimbursements in the ERS application.
 *
 * All reimbursements in this application must at least have:
 * <ul>
 *     <li>ID</li>
 *     <li>Status</li>
 *     <li>Author</li>
 *     <li>Resolver</li>
 *     <li>Amount</li>
 * </ul>
 *
 * Additional fields can be added to the concrete {@link com.revature.models.Reimbursement} class.
 *
 * @author Center of Excellence
 */
public class AbstractReimbursement {

    private int id;
    private Status status;
    private User author;
    private User resolver;
    private double amount;
    
    private int newAuthor;
    private int newStatus;
    private int newid;



   public int getNewAuthor() {
		return newAuthor;
	}

	public void setNewAuthor(int newAuthor) {
		this.newAuthor = newAuthor;
	}

	public int getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(int newStatus) {
		this.newStatus = newStatus;
	}

	public int getNewid() {
		return newid;
	}

	public void setNewid(int newid) {
		this.newid = newid;
	}

public AbstractReimbursement(int id, Status status, User author, User resolver, double amount) {
        super();
        this.id = id;
        this.status = status;
        this.author = author;
        this.resolver = resolver;
        this.amount = amount;
    }
    
   public AbstractReimbursement(int id, int status, int author, int resolver, double amount) {
         }
   
    public AbstractReimbursement(int id, int amount, int newAuthor) {
    	this.amount=amount;
    	this.newAuthor=newAuthor;
    	this.id=id;
		
	}
/*
    public AbstractReimbursement(double amount, String name,  int id) {
    	//super();
    	this.amount=amount;
    	this.newAuthor=name;
    	this.id=id;
   	}

    */
  
    
  
  public AbstractReimbursement( double amount,  int newauthor , int newid, int newStatus) {
    	super();
    this.newid = newid;
    this.newStatus = newStatus;
    this.newAuthor = newauthor;
    this.amount = amount;
    }
    
    
    
    	
  /* 
   public AbstractReimbursement(int id, User author,  double amount) {
  		super();
  		this.id = id;
  		this.author = author;
  		this.amount = amount;
  	}
  */

   public AbstractReimbursement(int id, User newAuthor,  double amount) {
  	}
   
   public int getnewStatus() {
	   return newStatus;
   }
    public void setnewStatus(int newStatus) {
    	this.newStatus = newStatus;
    }
  
   public void setnewAuthor(int newAuthor) {
	   this. newAuthor = newAuthor;
   }
    
   
   public int getnewAuthor(){
	   return newAuthor;
   }
   
   
    public AbstractReimbursement(int id, String status) {
	
	}

	public AbstractReimbursement(int int1) {
		// TODO Auto-generated constructor stub
	}




	public AbstractReimbursement() {
	
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

   

	public void setStatus(Status status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getResolver() {
        return resolver;
    }

    public void setResolver(User resolver) {
        this.resolver = resolver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractReimbursement that = (AbstractReimbursement) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && status == that.status && Objects.equals(author, that.author) && Objects.equals(resolver, that.resolver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, author, resolver, amount);
    }

    @Override
    public String toString() {
        return "AbstractReimbursement{" +
                "id=" + id +
                ", status=" + status +
                ", author=" + author +
                ", resolver=" + resolver +
                ", amount=" + amount +
                '}';
    }
}
