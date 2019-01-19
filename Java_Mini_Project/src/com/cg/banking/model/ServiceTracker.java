package com.cg.banking.model;

import java.time.LocalDate;

public class ServiceTracker {
	
	private long serviceId;
	private String serviceDescription;
	private LocalDate requestDate;
	private long accountId;
	private String serviceStatus;
	
	public ServiceTracker() {
		// TODO Auto-generated constructor stub
	}

	public ServiceTracker(long serviceId, String serviceDescription, LocalDate requestDate, long accountId,
			String serviceStatus) {
		super();
		this.serviceId = serviceId;
		this.serviceDescription = serviceDescription;
		this.requestDate = requestDate;
		this.accountId = accountId;
		this.serviceStatus = serviceStatus;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	

}
