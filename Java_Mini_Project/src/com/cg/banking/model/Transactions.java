package com.cg.banking.model;

import java.time.LocalDate;

public class Transactions {
	
	private Long transactionId;
	private String transactionDescription;
	private LocalDate dateOfTransction;
	private String transactionType;
	private Long transactionAmount;
	private Long accountId;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}

	public Transactions(Long transactionId, String transactionDescription, LocalDate dateOfTransction,
			String transactionType, Long transactionAmount, Long accountId) {
		super();
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.dateOfTransction = dateOfTransction;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.accountId = accountId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public LocalDate getDateOfTransction() {
		return dateOfTransction;
	}

	public void setDateOfTransction(LocalDate dateOfTransction) {
		this.dateOfTransction = dateOfTransction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	

}
