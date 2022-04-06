package com;

public class AccountDetails {
	private int accno;
	private static int saccno = 1001;
    private String name;  
    private String acc_type;
    private int balance;
    private String password;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public static int getSaccno() {
		return saccno;
	}
	public static void setSaccno(int saccno) {
		AccountDetails.saccno = saccno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AccountDetails(String name, String acc_type, int balance, String password) {
		super();
		this.name = name;
		this.acc_type = acc_type;
		this.balance = balance;
		this.password = password;
		this.accno = saccno++;
	}
	public AccountDetails() {
		super();
	}
	@Override
	public String toString() {
		return "[accno=" + accno + ", name=" + name + ", acc_type=" + acc_type + ", balance=" + balance
				+ ", password=" + password + "]";
	}
    	    
}
