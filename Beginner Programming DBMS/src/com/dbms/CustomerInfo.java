package com.dbms;

import java.io.Serializable;

public class CustomerInfo implements Serializable{
	
	private String customerName;
	private String dob;
	private String address;
	private long   customerId; 
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "CustomerInfo [customerName=" + customerName + ", dob=" + dob + ", address=" + address + ", customerId="
				+ customerId + "]";
	}	
}	