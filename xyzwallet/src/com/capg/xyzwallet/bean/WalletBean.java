package com.capg.xyzwallet.bean; 
  public class WalletBean { 
  	private String phoneNumber; 
  	private String fName; 
 	private String lName; 
  	private String alternateMobileNum; 
  	private String email; 
 	private String address; 
 	private double balance; 
 	private double amount;
 	 
  	   	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
		public double getBalance() { 
  		return balance; 
  	} 
  	public void setBalance(double balance) { 
 		this.balance = balance; 
  	} 
  	public String getPhoneNumber() { 
  		return phoneNumber; 
  	} 
  	public void setPhoneNumber(String phoneNumber) { 
  		this.phoneNumber = phoneNumber; 
  	} 
  	public String getfName() { 
 		return fName; 
 	} 
 	public void setfName(String fName) { 
 		this.fName = fName; 
 	} 
 	public String getlName() { 
  		return lName; 
  	} 
  	public void setlName(String lName) { 
 		this.lName = lName; 
 	} 
 	public String getAlternateMobileNum() { 
  		return alternateMobileNum; 
  	} 
  	public void setAlternateMobileNum(String alternateMobileNum) { 
  		this.alternateMobileNum = alternateMobileNum; 
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
  	public WalletBean(String phoneNumber, String fName, String lName, 
 			String alternateMobileNum, String email, String address, 
  			double balance) { 
 		super(); 
  		this.phoneNumber = phoneNumber; 
  		this.fName = fName; 
  		this.lName = lName; 
  		this.alternateMobileNum = alternateMobileNum; 
  		this.email = email; 
  		this.address = address;   		this.balance = balance; 
 	} 
  	public WalletBean() { 
 		super(); 
 	} 
   
 	 
  
   } 
