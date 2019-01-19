package com.cg.banking.model;

public class CustomerTable {
	
	private String address;
	private long mobileNumber;
	public CustomerTable() {
		// TODO Auto-generated constructor stub
	}
	public CustomerTable(String address, long mobileNumber) {
		super();
		this.address = address;
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	

}
