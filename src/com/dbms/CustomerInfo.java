package com.dbms;

public class CustomerInfo {
	
	private String customerName;
	private String dob;
	private String address;
	
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
	
	
	@Override
	public String toString() {
		return "CustomerInfo [customerName=" + customerName + ", dob=" + dob + ", address=" + address + "]";
	}	
}	