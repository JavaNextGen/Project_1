package com.revature.models;

/**
 * This concrete User class can include additional fields that can be used for
 * extended functionality of the ERS application.
 *
 * Example fields:
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 * </ul>
 *
 */
public class User extends AbstractUser {

    public User() {
        super();
    }

   

	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	private String firstname;
    private String lastname;
    private String email;
    private String address;
    
    private int roleId;
    private int userId;
    

	public User(int id, String username, String password,  Role role) {
		super();
	
	}
	

	public User(String username, String password,   int roleId) {
		super();
	
	}

	public User(String firstname, String lastname, String email,  String address) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
	}
    
    public User(String username, String password, String firstname, String lastname, String email,  int roleId, String address, int userId) {
         super(username, password);

		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.roleId = roleId;
		this.userId = userId;
  	}

    public User(String username, String password, String firstname, String lastname, String email,  int roleId, String address) {
        super(username, password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.roleId = roleId;
 	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", address=" + address
				+ "]";
	}
    
    
}
