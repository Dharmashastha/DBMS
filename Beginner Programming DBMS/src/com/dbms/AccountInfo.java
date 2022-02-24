package com.dbms;

import java.io.Serializable;

public class AccountInfo implements Serializable
{
	private long    accountNo;
	private double  balance;
	private long    customerId;
	private boolean status=true;
	
	
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "AccountInfo [accountNo=" + accountNo + ", balance=" + balance + ", customerId=" + customerId
				+ ", status=" + status + "]";
	}	
}
