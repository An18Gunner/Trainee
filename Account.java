package com.training.entity;

public class Account {
	private int accID;
	private int accNo;
	private double accBalance;
	private double accAvgBalance;
	
	public Account() {}
	
	public Account(int accID, int accNo, double accBalance, double accAvgBalance) {
		super();
		this.accID = accID;
		this.accNo = accNo;
		this.accBalance = accBalance;
		this.accAvgBalance = accAvgBalance;
	}
	
	
	
	@Override
	public String toString() {
		return "Account ID = " + accID + ", Account No = " + accNo + ", with Balance = " + accBalance + ", and Avg Balance = "
				+ accAvgBalance;
	}

	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public double getAccAvgBalance() {
		return accAvgBalance;
	}
	public void setAccAvgBalance(double accAvgBalance) {
		this.accAvgBalance = accAvgBalance;
	}
	
	
	

}
