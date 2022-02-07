package com.dbms;

public class AccountInfo 
{
	private long    accountNo;
	private double  balance;
	private long    customerId;
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "AccountInfo [accountNo=" + accountNo + ", balance=" + balance + ", customerId=" + customerId + "]";
	}	
}
